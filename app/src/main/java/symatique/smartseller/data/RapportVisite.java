package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
@DatabaseTable
public class RapportVisite implements Serializable {
    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("dateVente")
    @DatabaseField
    private Long dateVente;
    @JsonProperty("supression")
    @DatabaseField
    private boolean supression;
    @JsonProperty("dateSynchro")
    @DatabaseField
    private Long dateSynchro;
    @JsonProperty("message")
    @DatabaseField
    private String message;
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
    private long idEntreprise ;

    public RapportVisite() {
    }

    public RapportVisite(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getDateVente() {
        return dateVente;
    }

    public boolean isSupression() {
        return supression;
    }

    public Long getDateSynchro() {
        return dateSynchro;
    }

    public String getMessage() {
        return message;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateVente(Long dateVente) {
        this.dateVente = dateVente;
    }

    public void setSupression(boolean supression) {
        this.supression = supression;
    }

    public void setDateSynchro(Long dateSynchro) {
        this.dateSynchro = dateSynchro;
    }

    public void setMessage(String message) {
        this.message = message;
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

}
