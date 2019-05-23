package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class MotifRapportVisite implements Serializable {
    @JsonProperty("id")
    @DatabaseField(id = true)
    private long id;

    @JsonProperty("rapportVisites")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<RapportVisite> rapportVisites;

    @JsonProperty("idEntreprise")
    @DatabaseField
    Long idEntreprise;

    public MotifRapportVisite() {
    }
}
