package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;
@DatabaseTable
public class StockParVendeur implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;//id vendeur

    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("code")
    @DatabaseField
    private String code;
    @JsonProperty("type")
    @DatabaseField
    private int type;// 0: Vendeur Ambulant
    @JsonProperty("idEntreprise")
    @DatabaseField
    private Long idEntreprise;

    @JsonProperty("bonDeSorties")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<BonDeSortie> bonDeSorties;

    @JsonProperty("detailStocks")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<DetailStock> detailStocks;

    @JsonProperty("ventes")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Vente> ventes;
    @DatabaseField(foreign = true)
    private Vente vente;

    public StockParVendeur(){

    }

    public StockParVendeur(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getCode() {
        return code;
    }

    public int getType() {
        return type;
    }

    public Long getIdEntreprise() {
        return idEntreprise;
    }

    public ForeignCollection<BonDeSortie> getBonDeSorties() {
        return bonDeSorties;
    }

    public ForeignCollection<DetailStock> getDetailStocks() {
        return detailStocks;
    }

    public ForeignCollection<Vente> getVentes() {
        return ventes;
    }

    public Vente getVente() {
        return vente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setIdEntreprise(Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setBonDeSorties(ForeignCollection<BonDeSortie> bonDeSorties) {
        this.bonDeSorties = bonDeSorties;
    }

    public void setDetailStocks(ForeignCollection<DetailStock> detailStocks) {
        this.detailStocks = detailStocks;
    }

    public void setVentes(ForeignCollection<Vente> ventes) {
        this.ventes = ventes;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }
}
