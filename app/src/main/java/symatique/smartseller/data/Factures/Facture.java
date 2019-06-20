package symatique.smartseller.data.Factures;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import symatique.smartseller.data.Encaissements.Encaissement;
import symatique.smartseller.data.Stocks.Packet;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Facture {

    @JsonProperty("idDomaine")
    @DatabaseField
    protected long idDomaine;
    @JsonProperty("libelleDomaine")
    @DatabaseField
    protected String libelleDomaine;
    @JsonProperty("codeDomaine")
    @DatabaseField
    protected String codeDomaine;
    @JsonProperty("id")
    @DatabaseField(id = true)
    private long id;
    @JsonProperty("isBonLivraison")
    @DatabaseField
    private boolean isBonLivraison;
    @JsonProperty("idFact")
    @DatabaseField
    private String idFact;
    @JsonProperty("numero")
    @DatabaseField
    private String numero;
    @JsonProperty("numeroFact")
    @DatabaseField
    private String numeroFact;
    @JsonProperty("dateCreation")
    @DatabaseField
    private long dateCreation;
    @JsonProperty("idClient")
    @DatabaseField
    private long idClient;
    @JsonProperty("libelleClient")
    @DatabaseField
    private String libelleClient;
    @JsonProperty("codeClient")
    @DatabaseField
    private String codeClient;
    @JsonProperty("avImpot")
    @DatabaseField
    private boolean avImpot;
    @JsonProperty("montantHT")
    @DatabaseField
    private BigDecimal montantHT;
    @JsonProperty("montantTTC")
    @DatabaseField
    private BigDecimal montantTTC;
    @JsonProperty("montantTVA")
    @DatabaseField
    private BigDecimal montantTVA;
    @JsonProperty("idLivreur")
    @DatabaseField
    private long idLivreur;
    @JsonProperty("codeLivreur")
    @DatabaseField
    private String codeLivreur;
    @JsonProperty("libelleLivreur")
    @DatabaseField
    private String libelleLivreur;
    @JsonProperty("codeCommercial")
    @DatabaseField
    private String codeCommercial;
    @JsonProperty("livreurLatitude")
    @DatabaseField
    private double livreurLatitude;
    @JsonProperty("livreurLongitude")
    @DatabaseField
    private double livreurLongitude;
    @JsonProperty("locationPrecision")
    @DatabaseField
    private float locationPrecision;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("codeEntreprise")
    @DatabaseField
    private String codeEntreprise;
    @JsonProperty("libelleEntreprise")
    @DatabaseField
    private String libelleEntreprise;
    @JsonProperty("listLigneFacture")
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private ArrayList<LigneFacture> listLigneFacture = new ArrayList<>();
    @JsonProperty("listPacketsVendus")
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private ArrayList<Packet> listPacketsVendus = new ArrayList<>();
    @JsonProperty("encaissment")
    @DatabaseField(foreign = true)
    private Encaissement encaissement = null;
    private boolean paye = false;

    public Facture() {

    }

    public boolean isPaye() {
        return paye;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isBonLivraison() {
        return isBonLivraison;
    }

    public void setBonLivraison(boolean bonLivraison) {
        isBonLivraison = bonLivraison;
    }

    public String getIdFact() {
        return idFact;
    }

    public void setIdFact(String idFact) {
        this.idFact = idFact;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroFact() {
        return numeroFact;
    }

    public void setNumeroFact(String numeroFact) {
        this.numeroFact = numeroFact;
    }

    public long getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getLibelleClient() {
        return libelleClient;
    }

    public void setLibelleClient(String libelleClient) {
        this.libelleClient = libelleClient;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public boolean isAvImpot() {
        return avImpot;
    }

    public void setAvImpot(boolean avImpot) {
        this.avImpot = avImpot;
    }

    public BigDecimal getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(BigDecimal montantHT) {
        this.montantHT = montantHT;
    }

    public BigDecimal getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(BigDecimal montantTTC) {
        this.montantTTC = montantTTC;
    }

    public BigDecimal getMontantTVA() {
        return montantTVA;
    }

    public void setMontantTVA(BigDecimal montantTVA) {
        this.montantTVA = montantTVA;
    }

    public long getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(long idLivreur) {
        this.idLivreur = idLivreur;
    }

    public String getCodeLivreur() {
        return codeLivreur;
    }

    public void setCodeLivreur(String codeLivreur) {
        this.codeLivreur = codeLivreur;
    }

    public String getLibelleLivreur() {
        return libelleLivreur;
    }

    public void setLibelleLivreur(String libelleLivreur) {
        this.libelleLivreur = libelleLivreur;
    }

    public String getCodeCommercial() {
        return codeCommercial;
    }

    public void setCodeCommercial(String codeCommercial) {
        this.codeCommercial = codeCommercial;
    }

    public double getLivreurLatitude() {
        return livreurLatitude;
    }

    public void setLivreurLatitude(double livreurLatitude) {
        this.livreurLatitude = livreurLatitude;
    }

    public double getLivreurLongitude() {
        return livreurLongitude;
    }

    public void setLivreurLongitude(double livreurLongitude) {
        this.livreurLongitude = livreurLongitude;
    }

    public float getLocationPrecision() {
        return locationPrecision;
    }

    public void setLocationPrecision(float locationPrecision) {
        this.locationPrecision = locationPrecision;
    }

    public ArrayList<LigneFacture> getListLigneFacture() {
        return listLigneFacture;
    }

    public void setListLigneFacture(ArrayList<LigneFacture> listLigneFacture) {
        this.listLigneFacture = listLigneFacture;
    }

    public ArrayList<Packet> getListPacketsVendus() {
        return listPacketsVendus;
    }

    public void setListPacketsVendus(ArrayList<Packet> listPacketsVendus) {
        this.listPacketsVendus = listPacketsVendus;
    }

    public Encaissement getEncaissement() {
        return encaissement;
    }

    public void setEncaissement(Encaissement encaissements) {
        this.encaissement = encaissement;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getCodeEntreprise() {
        return codeEntreprise;
    }

    public void setCodeEntreprise(String codeEntreprise) {
        this.codeEntreprise = codeEntreprise;
    }

    public String getLibelleEntreprise() {
        return libelleEntreprise;
    }

    public void setLibelleEntreprise(String libelleEntreprise) {
        this.libelleEntreprise = libelleEntreprise;
    }

    public long getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(long idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getLibelleDomaine() {
        return libelleDomaine;
    }

    public void setLibelleDomaine(String libelleDomaine) {
        this.libelleDomaine = libelleDomaine;
    }

    public String getCodeDomaine() {
        return codeDomaine;
    }

    public void setCodeDomaine(String codeDomaine) {
        this.codeDomaine = codeDomaine;
    }

    public boolean equals(Object object) {
        if (object instanceof Facture) return ((Facture) object).getId() == this.id;
        else return false;
    }
}
