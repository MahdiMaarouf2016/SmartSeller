package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;

import java.math.BigDecimal;

class Packet {
    @JsonProperty("id")
    @DatabaseField(id = true)
    protected long id;

    @JsonProperty("libelle")
    @DatabaseField
    protected String libelle = "";
    @JsonProperty("codeBarre")
    @DatabaseField
    protected String codeBarre = "";
    @JsonProperty("quantite")
    @DatabaseField
    protected double quantite = 0;
    @JsonProperty("prixUnitaireHT")
    @DatabaseField
    protected BigDecimal prixUnitaireHT;
    @JsonProperty("etatSynchronisation")
    @DatabaseField
    protected boolean etatSynchronisation;
    @JsonProperty("etatVendu")
    @DatabaseField
    protected boolean etatVendu;
    @JsonProperty("tva")
    @DatabaseField
    protected double tva = 0;
    @JsonProperty("idArticle")
    @DatabaseField
    protected long idArticle = 00L;
    @JsonProperty("codeArticle")
    @DatabaseField
    protected String codeArticle = "";
    @JsonProperty("idEntreprise")
    @DatabaseField
    protected long idEntreprise = 00L;
    @JsonProperty("libelleEntreprise")
    @DatabaseField
    protected String libelleEntreprise = "";
    @JsonProperty("datePaquet")
    @DatabaseField
    protected long date = 0;
    protected long dateVente = 0;
    @JsonProperty("codeEntreprise")
    @DatabaseField
    protected String codeEntreprise = "";
    @JsonProperty("codeClient")
    @DatabaseField
    protected String codeClient = "";
    @JsonProperty("description")
    @DatabaseField
    protected String description;
    @JsonProperty("lot")
    @DatabaseField
    protected String lot = "";
    @JsonProperty("libelleArticle")
    @DatabaseField
    protected String libelleArticle = "";
    @JsonProperty("idBonSortie")
    @DatabaseField
    protected long idBonSortie = 0;
    protected long idClient = 0;
    protected String libelleClient = "";
    @JsonProperty("articleLie")
    @DatabaseField
    protected boolean articleLie;
    @JsonProperty("tvaLie")
    @DatabaseField
    protected double tvaLie = 0;
    @JsonProperty("prixUnitaireHTLie")
    @DatabaseField
    protected BigDecimal prixUnitaireHTLie;
    @JsonProperty("codeArticleLie")
    @DatabaseField
    protected String codeArticleLie = "";
    @JsonProperty("libelleArticleLie")
    @DatabaseField
    protected String libelleArticleLie = "";
    @JsonProperty("poids")
    @DatabaseField
    protected double poids = 0;
    @JsonProperty("supprimer")
    @DatabaseField
    protected boolean isSupprimer;
    @JsonProperty("dateSynch")
    @DatabaseField
    protected long dateSynchro;
    @JsonProperty("idDomaine")
    @DatabaseField
    protected long idDomaine;
    @JsonProperty("libelleDomaine")
    @DatabaseField
    protected String libelleDomaine;
    @JsonProperty("codeDomaine")
    @DatabaseField
    protected String codeDomaine;

    public Packet() {
    }
}
