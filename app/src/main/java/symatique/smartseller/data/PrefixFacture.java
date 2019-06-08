package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@DatabaseTable
public class PrefixFacture implements Serializable {
    @JsonProperty("id")
    @DatabaseField(id = true)
    private String id;

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
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal montantHT;
    @JsonProperty("montantTTC")
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal montantTTC;
    @JsonProperty("montantTVA")
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal montantTVA;
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
    @JsonProperty("appVersion")
    @DatabaseField
    private String appVersion = "";

    public PrefixFacture(String id) {
        this.id = id;
    }

    public PrefixFacture() {

    }

    public String getId() {
        return id;
    }

    public boolean isBonLivraison() {
        return isBonLivraison;
    }

    public String getIdFact() {
        return idFact;
    }

    public String getNumero() {
        return numero;
    }

    public String getNumeroFact() {
        return numeroFact;
    }

    public long getDateCreation() {
        return dateCreation;
    }

    public String getLibelleClient() {
        return libelleClient;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public boolean isAvImpot() {
        return avImpot;
    }

    public BigDecimal getMontantHT() {
        return montantHT;
    }

    public BigDecimal getMontantTTC() {
        return montantTTC;
    }

    public BigDecimal getMontantTVA() {
        return montantTVA;
    }

    public String getCodeCommercial() {
        return codeCommercial;
    }

    public double getLivreurLatitude() {
        return livreurLatitude;
    }

    public double getLivreurLongitude() {
        return livreurLongitude;
    }

    public float getLocationPrecision() {
        return locationPrecision;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBonLivraison(boolean bonLivraison) {
        isBonLivraison = bonLivraison;
    }

    public void setIdFact(String idFact) {
        this.idFact = idFact;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNumeroFact(String numeroFact) {
        this.numeroFact = numeroFact;
    }

    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setLibelleClient(String libelleClient) {
        this.libelleClient = libelleClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public void setAvImpot(boolean avImpot) {
        this.avImpot = avImpot;
    }

    public void setMontantHT(BigDecimal montantHT) {
        this.montantHT = montantHT;
    }

    public void setMontantTTC(BigDecimal montantTTC) {
        this.montantTTC = montantTTC;
    }

    public void setMontantTVA(BigDecimal montantTVA) {
        this.montantTVA = montantTVA;
    }

    public void setCodeCommercial(String codeCommercial) {
        this.codeCommercial = codeCommercial;
    }

    public void setLivreurLatitude(double livreurLatitude) {
        this.livreurLatitude = livreurLatitude;
    }

    public void setLivreurLongitude(double livreurLongitude) {
        this.livreurLongitude = livreurLongitude;
    }

    public void setLocationPrecision(float locationPrecision) {
        this.locationPrecision = locationPrecision;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

}
