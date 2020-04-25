package dev.pch.security;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.pch.domains.Collaborateur;
import dev.pch.repository.CollaborateurRepo;
import dev.pch.vm.CollaborateurVM;
import io.jsonwebtoken.Jwts;

/**
 * Gestion de la réponse HTTP en cas d'authentification à succès.
 */
@Configuration
public class JWTAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private static final Logger LOG = LoggerFactory.getLogger(JWTAuthenticationSuccessHandler.class);

	@Value("${jwt.expires_in}")
	private Integer EXPIRES_IN;

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Value("${jwt.secret}")
	private String SECRET;

	@Autowired
	private CollaborateurRepo collaborateurRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	@Transactional
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		LOG.info("Génération du token JWT");

		User user = (User) authentication.getPrincipal();

		String rolesList = user.getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.joining(","));

		Collaborateur collaborateur = collaborateurRepo.findByEmail(user.getUsername())
				.orElseThrow(() -> new IllegalArgumentException("L'email ne correspond à aucun collaborateur"));

		response.setContentType("application/json");
		response.getWriter().write(mapper.writeValueAsString(new CollaborateurVM(collaborateur)));

		Map<String, Object> infosSupplementaireToken = new HashMap<>();
		infosSupplementaireToken.put("roles", rolesList);
		LOG.info("roles {} ", infosSupplementaireToken);

		String jws = Jwts.builder().setSubject(user.getUsername()).addClaims(infosSupplementaireToken)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRES_IN * 1000))
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET).compact();

		Cookie authCookie = new Cookie(TOKEN_COOKIE, (jws));
		authCookie.setHttpOnly(true);
		authCookie.setMaxAge(EXPIRES_IN * 1000);
		authCookie.setPath("/");
		response.addCookie(authCookie);
		LOG.info("Token JWT généré posé dans un cookie et en entête HTTP");
	}
}
