package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@DatabaseTable
public class TypeEncaissementVente implements Serializable {
    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;

    @JsonProperty("banque")
    @DatabaseField
    private boolean banque;
    @JsonProperty("dateCheque")
    @DatabaseField
    private boolean dateCheque;
    @JsonProperty("dateSynchro")
    @DatabaseField
    private Long dateSynchro;
    @JsonProperty("deductionPourcentageTicket")
    @DatabaseField
    private boolean deductionPourcentageTicket;
    @JsonProperty("idEntreprise")
    @DatabaseField
    private long idEntreprise;
    @JsonProperty("libelle")
    @DatabaseField
    private String libelle;
    @JsonProperty("libelleTicket")
    @DatabaseField
    private boolean libelleTicket;
    @JsonProperty("montant")
    @DatabaseField
    private boolean montant;
    @JsonProperty("nbrTicket")
    @DatabaseField
    private boolean nbrTicket;
    @JsonProperty("numCheque")
    @DatabaseField
    private boolean numCheque;
    @JsonProperty("smartOrder")
    @DatabaseField
    private boolean smartOrder;
    @JsonProperty("smartProspect")
    @DatabaseField
    private boolean smartProspect;
    @JsonProperty("smartSales")
    @DatabaseField
    private boolean smartSales;
    @JsonProperty("supprimer")
    @DatabaseField
    private boolean supprimer;
    @JsonProperty("tauxRetenu")
    @DatabaseField
    private boolean tauxRetenu;
    @JsonProperty("valeurUnitaireTicket")
    @DatabaseField
    private boolean valeurUnitaireTicket;
    @JsonProperty("ville")
    @DatabaseField
    private boolean ville;

    public TypeEncaissementVente(){

    }

    public Long getId() {
        return id;
    }

    public boolean isBanque() {
        return banque;
    }

    public boolean isDateCheque() {
        return dateCheque;
    }

    public Long getDateSynchro() {
        return dateSynchro;
    }

    public boolean isDeductionPourcentageTicket() {
        return deductionPourcentageTicket;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public String getLibelle() {
        return libelle;
    }

    public boolean isLibelleTicket() {
        return libelleTicket;
    }

    public boolean isMontant() {
        return montant;
    }

    public boolean isNbrTicket() {
        return nbrTicket;
    }

    public boolean isNumCheque() {
        return numCheque;
    }

    public boolean isSmartOrder() {
        return smartOrder;
    }

    public boolean isSmartProspect() {
        return smartProspect;
    }

    public boolean isSmartSales() {
        return smartSales;
    }

    public boolean isSupprimer() {
        return supprimer;
    }

    public boolean isTauxRetenu() {
        return tauxRetenu;
    }

    public boolean isValeurUnitaireTicket() {
        return valeurUnitaireTicket;
    }

    public boolean isVille() {
        return ville;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBanque(boolean banque) {
        this.banque = banque;
    }

    public void setDateCheque(boolean dateCheque) {
        this.dateCheque = dateCheque;
    }

    public void setDateSynchro(Long dateSynchro) {
        this.dateSynchro = dateSynchro;
    }

    public void setDeductionPourcentageTicket(boolean deductionPourcentageTicket) {
        this.deductionPourcentageTicket = deductionPourcentageTicket;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLibelleTicket(boolean libelleTicket) {
        this.libelleTicket = libelleTicket;
    }

    public void setMontant(boolean montant) {
        this.montant = montant;
    }

    public void setNbrTicket(boolean nbrTicket) {
        this.nbrTicket = nbrTicket;
    }

    public void setNumCheque(boolean numCheque) {
        this.numCheque = numCheque;
    }

    public void setSmartOrder(boolean smartOrder) {
        this.smartOrder = smartOrder;
    }

    public void setSmartProspect(boolean smartProspect) {
        this.smartProspect = smartProspect;
    }

    public void setSmartSales(boolean smartSales) {
        this.smartSales = smartSales;
    }

    public void setSupprimer(boolean supprimer) {
        this.supprimer = supprimer;
    }

    public void setTauxRetenu(boolean tauxRetenu) {
        this.tauxRetenu = tauxRetenu;
    }

    public void setValeurUnitaireTicket(boolean valeurUnitaireTicket) {
        this.valeurUnitaireTicket = valeurUnitaireTicket;
    }

    public void setVille(boolean ville) {
        this.ville = ville;
    }
}
