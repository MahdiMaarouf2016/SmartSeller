package symatique.smartseller.data.Factures;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@DatabaseTable
public class PrefixFacture implements Serializable {
    @DatabaseField(generatedId = true)
    protected long id;
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
    @JsonProperty("idDomaine")
    @DatabaseField
    private long idDomaine;
    @JsonProperty("libelleDomaine")
    @DatabaseField
    private String libelleDomaine;
    @JsonProperty("codeDomaine")
    @DatabaseField
    private String codeDomaine;
    @JsonProperty("msgErreur")
    private String msgErreur;

    public PrefixFacture() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodeEntreprise() {
        return codeEntreprise;
    }

    public void setCodeEntreprise(String codeEntreprise) {
        this.codeEntreprise = codeEntreprise;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getCodeVendeur() {
        return codeVendeur;
    }

    public void setCodeVendeur(String codeVendeur) {
        this.codeVendeur = codeVendeur;
    }

    public long getCompteur() {
        return compteur;
    }

    public void setCompteur(long compteur) {
        this.compteur = compteur;
    }

    public String getLibellePrefixe() {
        return libellePrefixe;
    }

    public void setLibellePrefixe(String libellePrefixe) {
        this.libellePrefixe = libellePrefixe;
    }

    public long getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(long idLivreur) {
        this.idLivreur = idLivreur;
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

    public String getMsgErreur() {
        return msgErreur;
    }

    public void setMsgErreur(String msgErreur) {
        this.msgErreur = msgErreur;
    }
}
