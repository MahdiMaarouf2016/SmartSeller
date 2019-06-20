package symatique.smartseller.data.Factures;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class PrefixBL implements Serializable {
    @DatabaseField(generatedId = true)
    protected long id;
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

    public PrefixBL(){

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
}
