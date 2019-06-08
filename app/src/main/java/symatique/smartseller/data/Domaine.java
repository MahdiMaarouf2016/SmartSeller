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
public class Domaine implements Serializable {
    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("code")
    @DatabaseField
    private String code;
    @JsonProperty("description")
    @DatabaseField
    private String description;
    @JsonProperty("supprimer")
    @DatabaseField
    private boolean supprimer;
    @JsonProperty("importCatalogueArticle")
    @DatabaseField
    private boolean importCatalogueArticle;
    @JsonProperty("dateSynch")
    @DatabaseField
    private Long dateSynch;

    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;

    public Domaine() {
    }

    public Domaine(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSupprimer() {
        return supprimer;
    }

    public boolean isImportCatalogueArticle() {
        return importCatalogueArticle;
    }

    public Long getDateSynch() {
        return dateSynch;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSupprimer(boolean supprimer) {
        this.supprimer = supprimer;
    }

    public void setImportCatalogueArticle(boolean importCatalogueArticle) {
        this.importCatalogueArticle = importCatalogueArticle;
    }

    public void setDateSynch(Long dateSynch) {
        this.dateSynch = dateSynch;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

}
