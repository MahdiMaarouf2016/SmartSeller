package symatique.smartseller.data.Commandes;

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
public class EtatCommande implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("choixArticle")
    @DatabaseField
    private boolean choixArticle;
    @JsonProperty("couleur")
    @DatabaseField
    private String couleur;
    @JsonProperty("dateSynch")
    @DatabaseField
    private Long dateSynch;
    @JsonProperty("dernierRang")
    @DatabaseField
    private boolean dernierRang;
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("nombreHeureTraitement")
    @DatabaseField
    private long nombreHeureTraitement;
    @JsonProperty("rang")
    @DatabaseField
    private Long rang;
    @JsonProperty("supprimer")
    @DatabaseField
    private Boolean supprimer;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("synchroniserMFG")
    @DatabaseField
    private boolean synchroniserMFG;


    public EtatCommande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isChoixArticle() {
        return choixArticle;
    }

    public void setChoixArticle(boolean choixArticle) {
        this.choixArticle = choixArticle;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Long getDateSynch() {
        return dateSynch;
    }

    public void setDateSynch(Long dateSynch) {
        this.dateSynch = dateSynch;
    }

    public boolean isDernierRang() {
        return dernierRang;
    }

    public void setDernierRang(boolean dernierRang) {
        this.dernierRang = dernierRang;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public long getNombreHeureTraitement() {
        return nombreHeureTraitement;
    }

    public void setNombreHeureTraitement(long nombreHeureTraitement) {
        this.nombreHeureTraitement = nombreHeureTraitement;
    }

    public Long getRang() {
        return rang;
    }

    public void setRang(Long rang) {
        this.rang = rang;
    }

    public Boolean getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(Boolean supprimer) {
        this.supprimer = supprimer;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public boolean isSynchroniserMFG() {
        return synchroniserMFG;
    }

    public void setSynchroniserMFG(boolean synchroniserMFG) {
        this.synchroniserMFG = synchroniserMFG;
    }
}
