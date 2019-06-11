package symatique.smartseller.data.Stocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.math.BigDecimal;
/***************************************************************************
 *
 *                               ORMLITE AND RETROFIT SERVICES
 *
 ***************************************************************************/
@DatabaseTable
public class Packet {

    @JsonProperty("id")
    @DatabaseField(id = true)
    protected long id;

    @JsonProperty("libelle")
    @DatabaseField
    protected String libelle = "";
    @JsonProperty("codeBarre")
    @DatabaseField
    protected String codeBarre = "";
    @JsonProperty("quantite")
    @DatabaseField
    protected double quantite = 0;
    @JsonProperty("prixUnitaireHT")
    @DatabaseField
    protected BigDecimal prixUnitaireHT;
    @JsonProperty("etatSynchronisation")
    @DatabaseField
    protected boolean etatSynchronisation;
    @JsonProperty("etatVendu")
    @DatabaseField
    protected boolean etatVendu;
    @JsonProperty("tva")
    @DatabaseField
    protected double tva = 0;
    @JsonProperty("idArticle")
    @DatabaseField
    protected long idArticle = 00L;
    @JsonProperty("codeArticle")
    @DatabaseField
    protected String codeArticle = "";
    @JsonProperty("idEntreprise")
    @DatabaseField
    protected long idEntreprise = 00L;
    @JsonProperty("libelleEntreprise")
    @DatabaseField
    protected String libelleEntreprise = "";
    @JsonProperty("datePaquet")
    @DatabaseField
    protected long date = 0;
    @DatabaseField
    protected long dateVente = 0;
    @JsonProperty("codeEntreprise")
    @DatabaseField
    protected String codeEntreprise = "";
    @JsonProperty("codeClient")
    @DatabaseField
    protected String codeClient = "";
    @JsonProperty("description")
    @DatabaseField
    protected String description;
    @JsonProperty("lot")
    @DatabaseField
    protected String lot = "";
    @JsonProperty("libelleArticle")
    @DatabaseField
    protected String libelleArticle = "";
    @JsonProperty("idBonSortie")
    @DatabaseField
    protected long idBonSortie = 0;
    @DatabaseField
    protected long idClient = 0;
    @DatabaseField
    protected String libelleClient = "";
    @JsonProperty("articleLie")
    @DatabaseField
    protected boolean articleLie;
    @JsonProperty("tvaLie")
    @DatabaseField
    protected double tvaLie = 0;
    @JsonProperty("prixUnitaireHTLie")
    @DatabaseField
    protected BigDecimal prixUnitaireHTLie;
    @JsonProperty("codeArticleLie")
    @DatabaseField
    protected String codeArticleLie = "";
    @JsonProperty("libelleArticleLie")
    @DatabaseField
    protected String libelleArticleLie = "";
    @JsonProperty("poids")
    @DatabaseField
    protected double poids = 0;
    @JsonProperty("supprimer")
    @DatabaseField
    protected boolean isSupprimer;
    @JsonProperty("dateSynch")
    @DatabaseField
    protected long dateSynchro;
    @JsonProperty("idDomaine")
    @DatabaseField
    protected long idDomaine;
    @JsonProperty("libelleDomaine")
    @DatabaseField
    protected String libelleDomaine;
    @JsonProperty("codeDomaine")
    @DatabaseField
    protected String codeDomaine;

    public Packet() {
    }

    public Packet(long id, String libelle, String codeBarre, double quantite, BigDecimal prixUnitaireHT, boolean etatSynchronisation, boolean etatVendu, double tva, long idArticle, String codeArticle, long idEntreprise, String libelleEntreprise, long date, long dateVente, String codeEntreprise, String codeClient, String description, String lot, String libelleArticle, long idBonSortie, long idClient, String libelleClient, boolean articleLie, double tvaLie, BigDecimal prixUnitaireHTLie, String codeArticleLie, String libelleArticleLie, double poids, boolean isSupprimer, long dateSynchro, long idDomaine, String libelleDomaine, String codeDomaine) {
        this.id = id;
        this.libelle = libelle;
        this.codeBarre = codeBarre;
        this.quantite = quantite;
        this.prixUnitaireHT = prixUnitaireHT;
        this.etatSynchronisation = etatSynchronisation;
        this.etatVendu = etatVendu;
        this.tva = tva;
        this.idArticle = idArticle;
        this.codeArticle = codeArticle;
        this.idEntreprise = idEntreprise;
        this.libelleEntreprise = libelleEntreprise;
        this.date = date;
        this.dateVente = dateVente;
        this.codeEntreprise = codeEntreprise;
        this.codeClient = codeClient;
        this.description = description;
        this.lot = lot;
        this.libelleArticle = libelleArticle;
        this.idBonSortie = idBonSortie;
        this.idClient = idClient;
        this.libelleClient = libelleClient;
        this.articleLie = articleLie;
        this.tvaLie = tvaLie;
        this.prixUnitaireHTLie = prixUnitaireHTLie;
        this.codeArticleLie = codeArticleLie;
        this.libelleArticleLie = libelleArticleLie;
        this.poids = poids;
        this.isSupprimer = isSupprimer;
        this.dateSynchro = dateSynchro;
        this.idDomaine = idDomaine;
        this.libelleDomaine = libelleDomaine;
        this.codeDomaine = codeDomaine;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public void setPrixUnitaireHT(BigDecimal prixUnitaireHT) {
        this.prixUnitaireHT = prixUnitaireHT;
    }

    public void setEtatSynchronisation(boolean etatSynchronisation) {
        this.etatSynchronisation = etatSynchronisation;
    }

    public void setEtatVendu(boolean etatVendu) {
        this.etatVendu = etatVendu;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public void setIdArticle(long idArticle) {
        this.idArticle = idArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setLibelleEntreprise(String libelleEntreprise) {
        this.libelleEntreprise = libelleEntreprise;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setDateVente(long dateVente) {
        this.dateVente = dateVente;
    }

    public void setCodeEntreprise(String codeEntreprise) {
        this.codeEntreprise = codeEntreprise;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public void setLibelleArticle(String libelleArticle) {
        this.libelleArticle = libelleArticle;
    }

    public void setIdBonSortie(long idBonSortie) {
        this.idBonSortie = idBonSortie;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public void setLibelleClient(String libelleClient) {
        this.libelleClient = libelleClient;
    }

    public void setArticleLie(boolean articleLie) {
        this.articleLie = articleLie;
    }

    public void setTvaLie(double tvaLie) {
        this.tvaLie = tvaLie;
    }

    public void setPrixUnitaireHTLie(BigDecimal prixUnitaireHTLie) {
        this.prixUnitaireHTLie = prixUnitaireHTLie;
    }

    public void setCodeArticleLie(String codeArticleLie) {
        this.codeArticleLie = codeArticleLie;
    }

    public void setLibelleArticleLie(String libelleArticleLie) {
        this.libelleArticleLie = libelleArticleLie;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setSupprimer(boolean supprimer) {
        isSupprimer = supprimer;
    }

    public void setDateSynchro(long dateSynchro) {
        this.dateSynchro = dateSynchro;
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

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public double getQuantite() {
        return quantite;
    }

    public BigDecimal getPrixUnitaireHT() {
        return prixUnitaireHT;
    }

    public boolean isEtatSynchronisation() {
        return etatSynchronisation;
    }

    public boolean isEtatVendu() {
        return etatVendu;
    }

    public double getTva() {
        return tva;
    }

    public long getIdArticle() {
        return idArticle;
    }

    public String getCodeArticle() {
        return codeArticle;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public String getLibelleEntreprise() {
        return libelleEntreprise;
    }

    public long getDate() {
        return date;
    }

    public long getDateVente() {
        return dateVente;
    }

    public String getCodeEntreprise() {
        return codeEntreprise;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public String getDescription() {
        return description;
    }

    public String getLot() {
        return lot;
    }

    public String getLibelleArticle() {
        return libelleArticle;
    }

    public long getIdBonSortie() {
        return idBonSortie;
    }

    public long getIdClient() {
        return idClient;
    }

    public String getLibelleClient() {
        return libelleClient;
    }

    public boolean isArticleLie() {
        return articleLie;
    }

    public double getTvaLie() {
        return tvaLie;
    }

    public BigDecimal getPrixUnitaireHTLie() {
        return prixUnitaireHTLie;
    }

    public String getCodeArticleLie() {
        return codeArticleLie;
    }

    public String getLibelleArticleLie() {
        return libelleArticleLie;
    }

    public double getPoids() {
        return poids;
    }

    public boolean isSupprimer() {
        return isSupprimer;
    }

    public long getDateSynchro() {
        return dateSynchro;
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
}
