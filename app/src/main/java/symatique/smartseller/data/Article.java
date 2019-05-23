package symatique.smartseller.data;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class Article implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private long id;

    @JsonProperty("code")
    @DatabaseField
    private String code;
    @JsonProperty("codeEntreprise")
    @DatabaseField
    private String codeEntreprise;
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
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("libelleArb")
    @DatabaseField
    private String libelleArb;
    @JsonProperty("photo1")
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
    @JsonProperty("prixRevendeur")
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
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;

    @JsonProperty("domaine")
    @DatabaseField(canBeNull = false, foreign = true)
    private Domaine domaine;
    @JsonProperty("categorieArticle")
    @DatabaseField(canBeNull = false, foreign = true)
    private CategorieArticle categorieArticle;

    public Article() {

    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCodeEntreprise() {
        return codeEntreprise;
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

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public CategorieArticle getCategorieArticle() {
        return categorieArticle;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodeEntreprise(String codeEntreprise) {
        this.codeEntreprise = codeEntreprise;
    }

    public void setDateSynchro(long dateSynchro) {
        this.dateSynchro = dateSynchro;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDescriptionArb(String descriptionArb) {
        this.descriptionArb = descriptionArb;
    }

    public void setEnPromo(Boolean enPromo) {
        this.enPromo = enPromo;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLibelleArb(String libelleArb) {
        this.libelleArb = libelleArb;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public void setPhoto4(String photo4) {
        this.photo4 = photo4;
    }

    public void setPhoto5(String photo5) {
        this.photo5 = photo5;
    }

    public void setPrixConsommateur(BigDecimal prixConsommateur) {
        this.prixConsommateur = prixConsommateur;
    }

    public void setPrixRevendeur(BigDecimal prixRevendeur) {
        this.prixRevendeur = prixRevendeur;
    }

    public void setPromoUnitaire(Integer promoUnitaire) {
        this.promoUnitaire = promoUnitaire;
    }

    public void setSupprimer(Boolean supprimer) {
        this.supprimer = supprimer;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public void setTypeMesure(String typeMesure) {
        this.typeMesure = typeMesure;
    }

    public void setTypeMesureArabe(String typeMesureArabe) {
        this.typeMesureArabe = typeMesureArabe;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public void setCategorieArticle(CategorieArticle categorieArticle) {
        this.categorieArticle = categorieArticle;
    }
}
