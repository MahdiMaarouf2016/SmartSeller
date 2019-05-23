package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class Vente implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("detailVentes")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<DetailVente> detailVentes;

    @JsonProperty("prefixBLS")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<PrefixBL> prefixBLS;
    @JsonProperty("encaissement")
    @DatabaseField(foreign = true)
    private Encaissement encaissement;
    @JsonProperty("natureVente")
    @DatabaseField(foreign = true)
    private NatureVente natureVente;

    @JsonProperty("stockParVendeurs")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<StockParVendeur> stockParVendeurs;
    @JsonProperty("stockParVendeur")
    @DatabaseField(foreign = true)
    private StockParVendeur stockParVendeur;

    public Vente() {
    }
}
