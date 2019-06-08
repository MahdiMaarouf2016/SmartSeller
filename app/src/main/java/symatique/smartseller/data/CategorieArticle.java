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
public class CategorieArticle implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("activer")
    @DatabaseField
    private boolean activer;
    @JsonProperty("dateSynchro")
    @DatabaseField
    private Long dateSynchro;
    @JsonProperty("dernierRang")
    @DatabaseField
    private boolean dernierRang;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("libelleArb")
    @DatabaseField
    private String libelleArb;
    @JsonProperty("rang")
    @DatabaseField
    private int rang;
    @JsonProperty("specialClient")
    @DatabaseField
    private boolean specialClient;
    @JsonProperty("supprimer")
    @DatabaseField
    private Boolean supprimer;

    public CategorieArticle() {

    }

    public Long getId() {
        return id;
    }

    public boolean isActiver() {
        return activer;
    }

    public Long getDateSynchro() {
        return dateSynchro;
    }

    public boolean isDernierRang() {
        return dernierRang;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getLibelleArb() {
        return libelleArb;
    }

    public Boolean getSupprimer() {
        return supprimer;
    }

    public int getRang() {
        return rang;
    }

    public boolean isSpecialClient() {
        return specialClient;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActiver(boolean activer) {
        this.activer = activer;
    }

    public void setDateSynchro(Long dateSynchro) {
        this.dateSynchro = dateSynchro;
    }

    public void setDernierRang(boolean dernierRang) {
        this.dernierRang = dernierRang;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLibelleArb(String libelleArb) {
        this.libelleArb = libelleArb;
    }

    public void setSupprimer(Boolean supprimer) {
        this.supprimer = supprimer;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public void setSpecialClient(boolean specialClient) {
        this.specialClient = specialClient;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
}
