package symatique.smartseller.data.Encaissements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/***************************************************************************
 *
 *                               SQLITE AND RETROFIT SERVICES
 *
 ***************************************************************************/

@DatabaseTable
public class Banque implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("dateSynchro")
    @DatabaseField
    private Long dateSynchro;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("supprimer")
    @DatabaseField
    private boolean supprimer;

    public Banque() {

    }

    public Long getId() {
        return id;
    }

    public Long getDateSynchro() {
        return dateSynchro;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public String getLibelle() {
        return libelle;
    }

    public boolean isSupprimer() {
        return supprimer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateSynchro(Long dateSynchro) {
        this.dateSynchro = dateSynchro;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setSupprimer(boolean supprimer) {
        this.supprimer = supprimer;
    }
}
