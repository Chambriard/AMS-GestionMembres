package fr.membres.membres.entities;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class membres {

    @Id
    @GeneratedValue
    public Long id;

    public String nom;

    public String prenom;

    public String adresse;

    public String mail;

    public String mdp;

    public int niveau;

    public String numLicence;
@JsonFormat
        (shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public Date dateCertif;

@JsonFormat
        (shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public String payement;

    public String statut;

    public Boolean enseignant;


    public String iban ;

    public membres(){

    }


    public membres(Long id, String nom, String prenom, String adresse, String mail, String mdp, int niveau, String numLicence, Date dateCertif, String payement, String statut, long iban, Boolean enseignant) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.mdp = mdp;
        this.niveau = niveau;
        this.numLicence = numLicence;
        this.dateCertif = dateCertif;
        this.payement = payement;
        this.statut = statut;
        this.enseignant = enseignant;

    }

    public String getPayement() {
        return payement;
    }

    public void setPayement(String payement) {
        this.payement = payement;
    }

    public String getIban() {
        return iban;
    }

    public Boolean getEnseignant() {
        return enseignant;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public String getMdp() {
        return mdp;
    }

    public int getNiveau() {
        return niveau;
    }

    public String getNumLicence() {
        return numLicence;
    }

    public Date getDateCertif() {
        return dateCertif;
    }


    public void setEnseignant(Boolean enseignant) {
        this.enseignant = enseignant;
    }

    public String getStatut() {
        return statut;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setNumLicence(String numLicence) {
        this.numLicence = numLicence;
    }

    public void setDateCertif(Date dateCertif) {
        this.dateCertif = dateCertif;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
