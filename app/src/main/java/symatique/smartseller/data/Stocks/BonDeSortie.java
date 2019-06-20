package symatique.smartseller.data.Stocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

/***************************************************************************
 *
 *                               ORMLITE AND RETROFIT SERVICES
 *
 ***************************************************************************/
@DatabaseTable
public class BonDeSortie {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private long id = 0;

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
    private String codeEntreprise;
    @JsonProperty("idDomaine")
    @DatabaseField
    private Long idDomaine;
    @JsonProperty("libelleDomaine")
    @DatabaseField
    private String libelleDomaine;
    @JsonProperty("description")
    @DatabaseField
    private String description = "";
    @JsonProperty("codeDomaine")
    @DatabaseField
    private String codeDomaine;
    @JsonProperty("listPaquet")
    @DatabaseField(dataType = DataType.SERIALIZABLE)
    private ArrayList<Packet> listPaquet;

    public BonDeSortie() {

    }

    public BonDeSortie(long id, String codeLivreur, long date, long idLivreur, String libelle, String ligneLivraison, long idEntreprise, String libelleEntreprise, String codeEntreprise, Long idDomaine, String libelleDomaine, String codeDomaine, List<Packet> listPaquet) {
        this.id = id;
        this.codeLivreur = codeLivreur;
        this.date = date;
        this.idLivreur = idLivreur;
        this.libelle = libelle;
        this.ligneLivraison = ligneLivraison;
        this.idEntreprise = idEntreprise;
        this.libelleEntreprise = libelleEntreprise;
        this.codeEntreprise = codeEntreprise;
        this.idDomaine = idDomaine;
        this.libelleDomaine = libelleDomaine;
        this.codeDomaine = codeDomaine;
        this.listPaquet = (ArrayList)listPaquet;
    }

    public void setCodeLivreur(String codeLivreur) {
        this.codeLivreur = codeLivreur;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdLivreur(long idLivreur) {
        this.idLivreur = idLivreur;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLigneLivraison(String ligneLivraison) {
        this.ligneLivraison = ligneLivraison;
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

    public void setIdDomaine(Long idDomaine) {
        this.idDomaine = idDomaine;
    }

    public void setLibelleDomaine(String libelleDomaine) {
        this.libelleDomaine = libelleDomaine;
    }

    public void setCodeDomaine(String codeDomaine) {
        this.codeDomaine = codeDomaine;
    }

    public void setListPaquet(ArrayList<Packet> listPaquet) {
        this.listPaquet = listPaquet;
    }

    public String getCodeLivreur() {
        return codeLivreur;
    }

    public long getDate() {
        return date;
    }

    public long getId() {
        return id;
    }

    public long getIdLivreur() {
        return idLivreur;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getLigneLivraison() {
        return ligneLivraison;
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

    public Long getIdDomaine() {
        return idDomaine;
    }

    public String getLibelleDomaine() {
        return libelleDomaine;
    }

    public String getCodeDomaine() {
        return codeDomaine;
    }

    public ArrayList<Packet> getListPaquet() {
        return listPaquet;
    }
}
