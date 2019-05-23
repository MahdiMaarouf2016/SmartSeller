package symatique.smartseller.data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
@DatabaseTable
public class CategorieArticle implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("dateSynchro")
    @DatabaseField
    private Long dateSynchro;
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("libelleArb")
    @DatabaseField
    private String libelleArb;
    @JsonProperty("supprimer")
    @DatabaseField
    private Boolean supprimer;

    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;

    @JsonProperty("articles")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Article> articles;

    public CategorieArticle() {

    }

    public Long getId() {
        return id;
    }

    public Long getDateSynchro() {
        return dateSynchro;
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

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public ForeignCollection<Article> getArticles() {
        return articles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateSynchro(Long dateSynchro) {
        this.dateSynchro = dateSynchro;
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

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setArticles(ForeignCollection<Article> articles) {
        this.articles = articles;
    }
}
