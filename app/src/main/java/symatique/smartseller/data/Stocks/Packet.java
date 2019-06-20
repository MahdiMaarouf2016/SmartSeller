package symatique.smartseller.data.Stocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
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
    protected int quantite = 0;
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
    @JsonProperty("prixConsommateur")
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal prixConsommateur;
    @JsonProperty("prixRevendeur")
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal prixRevendeur;
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

    public Packet(long id, String libelle, String codeBarre, int quantite, boolean etatSynchronisation, boolean etatVendu, double tva, long idArticle, String codeArticle, long idEntreprise, String libelleEntreprise, long date, long dateVente, String codeEntreprise, String codeClient, String description, String lot, String libelleArticle, long idBonSortie, long idClient, String libelleClient, boolean articleLie, double tvaLie, BigDecimal prixConsommateur, BigDecimal prixRevendeur, String codeArticleLie, String libelleArticleLie, double poids, boolean isSupprimer, long dateSynchro, long idDomaine, String libelleDomaine, String codeDomaine) {
        this.id = id;
        this.libelle = libelle;
        this.codeBarre = codeBarre;
        this.quantite = quantite;
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
        this.prixConsommateur = prixConsommateur;
        this.prixRevendeur = prixRevendeur;
        this.codeArticleLie = codeArticleLie;
        this.libelleArticleLie = libelleArticleLie;
        this.poids = poids;
        this.isSupprimer = isSupprimer;
        this.dateSynchro = dateSynchro;
        this.idDomaine = idDomaine;
        this.libelleDomaine = libelleDomaine;
        this.codeDomaine = codeDomaine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public boolean isEtatSynchronisation() {
        return etatSynchronisation;
    }

    public void setEtatSynchronisation(boolean etatSynchronisation) {
        this.etatSynchronisation = etatSynchronisation;
    }

    public boolean isEtatVendu() {
        return etatVendu;
    }

    public void setEtatVendu(boolean etatVendu) {
        this.etatVendu = etatVendu;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(long idArticle) {
        this.idArticle = idArticle;
    }

    public String getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getLibelleEntreprise() {
        return libelleEntreprise;
    }

    public void setLibelleEntreprise(String libelleEntreprise) {
        this.libelleEntreprise = libelleEntreprise;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getDateVente() {
        return dateVente;
    }

    public void setDateVente(long dateVente) {
        this.dateVente = dateVente;
    }

    public String getCodeEntreprise() {
        return codeEntreprise;
    }

    public void setCodeEntreprise(String codeEntreprise) {
        this.codeEntreprise = codeEntreprise;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getLibelleArticle() {
        return libelleArticle;
    }

    public void setLibelleArticle(String libelleArticle) {
        this.libelleArticle = libelleArticle;
    }

    public long getIdBonSortie() {
        return idBonSortie;
    }

    public void setIdBonSortie(long idBonSortie) {
        this.idBonSortie = idBonSortie;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getLibelleClient() {
        return libelleClient;
    }

    public void setLibelleClient(String libelleClient) {
        this.libelleClient = libelleClient;
    }

    public boolean isArticleLie() {
        return articleLie;
    }

    public void setArticleLie(boolean articleLie) {
        this.articleLie = articleLie;
    }

    public double getTvaLie() {
        return tvaLie;
    }

    public void setTvaLie(double tvaLie) {
        this.tvaLie = tvaLie;
    }

    public BigDecimal getPrixConsommateur() {
        return prixConsommateur;
    }

    public void setPrixConsommateur(BigDecimal prixConsommateur) {
        this.prixConsommateur = prixConsommateur;
    }

    public BigDecimal getPrixRevendeur() {
        return prixRevendeur;
    }

    public void setPrixRevendeur(BigDecimal prixRevendeur) {
        this.prixRevendeur = prixRevendeur;
    }

    public String getCodeArticleLie() {
        return codeArticleLie;
    }

    public void setCodeArticleLie(String codeArticleLie) {
        this.codeArticleLie = codeArticleLie;
    }

    public String getLibelleArticleLie() {
        return libelleArticleLie;
    }

    public void setLibelleArticleLie(String libelleArticleLie) {
        this.libelleArticleLie = libelleArticleLie;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public boolean isSupprimer() {
        return isSupprimer;
    }

    public void setSupprimer(boolean supprimer) {
        isSupprimer = supprimer;
    }

    public long getDateSynchro() {
        return dateSynchro;
    }

    public void setDateSynchro(long dateSynchro) {
        this.dateSynchro = dateSynchro;
    }

    public long getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(long idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getLibelleDomaine() {
        return libelleDomaine;
    }

    public void setLibelleDomaine(String libelleDomaine) {
        this.libelleDomaine = libelleDomaine;
    }

    public String getCodeDomaine() {
        return codeDomaine;
    }

    public void setCodeDomaine(String codeDomaine) {
        this.codeDomaine = codeDomaine;
    }

    @Override
    public boolean equals(Object object) {
        boolean equals = false;
        if (object instanceof Packet)
            equals = ((Packet) object).getId() == this.id;

        return false;
    }
}
