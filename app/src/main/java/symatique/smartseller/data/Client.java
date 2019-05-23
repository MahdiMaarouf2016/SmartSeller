package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;

@DatabaseTable
public class Client implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    protected long id;


    @JsonProperty("adresse")
    @DatabaseField
    protected String adresse = "";
    @JsonProperty("code")
    @DatabaseField
    protected String code = "";
    @JsonProperty("codeAdminVente")
    @DatabaseField
    protected String codeAdminVente = "";
    @JsonProperty("email")
    @DatabaseField
    protected String email = "";
    @JsonProperty("etatCompte")
    @DatabaseField
    protected boolean etatCompte;
    @JsonProperty("gsm")
    @DatabaseField
    protected String gsm = "";
    @JsonProperty("libelle")
    @DatabaseField
    protected String libelle = "";
    @JsonProperty("matriculeFiscale")
    @DatabaseField
    protected String matriculeFiscale = "";
    @JsonProperty("nature")
    @DatabaseField
    protected String nature = "";
    @JsonProperty("registreCommerce")
    @DatabaseField
    protected String registreCommerce = "";
    @JsonProperty("avApplicable")
    @DatabaseField
    protected boolean isAvApplicable = false;
    @JsonProperty("supprimer")
    @DatabaseField
    protected boolean supprimer = false;
    @JsonProperty("dateSynchro")
    @DatabaseField
    protected long dateSynchro;
    @JsonProperty("longitude")
    @DatabaseField
    private String longitude;
    @JsonProperty("latitude")
    @DatabaseField
    private String latitude;
    @JsonProperty("precision")
    @DatabaseField
    private int precision;
    @JsonProperty("codeTemp")
    @DatabaseField
    private String codeTemp;
    @JsonProperty("nom")
    @DatabaseField
    private String nom;
    @JsonProperty("prenom")
    @DatabaseField
    private String prenom;
    @JsonProperty("dateCreation")
    @DatabaseField
    private Long dateCreation;
    @JsonProperty("cin")
    @DatabaseField
    private String cin;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;

    @JsonProperty("livreurs")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Livreur> livreurs;
    @JsonProperty("prefixBLS")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<PrefixBL> prefixBLS;

    @DatabaseField(foreign = true)
    private Livreur livreur;


    public Client() {

    }

    public long getId() {
        return id;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCode() {
        return code;
    }

    public String getCodeAdminVente() {
        return codeAdminVente;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEtatCompte() {
        return etatCompte;
    }

    public String getGsm() {
        return gsm;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getMatriculeFiscale() {
        return matriculeFiscale;
    }

    public String getNature() {
        return nature;
    }

    public String getRegistreCommerce() {
        return registreCommerce;
    }

    public boolean isAvApplicable() {
        return isAvApplicable;
    }

    public boolean isSupprimer() {
        return supprimer;
    }

    public long getDateSynchro() {
        return dateSynchro;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public int getPrecision() {
        return precision;
    }

    public String getCodeTemp() {
        return codeTemp;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Long getDateCreation() {
        return dateCreation;
    }

    public String getCin() {
        return cin;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public ForeignCollection<Livreur> getLivreurs() {
        return livreurs;
    }

    public ForeignCollection<PrefixBL> getPrefixBLS() {
        return prefixBLS;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodeAdminVente(String codeAdminVente) {
        this.codeAdminVente = codeAdminVente;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEtatCompte(boolean etatCompte) {
        this.etatCompte = etatCompte;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setMatriculeFiscale(String matriculeFiscale) {
        this.matriculeFiscale = matriculeFiscale;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public void setRegistreCommerce(String registreCommerce) {
        this.registreCommerce = registreCommerce;
    }

    public void setAvApplicable(boolean avApplicable) {
        isAvApplicable = avApplicable;
    }

    public void setSupprimer(boolean supprimer) {
        this.supprimer = supprimer;
    }

    public void setDateSynchro(long dateSynchro) {
        this.dateSynchro = dateSynchro;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void setCodeTemp(String codeTemp) {
        this.codeTemp = codeTemp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateCreation(Long dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setLivreurs(ForeignCollection<Livreur> livreurs) {
        this.livreurs = livreurs;
    }

    public void setPrefixBLS(ForeignCollection<PrefixBL> prefixBLS) {
        this.prefixBLS = prefixBLS;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }
}
