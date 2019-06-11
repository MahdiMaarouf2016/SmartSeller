package symatique.smartseller.data.Factures;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class DetailFacture implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;


    public DetailFacture() {

    }
}
