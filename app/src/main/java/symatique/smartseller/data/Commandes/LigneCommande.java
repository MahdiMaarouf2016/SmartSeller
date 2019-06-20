package symatique.smartseller.data.Commandes;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import symatique.smartseller.data.Articles.Article;

import java.io.Serializable;

/***************************************************************************
 *
 *                               SQLITE AND RETROFIT SERVICES
 *
 ***************************************************************************/

@DatabaseTable
public class LigneCommande implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private String id;
    @JsonProperty("idArticle")
    @DatabaseField
    private long idArticle = 0l;
    @JsonProperty("codeArticle")
    @DatabaseField
    private String code = "";
    @JsonProperty("codeEntreprise")
    @DatabaseField
    private String codeEntreprise = "";
    @JsonProperty("dateSynchro")
    @DatabaseField
    private long dateSynchro = 0l;
    @JsonProperty("description")
    @DatabaseField
    private String description = "";
    @JsonProperty("descriptionArb")
    @DatabaseField
    private String descriptionArb = "";
    @JsonProperty("enPromo")
    @DatabaseField
    private Boolean enPromo = false;
    @JsonProperty("idCategorie")
    @DatabaseField
    private long idCategorie = 0l;
    @JsonProperty("libelleCategorie")
    @DatabaseField
    private String libelleCategorie = "";
    @JsonProperty("libelleArticle")
    @DatabaseField
    private String libelle = "";
    @JsonProperty("libelleArticleAr")
    @DatabaseField
    private String libelleArb = "";
    @JsonProperty("photo")
    @DatabaseField
    private String photo1 = "";
    @JsonProperty("photo2")
    @DatabaseField
    private String photo2 = "";
    @JsonProperty("photo3")
    @DatabaseField
    private String photo3 = "";
    @JsonProperty("photo4")
    @DatabaseField
    private String photo4 = "";
    @JsonProperty("photo5")
    @DatabaseField
    private String photo5 = "";
    @JsonProperty("prixConsommateur")
    @DatabaseField
    private BigDecimal prixConsommateur = BigDecimal.valueOf(0);
    @JsonProperty("prixUnitaireHT")
    @DatabaseField
    private BigDecimal prixRevendeur = BigDecimal.valueOf(0);
    @JsonProperty("promoUnitaire")
    @DatabaseField
    private Integer promoUnitaire = 0;
    @JsonProperty("supprimer")
    @DatabaseField
    private Boolean supprimer = false;
    @JsonProperty("tva")
    @DatabaseField
    private String tva = "";
    @JsonProperty("typeMesure")
    @DatabaseField
    private String typeMesure = "";
    @JsonProperty("typeMesureArabe")
    @DatabaseField
    private String typeMesureArabe = "";
    @JsonProperty("quantite")
    @DatabaseField
    private long qteCommande = 0;
    @JsonProperty("dateAchat")
    @DatabaseField
    private long dateAchat = 0l;
    @JsonProperty("valpromo")
    @DatabaseField
    private float valpromo = 0;
    @JsonProperty("idcommande")
    @DatabaseField
    private String idcommande = "";

    @JsonProperty("idDomaine")
    @DatabaseField
    private long idDomaine = 0l;
    @JsonProperty("libelleDomaine")
    @DatabaseField
    private String libelleDomaine = "";
    @JsonProperty("codeDomaine")
    @DatabaseField
    private String codeDomaine = "";
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise = 0l;
    @DatabaseField
    private BigDecimal prixTotal = BigDecimal.valueOf(0);

    public LigneCommande() {

    }

    public LigneCommande(final Article article) {

        this.setIdArticle(article.getId());
        this.setIdCategorie(article.getIdCategorie());
        this.setPhoto1(article.getPhoto1());
        this.setPhoto2(article.getPhoto2());
        this.setPhoto3(article.getPhoto3());
        this.setPhoto4(article.getPhoto4());
        this.setPhoto5(article.getPhoto5());
        this.setEnPromo(article.getEnPromo());
        this.setDescriptionArb(article.getDescription());
        this.setDescription(article.getDescription());
        this.setLibelle(article.getLibelle());
        this.setLibelleArb(article.getLibelleArb());
        this.setCode(article.getCode());
        this.setPrixConsommateur(article.getPrixConsommateur());
        this.setPrixRevendeur(article.getPrixRevendeur());
        this.setTypeMesure(article.getTypeMesure());
        this.setTypeMesureArabe(article.getTypeMesureArabe());
        this.setPromoUnitaire(article.getPromoUnitaire());
        this.setLibelleCategorie(article.getLibelleCategorie());
        this.setSupprimer(article.getSupprimer());
        this.setIdDomaine(article.getIdEntreprise());
    }

    public String getId() {
        return id;
    }

    public long getIdArticle() {
        return idArticle;
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

    public String getLibelleDomaine() {
        return libelleDomaine;
    }

    public String getCodeDomaine() {
        return codeDomaine;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public BigDecimal getPrixTotal() {
        return prixTotal;
    }
    // SETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setIdArticle(long idArticle) {
        this.idArticle = idArticle;
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

    public void setIdCategorie(long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
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

    public void setQteCommande(long qteCommande) {
        this.qteCommande = qteCommande;
    }

    public void setDateAchat(long dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setValpromo(float valpromo) {
        this.valpromo = valpromo;
    }

    public void setIdcommande(String idcommande) {
        this.idcommande = idcommande;
    }

    public void setIdDomaine(long idDomaine) {
        this.idDomaine = idDomaine;
    }

    public void setLibelleDomaine(String libelleDomaine) {
        this.libelleDomaine = libelleDomaine;
    }

    public void setCodeDomaine(String codeDomaine) {
        this.codeDomaine = codeDomaine;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setPrixTotal(BigDecimal prixTotal) {
        this.prixTotal = prixTotal;
    }
}
