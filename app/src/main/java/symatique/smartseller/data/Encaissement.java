package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class Encaissement implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("banque")
    @DatabaseField(foreign = true)
    private Banque banque;

    @JsonProperty("ventes")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Vente> ventes;
    @JsonProperty("typeEncaissementVentes")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<TypeEncaissementVente> typeEncaissementVentes;
    @DatabaseField(foreign = true)
    private TypeEncaissementVente typeEncaissementVente;

    public Encaissement() {

    }
}
