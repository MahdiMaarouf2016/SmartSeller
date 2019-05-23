package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable
public class Entreprise implements Serializable {
    @JsonProperty("idEntreprise")
    @DatabaseField(id = true)
    private Long idEntreprise;


    @JsonProperty("domaines")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Domaine> domaines;
    @JsonProperty("livreurs")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Livreur> livreurs;

    public Entreprise(Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public Entreprise() {

    }
}
