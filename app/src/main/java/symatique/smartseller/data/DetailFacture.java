package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class DetailFacture implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("facture")
    @DatabaseField(foreign = true)
    private PrefixFacture facture;

    @JsonProperty("detailVente")
    @DatabaseField(foreign = true)
    private DetailVente detailVente;

    // *
    @DatabaseField(foreign = true)
    private PrefixBL prefixBL;

    public DetailFacture() {

    }
}
