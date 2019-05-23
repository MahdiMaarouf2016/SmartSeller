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
public class Commande implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private String id;

    @JsonProperty("numero")
    @DatabaseField
    private String numero;
    @JsonProperty("dateCommande")
    @DatabaseField
    private long dateCommande;
    @JsonProperty("montantHT")
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal montantHT;
    @JsonProperty("montantTTC")
    @DatabaseField(dataType = DataType.BIG_DECIMAL)
    private BigDecimal montantTTC;
    @JsonProperty("suppCmd")
    @DatabaseField
    private boolean suppCmd;
    @JsonProperty("dateSynch")
    @DatabaseField
    private long dateSynch;

    @JsonProperty("livreur")
    @DatabaseField(foreign = true)
    private Livreur livreur;
    @JsonProperty("detailCommandes")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<DetailCommande> detailCommandes ;
    @JsonProperty("etatCommande")
    @DatabaseField(foreign = true)
    private EtatCommande etatCommande;

    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
     @JsonProperty("codeDomaine")
    @DatabaseField
    private String codeDomaine;
     @JsonProperty("libelleDomaine")
    @DatabaseField
    private String libelleDomaine;
     @JsonProperty("idDomaine")
    @DatabaseField
    private long idDomaine;

    public Commande() {

    }

    public String getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public long getDateCommande() {
        return dateCommande;
    }

    public BigDecimal getMontantHT() {
        return montantHT;
    }

    public BigDecimal getMontantTTC() {
        return montantTTC;
    }

    public boolean isSuppCmd() {
        return suppCmd;
    }

    public long getDateSynch() {
        return dateSynch;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public ForeignCollection<DetailCommande> getDetailCommandes() {
        return detailCommandes;
    }

    public EtatCommande getEtatCommande() {
        return etatCommande;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDateCommande(long dateCommande) {
        this.dateCommande = dateCommande;
    }

    public void setMontantHT(BigDecimal montantHT) {
        this.montantHT = montantHT;
    }

    public void setMontantTTC(BigDecimal montantTTC) {
        this.montantTTC = montantTTC;
    }

    public void setSuppCmd(boolean suppCmd) {
        this.suppCmd = suppCmd;
    }

    public void setDateSynch(long dateSynch) {
        this.dateSynch = dateSynch;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public void setDetailCommandes(ForeignCollection<DetailCommande> detailCommandes) {
        this.detailCommandes = detailCommandes;
    }

    public void setEtatCommande(EtatCommande etatCommande) {
        this.etatCommande = etatCommande;
    }
}
