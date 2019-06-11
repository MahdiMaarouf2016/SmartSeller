package symatique.smartseller.data.Articles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
/***************************************************************************
 *
 *                               SQLITE AND RETROFIT SERVICES
 *
 ***************************************************************************/
@DatabaseTable
public class Entreprise implements Serializable {
    @JsonProperty("idEntreprise")
    @DatabaseField(id = true)
    private Long idEntreprise;

    public Entreprise() {

    }


}
