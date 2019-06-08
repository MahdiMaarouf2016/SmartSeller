package symatique.smartseller.data;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("idDomaine")
    @DatabaseField
    private long idDomaine;
    @DatabaseField
    @JsonProperty("id_EtatCommande")
    private Long id_EtatCommande;


    /*
     @JsonProperty("detailCommandes")
    @ForeignCollectionField(eager = true)
    private Collection<DetailCommande> detailCommandes = new ArrayList<>();
    @JsonProperty("libelleEntreprise")
    private String libelleEntreprise;
    @JsonProperty("codeEntreprise")
    private String codeEntreprise;
     @JsonProperty("codeDomaine")
    @DatabaseField
    private String codeDomaine;
     @JsonProperty("libelleDomaine")
    @DatabaseField
    private String libelleDomaine;
    */
    public Commande() {

    }

    public String getNumero() {
        return numero;
    }

    public long getDateSynch() {
        return dateSynch;
    }

    public BigDecimal getMontantHT() {
        return montantHT;
    }
}
