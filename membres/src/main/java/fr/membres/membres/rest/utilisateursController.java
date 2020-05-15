package fr.membres.membres.rest;




import fr.membres.membres.entities.membres;
import fr.membres.membres.repo.utilisateursRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController("/")
public class utilisateursController {

    Logger logger = LoggerFactory.getLogger(utilisateursController.class);

    // Injection DAO clients
    @Autowired
    private utilisateursRepo repository;




    @GetMapping("{id}")
    Optional<membres> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("email/{mail}")
    membres email(@PathVariable("mail") String mail) {
        return repository.findDistinctByMail(mail);
    }

    /**
     * GET liste des clients
     * @return liste des clients en JSON. [] si aucun compte.
     */
    @GetMapping("")
    public Iterable<membres> getUtil() {
        return repository.findAll();
    }


/*
    @GetMapping
    public String Testafficher() {
        return "bonjour";
    }*/
    /**
     * POST un utilisateur
     * @param util client à ajouter (import JSON)
     * @return utilisateur ajouté
     */
    @PostMapping("")
    public membres postUtil(@RequestBody membres util) {
        return repository.save(util);
    }


    @PutMapping("{id}")
    membres replaceMembres(@RequestBody membres newMembres, @PathVariable Long id) {

        return repository.findById(id)
                .map(membres -> {
                    membres.setNom(newMembres.getNom());
                    membres.setPrenom(newMembres.getPrenom());
                    membres.setAdresse(newMembres.getAdresse());
                    membres.setDateCertif(newMembres.getDateCertif());
                    membres.setMail(newMembres.mail);
                    membres.setMdp(newMembres.getMdp());
                    membres.setNiveau(newMembres.getNiveau());
                    membres.setNumLicence(newMembres.getNumLicence());
                    membres.setStatut(newMembres.getStatut());

                    return repository.save(membres);
                })
                .orElseGet(() -> {
                    newMembres.setId(id);
                    return repository.save(newMembres);
                });
    }

    @PutMapping("modifcertif/{Datecertif}/{id}")
    membres modifcertif(@PathVariable("Datecertif") String datecertif,@PathVariable("id") Long id) {


        membres monM =  repository.findDistinctById(id);
        monM.setDateCertif(datecertif);
        return repository.save(monM);
    }

    @PutMapping("payement/{Datepayement}/{iban}")
    membres payement(@PathVariable("Datepayement") String payement,@PathVariable("iban") Long iban) {


        membres monM =  repository.findDistinctByIban(iban);
        monM.setPayement(payement);
        return repository.save(monM);
    }

    @DeleteMapping("{id}")
    void deleteMembre(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

