/**
 * 
 */
package dev.pch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.pch.domains.Activites;
import dev.pch.domains.Criticite;
import dev.pch.domains.Dangers;
import dev.pch.domains.Frequence;
import dev.pch.domains.Gravite;
import dev.pch.domains.Lieu;
import dev.pch.domains.Risques;
import dev.pch.domains.Ut;
import dev.pch.repository.ActivitesRepo;
import dev.pch.repository.CollaborateurRepo;
import dev.pch.repository.CriticiteRepo;
import dev.pch.repository.DangersRepo;
import dev.pch.repository.DuerRepo;
import dev.pch.repository.FrequenceRepo;
import dev.pch.repository.GraviteRepo;
import dev.pch.repository.LieuRepo;
import dev.pch.repository.PlanActionSpecifiqueRepo;
import dev.pch.repository.PreventionExistanteRepo;
import dev.pch.repository.PreventionMiseEnOeuvreRepo;
import dev.pch.repository.RisquesRepo;
import dev.pch.repository.UtRepo;

/**
 * @author Thierry Dumas
 *
 */
@Component
public class GduStartupListener {
	private static final Logger LOG = LoggerFactory.getLogger(GduStartupListener.class);

	private ActivitesRepo activitesRepo;
	private CriticiteRepo criticiteRepo;
	private DangersRepo dangerRepo;
	private DuerRepo duerRepo;
	private FrequenceRepo frequenceRepo;
	private GraviteRepo graviteRepo;
	private LieuRepo lieuRepo;
	private PlanActionSpecifiqueRepo planActionSpecifiqueRepo;
	private PreventionExistanteRepo preventionExistanteRepo;
	private PreventionMiseEnOeuvreRepo preventionMiseEnOeuvreRepo;
	private RisquesRepo risqueRepo;
	private UtRepo utRepo;
	private CollaborateurRepo collaborateurRepo;
	private PasswordEncoder passwordEncoder;

	public GduStartupListener(ActivitesRepo activitesRepo, CriticiteRepo criticiteRepo, DangersRepo dangerRepo,
			DuerRepo duerRepo, FrequenceRepo frequenceRepo, GraviteRepo graviteRepo, LieuRepo lieuRepo,
			PlanActionSpecifiqueRepo planActionSpecifiqueRepo, PreventionExistanteRepo preventionExistanteRepo,
			PreventionMiseEnOeuvreRepo preventionMiseEnOeuvreRepo, RisquesRepo risqueRepo, UtRepo utRepo,
			CollaborateurRepo collaborateurRepo, PasswordEncoder passwordEncoder) {
		super();
		this.activitesRepo = activitesRepo;
		this.criticiteRepo = criticiteRepo;
		this.dangerRepo = dangerRepo;
		this.duerRepo = duerRepo;
		this.frequenceRepo = frequenceRepo;
		this.graviteRepo = graviteRepo;
		this.lieuRepo = lieuRepo;
		this.planActionSpecifiqueRepo = planActionSpecifiqueRepo;
		this.preventionExistanteRepo = preventionExistanteRepo;
		this.preventionMiseEnOeuvreRepo = preventionMiseEnOeuvreRepo;
		this.risqueRepo = risqueRepo;
		this.utRepo = utRepo;
		this.collaborateurRepo = collaborateurRepo;
		this.passwordEncoder = passwordEncoder;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		/** Création Gravité */

		/** valeur fixe */
		/*
		 * Frequence, gravite, criticite
		 */
		Gravite gravite1 = new Gravite(1, 1);
		this.graviteRepo.save(gravite1);
		Gravite gravite2 = new Gravite(2, 3);
		this.graviteRepo.save(gravite2);
		Gravite gravite3 = new Gravite(3, 5);
		this.graviteRepo.save(gravite3);
		Gravite gravite4 = new Gravite(4, 15);
		this.graviteRepo.save(gravite4);

		Frequence frequence1 = new Frequence(1, 1);
		this.frequenceRepo.save(frequence1);
		Frequence frequence2 = new Frequence(2, 2);
		this.frequenceRepo.save(frequence2);
		Frequence frequence3 = new Frequence(3, 3);
		this.frequenceRepo.save(frequence3);
		Frequence frequence4 = new Frequence(4, 4);
		this.frequenceRepo.save(frequence4);

		Criticite criticite1 = new Criticite(1, gravite1.getValeur() * frequence1.getValeur());
		this.criticiteRepo.save(criticite1);
		Criticite criticite2 = new Criticite(2, gravite2.getValeur() * frequence1.getValeur());
		this.criticiteRepo.save(criticite2);
		Criticite criticite3 = new Criticite(3, gravite3.getValeur() * frequence1.getValeur());
		this.criticiteRepo.save(criticite3);
		Criticite criticite4 = new Criticite(4, gravite4.getValeur() * frequence1.getValeur());
		this.criticiteRepo.save(criticite4);
		Criticite criticite5 = new Criticite(5, gravite1.getValeur() * frequence2.getValeur());
		this.criticiteRepo.save(criticite5);
		Criticite criticite6 = new Criticite(6, gravite2.getValeur() * frequence2.getValeur());
		this.criticiteRepo.save(criticite6);
		Criticite criticite7 = new Criticite(7, gravite3.getValeur() * frequence2.getValeur());
		this.criticiteRepo.save(criticite7);
		Criticite criticite8 = new Criticite(8, gravite4.getValeur() * frequence2.getValeur());
		this.criticiteRepo.save(criticite8);
		Criticite criticite9 = new Criticite(9, gravite1.getValeur() * frequence3.getValeur());
		this.criticiteRepo.save(criticite9);
		Criticite criticite10 = new Criticite(10, gravite2.getValeur() * frequence3.getValeur());
		this.criticiteRepo.save(criticite10);
		Criticite criticite11 = new Criticite(11, gravite3.getValeur() * frequence3.getValeur());
		this.criticiteRepo.save(criticite11);
		Criticite criticite12 = new Criticite(12, gravite4.getValeur() * frequence3.getValeur());
		this.criticiteRepo.save(criticite12);
		Criticite criticite13 = new Criticite(13, gravite1.getValeur() * frequence4.getValeur());
		this.criticiteRepo.save(criticite13);
		Criticite criticite14 = new Criticite(14, gravite2.getValeur() * frequence4.getValeur());
		this.criticiteRepo.save(criticite14);
		Criticite criticite15 = new Criticite(15, gravite3.getValeur() * frequence4.getValeur());
		this.criticiteRepo.save(criticite15);
		Criticite criticite16 = new Criticite(16, gravite4.getValeur() * frequence4.getValeur());
		this.criticiteRepo.save(criticite16);

		/* Valeurs Lieu */

		Lieu lieu1 = new Lieu(1, "Atelier Carcassonne");
		this.lieuRepo.save(lieu1);
		Lieu lieu2 = new Lieu(2, "Atelier vente");
		this.lieuRepo.save(lieu2);
		Lieu lieu3 = new Lieu(3, "Atelier bois");
		this.lieuRepo.save(lieu3);
		Lieu lieu4 = new Lieu(4, "Atelier TLC");
		this.lieuRepo.save(lieu4);
		Lieu lieu5 = new Lieu(5, "Atelier Vélo");
		this.lieuRepo.save(lieu5);
		Lieu lieu6 = new Lieu(6, "Atelier Livre");
		this.lieuRepo.save(lieu6);
		Lieu lieu7 = new Lieu(7, "Atelier DEEE");
		this.lieuRepo.save(lieu7);
		Lieu lieu8 = new Lieu(8, "Atelier vaisselle");
		this.lieuRepo.save(lieu8);
		Lieu lieu9 = new Lieu(9, "Salle de Réunion collecte");
		this.lieuRepo.save(lieu9);
		Lieu lieu10 = new Lieu(10, "Garage EV (Espace Vert)");
		this.lieuRepo.save(lieu10);
		Lieu lieu11 = new Lieu(11, "Vestiaire EV");
		this.lieuRepo.save(lieu11);
		Lieu lieu12 = new Lieu(12, "Salle carburant EV");
		this.lieuRepo.save(lieu12);
		Lieu lieu13 = new Lieu(13, "Salle Rangement matériel EV");
		this.lieuRepo.save(lieu13);
		Lieu lieu14 = new Lieu(14, "Salle Réunion et Informatique");
		this.lieuRepo.save(lieu14);
		Lieu lieu15 = new Lieu(15, "Stockage magasin");
		this.lieuRepo.save(lieu15);
		Lieu lieu16 = new Lieu(16, "Chaudière");
		this.lieuRepo.save(lieu16);
		Lieu lieu17 = new Lieu(17, "Vitrine magasin");
		this.lieuRepo.save(lieu17);

		/* Valeur définie INRS */

		Risques risque1 = new Risques(1, "Organisation du travail");
		this.risqueRepo.save(risque1);
		Risques risque2 = new Risques(2, "Travail isolé");
		this.risqueRepo.save(risque2);
		Risques risque3 = new Risques(3, "Violence travail, d’agression");
		this.risqueRepo.save(risque3);
		Risques risque4 = new Risques(4, "Travail sur écran");
		this.risqueRepo.save(risque4);
		Risques risque5 = new Risques(5, "Rayonnements");
		this.risqueRepo.save(risque5);
		Risques risque6 = new Risques(6, "Eclairage");
		this.risqueRepo.save(risque6);
		Risques risque7 = new Risques(7, "Incendie et explosion");
		this.risqueRepo.save(risque7);
		Risques risque8 = new Risques(8, "Energie : électricité, gaz, air comprimé");
		this.risqueRepo.save(risque8);
		Risques risque9 = new Risques(9, "Bruit");
		this.risqueRepo.save(risque9);
		Risques risque10 = new Risques(10, "Utilisation de machines");
		this.risqueRepo.save(risque10);
		Risques risque11 = new Risques(11, "Chutes d’objet");
		this.risqueRepo.save(risque11);
		Risques risque12 = new Risques(12, "Chutes : de hauteur, de plain-pied");
		this.risqueRepo.save(risque12);
		Risques risque13 = new Risques(13, "Agents infectieux");
		this.risqueRepo.save(risque13);
		Risques risque14 = new Risques(14, "Produits chimiques");
		this.risqueRepo.save(risque14);
		Risques risque15 = new Risques(15, "Conduite (risque routier professionnel)");
		this.risqueRepo.save(risque15);
		Risques risque16 = new Risques(16, "Manutention mécanique");
		this.risqueRepo.save(risque16);
		Risques risque17 = new Risques(17, "Manutention manuelle,  la posture ou geste répétitif");
		this.risqueRepo.save(risque17);
		Risques risque18 = new Risques(18, "Ambiances thermiques (chaude ou froide)");
		this.risqueRepo.save(risque18);
		Risques risque19 = new Risques(19, "Travail par de fortes chaleurs");
		this.risqueRepo.save(risque19);

		// Création de collaborateurs

		/*
		 * Collaborateur col1 = new Collaborateur(); col1.setNom("Admin");
		 * col1.setPrenom("DEV"); col1.setEmail("admin@dev.fr");
		 * col1.setMotDePasse(passwordEncoder.encode("superpass"));
		 * col1.setRoles(Arrays.asList(new RoleCollaborateur(col1,
		 * Role.ROLE_ADMINISTRATEUR))); this.collaborateurRepo.save(col1);
		 * 
		 * Collaborateur col2 = new Collaborateur(); col2.setNom("User");
		 * col2.setPrenom("DEV"); col2.setEmail("user@dev.fr");
		 * col2.setMotDePasse(passwordEncoder.encode("superpass"));
		 * col2.setRoles(Arrays.asList(new RoleCollaborateur(col2,
		 * Role.ROLE_UTILISATEUR))); this.collaborateurRepo.save(col2);
		 */
		/************************************************************************/

		Activites activite = new Activites(1, "Vente");
		Dangers danger = new Dangers(1, "Perçer");
		this.dangerRepo.save(danger);
		Dangers danger1 = new Dangers(2, "Peindre");
		this.dangerRepo.save(danger1);
		Dangers danger2 = new Dangers(3, "Couper");

		this.activitesRepo.save(activite);
		this.dangerRepo.save(danger2);

		Ut ut1 = new Ut(1, "Revalorisation");
		this.utRepo.save(ut1);
		Ut ut2 = new Ut(2, "Logistique");
		this.utRepo.save(ut2);
		Ut ut3 = new Ut(3, "Vente");
		this.utRepo.save(ut3);
	}
}
