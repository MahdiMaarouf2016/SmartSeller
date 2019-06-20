package symatique.smartseller.data.Factures;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.math.BigDecimal;

@DatabaseTable
public class LigneFacture {

    @JsonProperty("id")
    @DatabaseField(id = true)
    protected long id;

    @JsonProperty("idArticle")
    @DatabaseField
    protected long idArticle;

    @JsonProperty("libelleArticle")
    @DatabaseField
    protected String libelleArticle;

    @JsonProperty("codeArticle")
    @DatabaseField
    protected String codeArticle;

    @JsonProperty("tvaArticle")
    @DatabaseField
    protected double tvaArticle;

    @JsonProperty("quantite")
    @DatabaseField
    protected double quantite;

    @JsonProperty("prixUnitaireHT")
    @DatabaseField
    protected BigDecimal prixUnitaireHT;


    @JsonProperty("valeurHT")
    @DatabaseField
    protected BigDecimal valeurHT;

    @JsonProperty("valeurTTC")
    @DatabaseField
    protected BigDecimal valeurTTC;


    @JsonProperty("codeEts")
    @DatabaseField
    protected String codeEts;

    @JsonProperty("idFacture")
    @DatabaseField
    private long idFacture;

    @JsonProperty("restAPayer")
    @DatabaseField
    private BigDecimal restAPayer;

    public LigneFacture() {

    }

    public LigneFacture(LigneFacture ligneFactureActive) {
        this.id = ligneFactureActive.getId();
        this.idArticle = ligneFactureActive.getIdArticle();
        this.libelleArticle = ligneFactureActive.getLibelleArticle();
        this.codeArticle = ligneFactureActive.getCodeArticle();
        this.tvaArticle = ligneFactureActive.getTvaArticle();
        this.quantite = ligneFactureActive.getQuantite();
        this.prixUnitaireHT = ligneFactureActive.getPrixUnitaireHT();
        this.valeurHT = ligneFactureActive.getValeurHT();
        this.valeurTTC = ligneFactureActive.getValeurTTC();
        this.codeEts = ligneFactureActive.getCodeEts();
        this.restAPayer = ligneFactureActive.getRestAPayer();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(long idArticle) {
        this.idArticle = idArticle;
    }

    public String getLibelleArticle() {
        return libelleArticle;
    }

    public void setLibelleArticle(String libelleArticle) {
        this.libelleArticle = libelleArticle;
    }

    public String getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    public double getTvaArticle() {
        return tvaArticle;
    }

    public void setTvaArticle(double tvaArticle) {
        this.tvaArticle = tvaArticle;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixUnitaireHT() {
        return prixUnitaireHT;
    }

    public void setPrixUnitaireHT(BigDecimal prixUnitaireHT) {
        this.prixUnitaireHT = prixUnitaireHT;
    }

    public BigDecimal getValeurHT() {
        return valeurHT;
    }

    public void setValeurHT(BigDecimal valeurHT) {
        this.valeurHT = valeurHT;
    }

    public BigDecimal getValeurTTC() {
        return valeurTTC;
    }

    public void setValeurTTC(BigDecimal valeurTTC) {
        this.valeurTTC = valeurTTC;
    }

    public String getCodeEts() {
        return codeEts;
    }

    public void setCodeEts(String codeEts) {
        this.codeEts = codeEts;
    }

    public long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(long idFacture) {
        this.idFacture = idFacture;
    }

    public BigDecimal getRestAPayer() {
        return restAPayer;
    }

    public void setRestAPayer(BigDecimal restAPayer) {
        this.restAPayer = restAPayer;
    }
}
