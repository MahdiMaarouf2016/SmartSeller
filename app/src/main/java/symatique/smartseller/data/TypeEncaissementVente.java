package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
@DatabaseTable
public class TypeEncaissementVente implements Serializable {
    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("montant")
    @DatabaseField
    private boolean montant;
    @JsonProperty("dateCheque")
    @DatabaseField
    private boolean dateCheque;
    @JsonProperty("numCheque")
    @DatabaseField
    private boolean numCheque;
    @JsonProperty("banque")
    @DatabaseField
    private boolean banque;
    @JsonProperty("ville")
    @DatabaseField
    private boolean ville;
    @JsonProperty("libelleTicket")
    @DatabaseField
    private boolean libelleTicket;
    @JsonProperty("valeurUnitaireTicket")
    @DatabaseField
    private boolean valeurUnitaireTicket;
    @JsonProperty("deductionPourcentageTicket")
    @DatabaseField
    private boolean deductionPourcentageTicket;
    @JsonProperty("nbrTicket")
    @DatabaseField
    private boolean nbrTicket;
    @JsonProperty("tauxRetenu")
    @DatabaseField
    private boolean tauxRetenu;
    @JsonProperty("dateSynchro")
    @DatabaseField
    private Long dateSynchro;
    @JsonProperty("supprimer")
    @DatabaseField
    private boolean supprimer;
    @JsonProperty("smartOrder")
    @DatabaseField
    private boolean smartOrder;
    @JsonProperty("smartSales")
    @DatabaseField
    private boolean smartSales;
    @JsonProperty("smartProspect")
    @DatabaseField
    private boolean smartProspect;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;

    @JsonProperty("encaissements")
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Encaissement> encaissements;
    @DatabaseField(foreign = true)
    private Encaissement encaissement;

    public TypeEncaissementVente(){

    }

    public TypeEncaissementVente(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public boolean isMontant() {
        return montant;
    }

    public boolean isDateCheque() {
        return dateCheque;
    }

    public boolean isNumCheque() {
        return numCheque;
    }

    public boolean isBanque() {
        return banque;
    }

    public boolean isVille() {
        return ville;
    }

    public boolean isLibelleTicket() {
        return libelleTicket;
    }

    public boolean isValeurUnitaireTicket() {
        return valeurUnitaireTicket;
    }

    public boolean isDeductionPourcentageTicket() {
        return deductionPourcentageTicket;
    }

    public boolean isNbrTicket() {
        return nbrTicket;
    }

    public boolean isTauxRetenu() {
        return tauxRetenu;
    }

    public Long getDateSynchro() {
        return dateSynchro;
    }

    public boolean isSupprimer() {
        return supprimer;
    }

    public boolean isSmartOrder() {
        return smartOrder;
    }

    public boolean isSmartSales() {
        return smartSales;
    }

    public boolean isSmartProspect() {
        return smartProspect;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public ForeignCollection<Encaissement> getEncaissements() {
        return encaissements;
    }

    public Encaissement getEncaissement() {
        return encaissement;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setMontant(boolean montant) {
        this.montant = montant;
    }

    public void setDateCheque(boolean dateCheque) {
        this.dateCheque = dateCheque;
    }

    public void setNumCheque(boolean numCheque) {
        this.numCheque = numCheque;
    }

    public void setBanque(boolean banque) {
        this.banque = banque;
    }

    public void setVille(boolean ville) {
        this.ville = ville;
    }

    public void setLibelleTicket(boolean libelleTicket) {
        this.libelleTicket = libelleTicket;
    }

    public void setValeurUnitaireTicket(boolean valeurUnitaireTicket) {
        this.valeurUnitaireTicket = valeurUnitaireTicket;
    }

    public void setDeductionPourcentageTicket(boolean deductionPourcentageTicket) {
        this.deductionPourcentageTicket = deductionPourcentageTicket;
    }

    public void setNbrTicket(boolean nbrTicket) {
        this.nbrTicket = nbrTicket;
    }

    public void setTauxRetenu(boolean tauxRetenu) {
        this.tauxRetenu = tauxRetenu;
    }

    public void setDateSynchro(Long dateSynchro) {
        this.dateSynchro = dateSynchro;
    }

    public void setSupprimer(boolean supprimer) {
        this.supprimer = supprimer;
    }

    public void setSmartOrder(boolean smartOrder) {
        this.smartOrder = smartOrder;
    }

    public void setSmartSales(boolean smartSales) {
        this.smartSales = smartSales;
    }

    public void setSmartProspect(boolean smartProspect) {
        this.smartProspect = smartProspect;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setEncaissements(ForeignCollection<Encaissement> encaissements) {
        this.encaissements = encaissements;
    }

    public void setEncaissement(Encaissement encaissement) {
        this.encaissement = encaissement;
    }
}
