package symatique.smartseller.data.Encaissements;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import symatique.smartseller.data.Factures.Facture;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***************************************************************************
 *
 *
 *
 ***************************************************************************/

@DatabaseTable
public class Encaissement implements Serializable {

    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;
    @JsonProperty("valeur")
    @DatabaseField
    private BigDecimal valeur;
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;

    @DatabaseField(foreign = true)
    private Facture facture;
    public Encaissement() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }
}
