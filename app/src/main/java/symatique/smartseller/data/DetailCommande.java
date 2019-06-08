package symatique.smartseller.data;

import  java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
@DatabaseTable
public class DetailCommande implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private String id;

    @JsonProperty("dateSynchro")
    @DatabaseField
    private long dateSynchro;
    @JsonProperty("description")
    @DatabaseField
    private String description;
    @JsonProperty("descriptionArb")
    @DatabaseField
    private String descriptionArb;
    @JsonProperty("enPromo")
    @DatabaseField
    private Boolean enPromo;
    @JsonProperty("idCategorie")
    @DatabaseField
    private long idCategorie;
    @JsonProperty("libelleCategorie")
    @DatabaseField
    private String libelleCategorie;
    @JsonProperty("libelleArticle")
    @DatabaseField
    private String libelle;
    @JsonProperty("libelleArticleAr")
    @DatabaseField
    private String libelleArb;
    @JsonProperty("photo")
    @DatabaseField
    private String photo1;
    @JsonProperty("photo2")
    @DatabaseField
    private String photo2;
    @JsonProperty("photo3")
    @DatabaseField
    private String photo3;
    @JsonProperty("photo4")
    @DatabaseField
    private String photo4;
    @JsonProperty("photo5")
    @DatabaseField
    private String photo5;
    @JsonProperty("prixConsommateur")
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal prixConsommateur;
    @JsonProperty("prixUnitaireHT")
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal prixRevendeur;
    @JsonProperty("promoUnitaire")
    @DatabaseField
    private Integer promoUnitaire;
    @JsonProperty("supprimer")
    @DatabaseField
    private Boolean supprimer;
    @JsonProperty("tva")
    @DatabaseField
    private String tva;
    @JsonProperty("typeMesure")
    @DatabaseField
    private String typeMesure;
    @JsonProperty("typeMesureArabe")
    @DatabaseField
    private String typeMesureArabe;
    @JsonProperty("quantite")
    @DatabaseField
    private long qteCommande = 0;
    @JsonProperty("dateAchat")
    @DatabaseField
    long dateAchat;
    @JsonProperty("valpromo")
    @DatabaseField
    private float valpromo = 0;
    @JsonProperty("idcommande")
    @DatabaseField
    private String idcommande;
    @JsonProperty("idDomaine")
    @DatabaseField
    private long idDomaine;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("prixTotal")
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal prixTotal;


    public DetailCommande() {

    }

    public String getId() {
        return id;
    }

    public long getDateSynchro() {
        return dateSynchro;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionArb() {
        return descriptionArb;
    }

    public Boolean getEnPromo() {
        return enPromo;
    }

    public long getIdCategorie() {
        return idCategorie;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getLibelleArb() {
        return libelleArb;
    }

    public String getPhoto1() {
        return photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public String getPhoto4() {
        return photo4;
    }

    public String getPhoto5() {
        return photo5;
    }

    public BigDecimal getPrixConsommateur() {
        return prixConsommateur;
    }

    public BigDecimal getPrixRevendeur() {
        return prixRevendeur;
    }

    public Integer getPromoUnitaire() {
        return promoUnitaire;
    }

    public Boolean getSupprimer() {
        return supprimer;
    }

    public String getTva() {
        return tva;
    }

    public String getTypeMesure() {
        return typeMesure;
    }

    public String getTypeMesureArabe() {
        return typeMesureArabe;
    }

    public long getQteCommande() {
        return qteCommande;
    }

    public long getDateAchat() {
        return dateAchat;
    }

    public float getValpromo() {
        return valpromo;
    }

    public String getIdcommande() {
        return idcommande;
    }

    public long getIdDomaine() {
        return idDomaine;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public BigDecimal getPrixTotal() {
        return prixTotal;
    }
}
