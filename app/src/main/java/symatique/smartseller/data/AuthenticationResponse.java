package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AuthenticationResponse {
    @JsonProperty("adresseEntreprise")
    private String adresseEntreprise;
    @JsonProperty("cin")
    private String cin;
    @JsonProperty("code")
    private String code;
    @JsonProperty("codeCommercial")
    private String codeCommercial;
    @JsonProperty("codeEntreprise")
    private  String codeEntreprise;
    @JsonProperty("email")
    private  String email;
    @JsonProperty("etatCompte")
    private int etatCompte;
    @JsonProperty("gsm")
    private String gsm;
    @JsonProperty("idEntreprise")
    private Long idEntreprise;
    @JsonProperty("immatriculation")
    private String immatriculation;
    @JsonProperty("libelleEntreprise")
    private String libelleEntreprise;
    @JsonProperty("listBandeLivraisonWS")
    private List listBandeLivraisonWS;
    @JsonProperty("logoEntreprise")
    private String logoEntreprise;
    @JsonProperty("matriculeFiscaleEntreprise")
    private String matriculeFiscaleEntreprise;
    @JsonProperty("modeDeVente")
    private Long modeDeVente;
    @JsonProperty("moduleCommande")
    private boolean moduleCommande;
    @JsonProperty("multiDomaine")
    private boolean multiDomaine;
    @JsonProperty("nom")
    private  String nom;
    @JsonProperty("prenom")
    private String prenom;
    @JsonProperty("telephoneEntreprise")
    private String telephoneEntreprise;

    public AuthenticationResponse(){

    }

    public String getAdresseEntreprise() {
        return adresseEntreprise;
    }

    public String getCin() {
        return cin;
    }

    public String getCode() {
        return code;
    }

    public String getCodeCommercial() {
        return codeCommercial;
    }

    public String getCodeEntreprise() {
        return codeEntreprise;
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

    public Long getIdEntreprise() {
        return idEntreprise;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getLibelleEntreprise() {
        return libelleEntreprise;
    }

    public List getListBandeLivraisonWS() {
        return listBandeLivraisonWS;
    }

    public String getLogoEntreprise() {
        return logoEntreprise;
    }

    public String getMatriculeFiscaleEntreprise() {
        return matriculeFiscaleEntreprise;
    }

    public Long getModeDeVente() {
        return modeDeVente;
    }

    public boolean isModuleCommande() {
        return moduleCommande;
    }

    public boolean isMultiDomaine() {
        return multiDomaine;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephoneEntreprise() {
        return telephoneEntreprise;
    }

    public void setAdresseEntreprise(String adresseEntreprise) {
        this.adresseEntreprise = adresseEntreprise;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodeCommercial(String codeCommercial) {
        this.codeCommercial = codeCommercial;
    }

    public void setCodeEntreprise(String codeEntreprise) {
        this.codeEntreprise = codeEntreprise;
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

    public void setIdEntreprise(Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setLibelleEntreprise(String libelleEntreprise) {
        this.libelleEntreprise = libelleEntreprise;
    }

    public void setListBandeLivraisonWS(List listBandeLivraisonWS) {
        this.listBandeLivraisonWS = listBandeLivraisonWS;
    }

    public void setLogoEntreprise(String logoEntreprise) {
        this.logoEntreprise = logoEntreprise;
    }

    public void setMatriculeFiscaleEntreprise(String matriculeFiscaleEntreprise) {
        this.matriculeFiscaleEntreprise = matriculeFiscaleEntreprise;
    }

    public void setModeDeVente(Long modeDeVente) {
        this.modeDeVente = modeDeVente;
    }

    public void setModuleCommande(boolean moduleCommande) {
        this.moduleCommande = moduleCommande;
    }

    public void setMultiDomaine(boolean multiDomaine) {
        this.multiDomaine = multiDomaine;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephoneEntreprise(String telephoneEntreprise) {
        this.telephoneEntreprise = telephoneEntreprise;
    }
}
