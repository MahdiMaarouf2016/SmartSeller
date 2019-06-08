package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@DatabaseTable
public class BonDeSortie implements Serializable {
    //@JsonProperty("id")
    @DatabaseField(id = true)
    private long id;

    @JsonProperty("msgErreur")
    @DatabaseField
    private  String msgErreur;
    @JsonProperty("listBonSortiePaquetWS")
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private ArrayList<Packet> listBonSortiePaquetWS;

    public BonDeSortie() {

    }

}
/*
 @JsonProperty("codeLivreur")
    @DatabaseField
    private String codeLivreur;
    @JsonProperty("date")
    @DatabaseField
    private long date;
    @JsonProperty("idLivreur")
    @DatabaseField
    private long idLivreur;
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("ligneLivraison")
    @DatabaseField
    private String ligneLivraison;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("libelleEntreprise")
    @DatabaseField
    private String libelleEntreprise;
    @JsonProperty("codeEntreprise")
    @DatabaseField
    private String  codeEntreprise;
    @JsonProperty("idDomaine")
    @DatabaseField
    private Long idDomaine;
 */