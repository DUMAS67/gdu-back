/**
 * 
 */
package dev.pch.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.pch.domains.Activites;
import dev.pch.domains.Dangers;
import dev.pch.domains.Duer;
import dev.pch.domains.DuerClef;
import dev.pch.domains.DuerFront;
import dev.pch.domains.Frequence;
import dev.pch.domains.Gravite;
import dev.pch.domains.Lieu;
import dev.pch.domains.Risques;
import dev.pch.domains.Ut;
import dev.pch.exception.BadRequestException;
import dev.pch.exception.ElementNotFoundException;
import dev.pch.exception.ForbiddenOperationException;
import dev.pch.repository.ActivitesRepo;
import dev.pch.repository.DangersRepo;
import dev.pch.repository.DuerRepo;
import dev.pch.repository.FrequenceRepo;
import dev.pch.repository.GraviteRepo;
import dev.pch.repository.LieuRepo;
import dev.pch.repository.RisquesRepo;
import dev.pch.repository.UtRepo;
import dev.pch.vm.DuerVM;
import dev.pch.vm.LieuVM;
import dev.pch.vm.UtVM;

/**
 * @aDuerhor Thierry Dumas
 *
 */

@RestController

public class DuerController {

	private DuerRepo duerRepo;
	private UtRepo utRepo;
	private LieuRepo lieuRepo;
	private ActivitesRepo activitesRepo;
	private DangersRepo dangersRepo;
	private RisquesRepo risquesRepo;
	private GraviteRepo graviteRepo;
	private FrequenceRepo frequenceRepo;
	boolean prevMoExist = false;
	boolean prevExist = false;
	private static final Logger LOG = LoggerFactory.getLogger(dev.pch.controller.DuerController.class);

	public DuerController(DuerRepo duerRepo, UtRepo utRepo, LieuRepo lieuRepo, ActivitesRepo activitesRepo,
			DangersRepo dangersRepo, RisquesRepo risquesRepo, GraviteRepo graviteRepo, FrequenceRepo frequenceRepo) {
		super();
		this.duerRepo = duerRepo;
		this.utRepo = utRepo;
		this.lieuRepo = lieuRepo;
		this.activitesRepo = activitesRepo;
		this.dangersRepo = dangersRepo;
		this.risquesRepo = risquesRepo;
		this.graviteRepo = graviteRepo;
		this.frequenceRepo = frequenceRepo;

	}

	@RequestMapping(method = RequestMethod.GET, path = "duers")
	public List<DuerVM> listerDuer() {
		List<Duer> listeDuer = this.duerRepo.findAll();

		return listeDuer.stream().map(r -> new DuerVM(r)).collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, path = "duerf")
	public List<DuerFront> listerDuerFront() {
		List<Duer> listeDuer = this.duerRepo.findAll();

		return listeDuer.stream().map(r -> changeFront(r)).collect(Collectors.toList());
	}

	public DuerFront changeFront(Duer duer) {

		DuerFront duerFront = new DuerFront(null, null, null, null, null, null, null, null, null, null, null, null,
				null, null);
		duerFront.setId(duer.getId());
		duerFront.setUt(duer.getUt().getNom());
		duerFront.setLieu(duer.getLieu().getNom());
		duerFront.setActivite(duer.getActivite().getNom());
		duerFront.setDanger(duer.getDanger().getNom());
		duerFront.setRisque(duer.getRisque().getNom());
		duerFront.setGravite_Ex(duer.getGravite_Ex().getValeur());
		duerFront.setFrequence_Ex(duer.getFrequence_Ex().getValeur());
		duerFront.setPrevExistante(duer.getPrevExistante());
		duerFront.setGravite_Mo(duer.getGravite_Mo().getValeur());
		duerFront.setFrequence_Mo(duer.getFrequence_Mo().getValeur());
		duerFront.setPrevMiseEnOeuvre(duer.getPrevMiseEnOeuvre());
		if (duer.getPas() != null) {
			duerFront.setPas(duer.getPas().getId());
		}
		;
		duerFront.setDateEvrp(duer.getDateEvrp());

		return duerFront;
	}

	@RequestMapping(method = RequestMethod.GET, path = "duer")
	public Optional<Duer> trouverFrequence(@RequestParam("id") int id) {
		Optional<Duer> duer = this.duerRepo.findById(id);
		return duer;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "duer")
	public ResponseEntity<String> creerDuer(@RequestBody DuerClef duerClef) {
		System.err.println(duerClef);
		if (duerClef == null) {
			String messageErreur = "DuerClef n'existe pas - ";
			LOG.error(messageErreur);
			throw new BadRequestException(messageErreur);

		} else {

			LOG.info(" Création de l'Evrp : ");

			// On vérifie si l'Ut existe
			Optional<Ut> utNew = this.utRepo.findById(duerClef.getId_ut());
			System.out.println(duerClef.getId_ut());
			if (!utNew.isPresent()) {
				String messageErreur = "";
				messageErreur = "Ut n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ElementNotFoundException(messageErreur);
			} else {
				LOG.info(">>>> Creer l'Ut d'Id : " + duerClef.getId_ut());
			}

			// On vérifie si le lieu existe
			Optional<Lieu> lieuNew = this.lieuRepo.findById(duerClef.getId_lieu());
			if (!lieuNew.isPresent()) {
				String messageErreur = "";
				messageErreur = "Lieu n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ElementNotFoundException(messageErreur);
			} else {
				LOG.info(">>>> Creer le lieu d'Id : " + duerClef.getId_lieu());
			}

			// On vérifie si l'Activite existe
			Optional<Activites> actNew = this.activitesRepo.findById(duerClef.getId_activite());
			if (!actNew.isPresent()) {
				String messageErreur = "";
				messageErreur = "Activité n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ElementNotFoundException(messageErreur);
			} else {
				LOG.info(">>>> Creer l'Activité d'Id : " + duerClef.getId_activite());
			}

			// On vérifie si le Danger existe
			Optional<Dangers> dgNew = this.dangersRepo.findById(duerClef.getId_danger());
			if (!dgNew.isPresent()) {
				String messageErreur = "";
				messageErreur = "Danger d'Id n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ElementNotFoundException(messageErreur);
			} else {
				LOG.info(">>>> Creer le Danger d'Id : " + duerClef.getId_danger());
			}
			// On vérifie si le Risque existe
			Optional<Risques> rqNew = this.risquesRepo.findById(duerClef.getId_risque());
			if (!rqNew.isPresent()) {
				String messageErreur = "";
				messageErreur = "Risque n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ElementNotFoundException(messageErreur);
			} else {
				LOG.info(">>>> Creer le Risque d'Id : " + duerClef.getId_risque());
			}
			// On vérifie si la gravite Ex existe
			Optional<Gravite> gr1New = this.graviteRepo.findById(duerClef.getId_gravEx());
			if (!gr1New.isPresent()) {
				String messageErreur = "";
				messageErreur = "Gravite Ex n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ElementNotFoundException(messageErreur);
			} else {
				LOG.info(">>>> Creer la gravité Ex d'Id : " + duerClef.getId_gravEx());
			}
			// On vérifie si la Fréquence Ex existe
			Optional<Frequence> fr1New = this.frequenceRepo.findById(duerClef.getId_FreqEx());
			if (!fr1New.isPresent()) {
				String messageErreur = "";
				messageErreur = "Frequence Ex n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ElementNotFoundException(messageErreur);
			} else {
				LOG.info(">>>> Creer la Frequence Ex d'Id : " + duerClef.getId_FreqEx());
			}

			// On vérifie si la Prévention Ex existe

			if ((duerClef.getPrevEx() == null) || (duerClef.getPrevEx().trim().isEmpty())) {
				String messageErreur = "";
				messageErreur = "Prevention Ex  n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ForbiddenOperationException(messageErreur);
			} else {
				prevExist = true;
				LOG.info(">>>> Creer la prevention Ex : " + duerClef.getPrevEx());
			}

			// On vérifie si la gravite Mo existe
			Optional<Gravite> gr1oNew = this.graviteRepo.findById(duerClef.getId_gravMo());
			if (!gr1oNew.isPresent()) {
				String messageErreur = "";
				messageErreur = "Gravite Mo n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ElementNotFoundException(messageErreur);
			} else {
				LOG.info(">>>> Creer la gravité Mo d'Id : " + duerClef.getId_gravMo());
			}
			// On vérifie si la Fréquence Mo existe
			Optional<Frequence> fr1oNew = this.frequenceRepo.findById(duerClef.getId_FreqMo());
			if (!fr1oNew.isPresent()) {
				String messageErreur = "";
				messageErreur = "Frequence Mo n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ElementNotFoundException(messageErreur);
			} else {
				LOG.info(">>>> Creer la Frequence Mo d'Id : " + duerClef.getId_FreqMo());
			}

			// On vérifie si la Prévention Mo existe

			if ((duerClef.getPrevMo() == null) || (duerClef.getPrevMo().trim().isEmpty())) {
				String messageErreur = "";
				messageErreur = "Prevention Mo  n'existe pas ou est null..";
				LOG.error(messageErreur);
				throw new ForbiddenOperationException(messageErreur);
			} else {
				prevMoExist = true;
				LOG.info(">>>> Creer la prevention Mo : " + duerClef.getPrevMo());
			}

			if ((utNew.isPresent()) && (lieuNew.isPresent()) && (actNew.isPresent()) && (dgNew.isPresent())
					&& (rqNew.isPresent()) && (gr1New.isPresent()) && (fr1New.isPresent()) && (gr1oNew.isPresent())
					&& (fr1oNew.isPresent()) && prevExist && prevMoExist) {

				Duer nouveauDuer = new Duer(utNew.get(), lieuNew.get(), actNew.get(), dgNew.get(), rqNew.get(),
						gr1New.get(), fr1New.get(), duerClef.getPrevEx(), gr1oNew.get(), fr1oNew.get(),
						duerClef.getPrevMo(), LocalDateTime.now());

				this.duerRepo.save(nouveauDuer);
				return ResponseEntity.status(HttpStatus.OK).body("Le Duer a été créé avec succès!");

			} else {
				System.out.println("Erreur génrérale");
			}

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Le Duer n'a pas été créé avec succès! La requète est mal formulée !");
		}
	}

	/* trouver les criticités existantes dans la liste des Duer */
	@RequestMapping(method = RequestMethod.GET, path = "duerc")
	public List<Integer> trouverCriticite() {
		return this.duerRepo.findAll().stream()
				.map(duer -> duer.getGravite_Ex().getValeur() * duer.getFrequence_Ex().getValeur()).distinct().sorted()
				.collect(Collectors.toList());

	}

	/* trouver les criticités Mo dans la liste des Duer */
	@RequestMapping(method = RequestMethod.GET, path = "duercmos")
	public List<Integer> trouverCriticiteMo() {
		return this.duerRepo.findAll().stream()
				.map(duer -> duer.getGravite_Mo().getValeur() * duer.getFrequence_Mo().getValeur()).distinct().sorted()
				.collect(Collectors.toList());

	}

	/* trouver les Ut existantes dans la liste des Duer */
	@RequestMapping(method = RequestMethod.GET, path = "duerlut")
	public List<UtVM> trouverUtdansDuer() {
		return this.duerRepo.findAll().stream().map(duer -> duer.getUt()).distinct().map(ut -> new UtVM(ut))
				.collect(Collectors.toList());

	}

	/* trouver les Lieux existants dans la liste des Duer */
	@RequestMapping(method = RequestMethod.GET, path = "duerllieu")
	public List<LieuVM> trouverULieudansDuer() {
		return this.duerRepo.findAll().stream().map(duer -> duer.getLieu()).distinct().map(lieu -> new LieuVM(lieu))
				.collect(Collectors.toList());

	}

	/* Donne la liste des Evrp en fonction du critère_Ex */
	@RequestMapping(method = RequestMethod.GET, path = "duercc")
	public List<DuerFront> filtrerCriticiteEx(@RequestParam("crit") int crit) {

		return this.duerRepo.findAll().stream()
				.filter(duer -> duer.getGravite_Ex().getValeur() * duer.getFrequence_Ex().getValeur() == crit)// predicat
				.map(r -> changeFront(r)).sorted((duer1, duer2) -> duer1.getUt().compareTo(duer2.getUt()))
				.collect(Collectors.toList());// sort du flux (obligatoire)

	}

	/* Donne la liste des Evrp en fonction du critère_Ex */
	@RequestMapping(method = RequestMethod.GET, path = "duercmo")
	public List<DuerFront> filtrerCriticiteMo(@RequestParam("crit") int crit) {

		return this.duerRepo.findAll().stream()
				.filter(duer -> duer.getGravite_Mo().getValeur() * duer.getFrequence_Mo().getValeur() == crit)// predicat
				.map(r -> changeFront(r)).sorted((duer1, duer2) -> duer1.getUt().compareTo(duer2.getUt()))
				.collect(Collectors.toList());// sort du flux (obligatoire)

	}

	/* Donne la liste des Evrp en fonction de l'UT */
	@RequestMapping(method = RequestMethod.GET, path = "duerut")
	public List<DuerFront> filtrerUt(@RequestParam("ut") int ut) {
		return this.duerRepo.findAll().stream().filter(duer -> duer.getUt().getId() == ut).map(r -> changeFront(r))// predicat
				.sorted((duer1, duer2) -> Integer.valueOf(duer1.getGravite_Ex() * duer1.getFrequence_Ex())
						.compareTo(Integer.valueOf(duer2.getGravite_Ex() * duer2.getFrequence_Ex())))
				.collect(Collectors.toList());// sort du flux (obligatoire)

	}

	/* Donne la liste des Evrp en fonction du lieu */
	@RequestMapping(method = RequestMethod.GET, path = "duerlieu")
	public List<DuerFront> filtrerLieu(@RequestParam("lieu") int lieu) {
		return this.duerRepo.findAll().stream().filter(duer -> duer.getLieu().getId() == lieu).map(r -> changeFront(r))// predicat
				.sorted((duer1, duer2) -> Integer.valueOf(duer1.getGravite_Ex() * duer1.getFrequence_Ex())
						.compareTo(Integer.valueOf(duer2.getGravite_Ex() * duer2.getFrequence_Ex())))
				.collect(Collectors.toList());// sort du flux (obligatoire)

	}

	@RequestMapping(method = RequestMethod.GET, path = "duerutt")
	public List<Duer> filtrerByUt(@RequestParam("ut") int ut) {
		return this.duerRepo.findAllByUt(new Ut(ut, null)).stream()
				.sorted((duer1, duer2) -> Integer
						.valueOf(duer1.getGravite_Ex().getValeur() * duer1.getFrequence_Ex().getValeur())
						.compareTo(Integer
								.valueOf(duer2.getGravite_Ex().getValeur() * duer2.getFrequence_Ex().getValeur())))
				.collect(Collectors.toList());// sort du flux (obligatoire)

	}
}
