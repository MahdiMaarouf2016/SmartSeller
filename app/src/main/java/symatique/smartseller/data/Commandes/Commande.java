package symatique.smartseller.data.Commandes;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
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
    @DatabaseField
    private BigDecimal montantHT;
    @JsonProperty("montantTTC")
    @DatabaseField
    private BigDecimal montantTTC;
    @JsonProperty("id_PointDeVente")
    @DatabaseField
    private Long id_PointDeVente;
    @JsonProperty("id_Client")
    @DatabaseField
    private Long id_Client;
    @JsonProperty("codeClient")
    @DatabaseField
    private String codeClient;
    @JsonProperty("libelleClient")
    @DatabaseField
    private String libelleClient;
    @JsonProperty("id_EtatCommande")
    @DatabaseField
    private Long id_EtatCommande;
    @JsonProperty("libelleEtatCommande")
    @DatabaseField
    private String libelleEtatCommande;
    @JsonProperty("suppCmd")
    @DatabaseField
    private boolean suppCmd;
    @JsonProperty("dateSynch")
    @DatabaseField
    private long dateSynch;
    @JsonProperty("idDomaine")
    @DatabaseField
    private long idDomaine;
    @JsonProperty("libelleDomaine")
    @DatabaseField
    private String libelleDomaine;
    @JsonProperty("codeDomaine")
    @DatabaseField
    private String codeDomaine;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("libelleEntreprise")
    @DatabaseField
    private String libelleEntreprise;
    @JsonProperty("codeEntreprise")
    @DatabaseField
    private String codeEntreprise;
    @JsonProperty("detailCommandes")
    @DatabaseField(dataType=DataType.SERIALIZABLE)
    private ArrayList<LigneCommande> detailCommandes = new ArrayList<>();

    public Commande() {

    }

    public Commande(String id, String numero, long dateCommande, BigDecimal montantHT, BigDecimal montantTTC, Long id_PointDeVente, Long id_Client, String codeClient, String libelleClient, Long id_EtatCommande, boolean suppCmd, long dateSynch, ArrayList<LigneCommande> detailCommandes, long idDomaine, String libelleDomaine, String codeDomaine, long idEntreprise, String libelleEntreprise, String codeEntreprise) {
        this.id = id;
        this.numero = numero;
        this.dateCommande = dateCommande;
        this.montantHT = montantHT;
        this.montantTTC = montantTTC;
        this.id_PointDeVente = id_PointDeVente;
        this.id_Client = id_Client;
        this.codeClient = codeClient;
        this.libelleClient = libelleClient;
        this.id_EtatCommande = id_EtatCommande;
        this.suppCmd = suppCmd;
        this.dateSynch = dateSynch;
        this.detailCommandes = detailCommandes;
        this.idDomaine = idDomaine;
        this.libelleDomaine = libelleDomaine;
        this.codeDomaine = codeDomaine;
        this.idEntreprise = idEntreprise;
        this.libelleEntreprise = libelleEntreprise;
        this.codeEntreprise = codeEntreprise;
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

    public Long getId_PointDeVente() {
        return id_PointDeVente;
    }

    public Long getId_Client() {
        return id_Client;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public String getLibelleClient() {
        return libelleClient;
    }

    public Long getId_EtatCommande() {
        return id_EtatCommande;
    }

    public boolean isSuppCmd() {
        return suppCmd;
    }

    public long getDateSynch() {
        return dateSynch;
    }

    public List<LigneCommande> getDetailCommandes() {
        return detailCommandes;
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

    public String getLibelleEntreprise() {
        return libelleEntreprise;
    }

    public String getCodeEntreprise() {
        return codeEntreprise;
    }

    public String getLibelleEtatCommande() {
        return libelleEtatCommande;
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

    public void setId_PointDeVente(Long id_PointDeVente) {
        this.id_PointDeVente = id_PointDeVente;
    }

    public void setId_Client(Long id_Client) {
        this.id_Client = id_Client;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public void setLibelleClient(String libelleClient) {
        this.libelleClient = libelleClient;
    }

    public void setId_EtatCommande(Long id_EtatCommande) {
        this.id_EtatCommande = id_EtatCommande;
    }

    public void setSuppCmd(boolean suppCmd) {
        this.suppCmd = suppCmd;
    }

    public void setDateSynch(long dateSynch) {
        this.dateSynch = dateSynch;
    }

    public void setDetailCommandes(List<LigneCommande> detailCommandes) {
        this.detailCommandes = (ArrayList<LigneCommande>) detailCommandes;
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

    public void setLibelleEntreprise(String libelleEntreprise) {
        this.libelleEntreprise = libelleEntreprise;
    }

    public void setCodeEntreprise(String codeEntreprise) {
        this.codeEntreprise = codeEntreprise;
    }

    public void setLibelleEtatCommande(String libelleEtatCommande) {
        this.libelleEtatCommande = libelleEtatCommande;
    }
}
