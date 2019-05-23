package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class BonDeSortie implements Serializable {
    @JsonProperty("id")
    @DatabaseField(id = true)
    private long id;

    @JsonProperty("idLivreur")
    @DatabaseField
    private long idLivreur;
    @JsonProperty("date")
    @DatabaseField
    private long date;
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;


    @JsonProperty("domaine")
    @DatabaseField(foreign = true)
    private Domaine domaine;
    @JsonProperty("StockParVendeur")
    @DatabaseField(foreign = true)
    private StockParVendeur stockParVendeur ;

    @JsonProperty("detailBonDeSorties")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<DetailBonDeSortie> detailBonDeSorties;

    public BonDeSortie() {

    }

    public long getId() {
        return id;
    }

    public long getIdLivreur() {
        return idLivreur;
    }

    public long getDate() {
        return date;
    }

    public String getLibelle() {
        return libelle;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public StockParVendeur getStockParVendeur() {
        return stockParVendeur;
    }

    public ForeignCollection<DetailBonDeSortie> getDetailBonDeSorties() {
        return detailBonDeSorties;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdLivreur(long idLivreur) {
        this.idLivreur = idLivreur;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public void setStockParVendeur(StockParVendeur stockParVendeur) {
        this.stockParVendeur = stockParVendeur;
    }

    public void setDetailBonDeSorties(ForeignCollection<DetailBonDeSortie> detailBonDeSorties) {
        this.detailBonDeSorties = detailBonDeSorties;
    }
}
