package fr.membres.membres.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
// Demande a ce service de s'enregistrer aupres de l'annuaire
public class UtilisateursServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilisateursServiceApplication.class, args);
    }
}
