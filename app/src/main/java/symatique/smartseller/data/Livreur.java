package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@DatabaseTable
public class Livreur implements Serializable {

    @DatabaseField(id = true)
    @JsonProperty("id")
    private long id;

    @JsonProperty("cin")
    @DatabaseField
    private String cin = "";
    @JsonProperty("code")
    @DatabaseField
    private String code = "";
    @JsonProperty("email")
    @DatabaseField
    private String email = "";
    @JsonProperty("etatCompte")
    @DatabaseField
    private int etatCompte;
    @JsonProperty("gsm")
    @DatabaseField
    private String gsm = "";
    @JsonProperty("immatriculation")
    @DatabaseField
    private String immatriculation = "";
    @JsonProperty("nom")
    @DatabaseField
    private String nom = "";
    @JsonProperty("prenom")
    @DatabaseField
    private String prenom = "";
    @JsonProperty("codeCommercial")
    @DatabaseField
    private String codeCommercial = "";
    @JsonProperty("isAuthenticated")
    @DatabaseField
    private boolean isAuthenticated = false;
    @JsonProperty("password")
    @DatabaseField
    private String password = "";


    public Livreur(){

    }

    public Livreur(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getCin() {
        return cin;
    }

    public String getCode() {
        return code;
    }

    public String getEmail() {
        return email;
    }

    public int getEtatCompte() {
        return etatCompte;
    }

    public String getGsm() {
        return gsm;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCodeCommercial() {
        return codeCommercial;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEtatCompte(int etatCompte) {
        this.etatCompte = etatCompte;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCodeCommercial(String codeCommercial) {
        this.codeCommercial = codeCommercial;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
