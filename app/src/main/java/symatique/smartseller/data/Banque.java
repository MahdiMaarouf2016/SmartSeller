package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class Banque implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;


    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("description")
    @DatabaseField
    private String description;
    @JsonProperty("dateSynchro")
    @DatabaseField
    private Long dateSynchro;
    @JsonProperty("supprimer")
    @DatabaseField
    private boolean supprimer;


    @JsonProperty("encaissements")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Encaissement> encaissements;

    public Banque() {

    }

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDescription() {
        return description;
    }

    public Long getDateSynchro() {
        return dateSynchro;
    }

    public boolean isSupprimer() {
        return supprimer;
    }

    public ForeignCollection<Encaissement> getEncaissements() {
        return encaissements;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateSynchro(Long dateSynchro) {
        this.dateSynchro = dateSynchro;
    }

    public void setSupprimer(boolean supprimer) {
        this.supprimer = supprimer;
    }

    public void setEncaissements(ForeignCollection<Encaissement> encaissements) {
        this.encaissements = encaissements;
    }
}
