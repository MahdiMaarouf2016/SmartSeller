package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class DetailVente implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;


    public DetailVente() {
    }
}
