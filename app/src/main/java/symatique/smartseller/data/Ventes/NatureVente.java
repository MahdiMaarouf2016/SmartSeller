package symatique.smartseller.data.Ventes;

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
public class NatureVente implements Serializable {
    @JsonProperty("id")
    @DatabaseField(id = true)
    private long id;

    @JsonProperty("dateSynch")
    @DatabaseField
    private long dateSynch;
    @JsonProperty("description")
    @DatabaseField
    private String description;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("supression")
    @DatabaseField
    private boolean supression;

    public NatureVente() {

    }

    public long getId() {
        return id;
    }

    public long getDateSynch() {
        return dateSynch;
    }

    public String getDescription() {
        return description;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public String getLibelle() {
        return libelle;
    }

    public boolean isSupression() {
        return supression;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateSynch(long dateSynch) {
        this.dateSynch = dateSynch;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setSupression(boolean supression) {
        this.supression = supression;
    }
}
