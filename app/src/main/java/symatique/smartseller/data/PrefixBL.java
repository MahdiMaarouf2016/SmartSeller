package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
@DatabaseTable
public class PrefixBL extends PrefixFacture implements Serializable {

    @JsonProperty("codeEntreprise")
    @DatabaseField
    private String codeEntreprise;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("codeVendeur")
    @DatabaseField
    private String codeVendeur;
    @JsonProperty("compteur")
    @DatabaseField
    private long compteur;
    @JsonProperty("libellePrefixe")
    @DatabaseField
    private String libellePrefixe;
    @JsonProperty("idLivreur")
    @DatabaseField
    private long idLivreur;
    @JsonProperty("msgErreur")
    private String msgErreur;
    @JsonProperty("idDomaine")
    @DatabaseField
    private long idDomaine;
    @JsonProperty("libelleDomaine")
    @DatabaseField
    private String libelleDomaine;
    @JsonProperty("codeDomaine")
    @DatabaseField
    private String codeDomaine;

    @JsonProperty("client")
    @DatabaseField(foreign = true,canBeNull = false)
    private Client client;
    @JsonProperty("vente")
    @DatabaseField(foreign = true,canBeNull = false)
    private Vente vente;
    @JsonProperty("domaine")
    @DatabaseField(foreign = true,canBeNull = false)
    private Domaine domaine;
    @JsonProperty("detailBLS")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<DetailBL> detailBLS;

    public PrefixBL(){

    }
    public PrefixBL(String codeEntreprise) {
        this.codeEntreprise = codeEntreprise;
    }

    public String getCodeEntreprise() {
        return codeEntreprise;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public String getCodeVendeur() {
        return codeVendeur;
    }

    public long getCompteur() {
        return compteur;
    }

    public String getLibellePrefixe() {
        return libellePrefixe;
    }

    public long getIdLivreur() {
        return idLivreur;
    }

    public String getMsgErreur() {
        return msgErreur;
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

    public Client getClient() {
        return client;
    }

    public Vente getVente() {
        return vente;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public ForeignCollection<DetailBL> getDetailBLS() {
        return detailBLS;
    }

    public void setCodeEntreprise(String codeEntreprise) {
        this.codeEntreprise = codeEntreprise;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setCodeVendeur(String codeVendeur) {
        this.codeVendeur = codeVendeur;
    }

    public void setCompteur(long compteur) {
        this.compteur = compteur;
    }

    public void setLibellePrefixe(String libellePrefixe) {
        this.libellePrefixe = libellePrefixe;
    }

    public void setIdLivreur(long idLivreur) {
        this.idLivreur = idLivreur;
    }

    public void setMsgErreur(String msgErreur) {
        this.msgErreur = msgErreur;
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

    public void setClient(Client client) {
        this.client = client;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public void setDetailBLS(ForeignCollection<DetailBL> detailBLS) {
        this.detailBLS = detailBLS;
    }
}
