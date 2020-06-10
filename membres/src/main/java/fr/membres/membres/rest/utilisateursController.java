package fr.membres.membres.rest;

import fr.membres.membres.entities.membres;
import fr.membres.membres.repo.utilisateursRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


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
    @GetMapping("/getMembre")
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
    @PostMapping("PostMembre")
    public membres postUtil(@RequestBody membres util) {
        return repository.save(util);
    }


    @PostMapping("{id}")
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
                    membres.setEnseignant(newMembres.getEnseignant());
                    membres.setPayement(newMembres.getPayement());

                    return repository.save(membres);
                })
                .orElseGet(() -> {
                    newMembres.setId(id);
                    return repository.save(newMembres);
                });
    }

    @PutMapping("modifcertif/{Datecertif}/{id}")
    membres modifcertif(@PathVariable("Datecertif") Date datecertif, @PathVariable("id") Long id) {


        membres monM =  repository.findDistinctById(id);
        monM.setDateCertif(datecertif);
        return repository.save(monM);
    }

    @PostMapping("modifEnseignant/{statut}/{id}")
    membres modifcertif(@PathVariable("statut") String enseigant,@PathVariable("id") String id) {

        logger.info("enseignant:"+enseigant+", id:"+new Long(id));
        membres monM =  repository.findDistinctById(new Long(id));

        boolean isEnseignant=false;
        if (enseigant.equals("1")) {
            isEnseignant=true;
            logger.info("enseignant:"+enseigant);
        };
        monM.setEnseignant(isEnseignant);
        return repository.save(monM);
    }

    @GetMapping("nvEnseignant")
    HashMap<Integer, Integer> nvEnseignant() {
        HashMap<Integer, Integer> nvEnseignant = new HashMap<>();
        Iterable<membres> MesM = repository.findAll();

        for(int i = 1; i < 6; i++){
            int nbEn = 0;
            for (membres monM : MesM)
            {
                if(monM.getEnseignant() != null && monM.getEnseignant().equals(true) && monM.getNiveau() == i){
                    nbEn ++;
                }
            }
            nvEnseignant.put(i,nbEn);
        }


        return nvEnseignant;
    }

    @PutMapping("payement/{Datepayement}/{iban}/{id}")
    membres payement(@PathVariable("Datepayement") String payement,@PathVariable("iban") Long iban,@PathVariable("id") Long id) {

        membres monM =  repository.findDistinctById(id);
        monM.setPayement(payement);
        return repository.save(monM);
    }

}

