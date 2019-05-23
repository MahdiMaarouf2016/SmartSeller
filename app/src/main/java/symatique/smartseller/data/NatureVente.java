package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
@DatabaseTable
public class NatureVente implements Serializable {
    @JsonProperty("id")
    @DatabaseField(id = true)
    private long id;

    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("libelleArb")
    @DatabaseField
    private String libelleArb;
    @JsonProperty("description")
    @DatabaseField
    private String description;
    @JsonProperty("dateSynch")
    @DatabaseField
    private long dateSynch;
    @JsonProperty("supression")
    @DatabaseField
    private boolean supression;
    @JsonProperty("idTypeVente")
    @DatabaseField
    private long idTypeVente;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;

    @JsonProperty("ventes")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Vente> ventes;

    public NatureVente() {
    }

    public NatureVente(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getLibelleArb() {
        return libelleArb;
    }

    public String getDescription() {
        return description;
    }

    public long getDateSynch() {
        return dateSynch;
    }

    public boolean isSupression() {
        return supression;
    }

    public long getIdTypeVente() {
        return idTypeVente;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public ForeignCollection<Vente> getVentes() {
        return ventes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLibelleArb(String libelleArb) {
        this.libelleArb = libelleArb;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateSynch(long dateSynch) {
        this.dateSynch = dateSynch;
    }

    public void setSupression(boolean supression) {
        this.supression = supression;
    }

    public void setIdTypeVente(long idTypeVente) {
        this.idTypeVente = idTypeVente;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setVentes(ForeignCollection<Vente> ventes) {
        this.ventes = ventes;
    }
}
