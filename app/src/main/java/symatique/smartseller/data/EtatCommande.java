package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
@DatabaseTable
public class EtatCommande implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("couleur")
    @DatabaseField
    private String couleur;
    @JsonProperty("dateSynch")
    @DatabaseField
    private Long dateSynch;
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("libelleArb")
    @DatabaseField
    private String libelleArb;
    @JsonProperty("rang")
    @DatabaseField
    private Long rang;
    @JsonProperty("supprimer")
    @DatabaseField
    private Boolean supprimer;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;


    @JsonProperty("commandes")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Commande> commandes;

    public EtatCommande() {
    }

    public EtatCommande(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCouleur() {
        return couleur;
    }

    public Long getDateSynch() {
        return dateSynch;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getLibelleArb() {
        return libelleArb;
    }

    public Long getRang() {
        return rang;
    }

    public Boolean getSupprimer() {
        return supprimer;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public ForeignCollection<Commande> getCommandes() {
        return commandes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setDateSynch(Long dateSynch) {
        this.dateSynch = dateSynch;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLibelleArb(String libelleArb) {
        this.libelleArb = libelleArb;
    }

    public void setRang(Long rang) {
        this.rang = rang;
    }

    public void setSupprimer(Boolean supprimer) {
        this.supprimer = supprimer;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setCommandes(ForeignCollection<Commande> commandes) {
        this.commandes = commandes;
    }
}
