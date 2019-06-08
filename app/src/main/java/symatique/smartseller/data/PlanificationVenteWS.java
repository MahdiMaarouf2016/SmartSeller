package symatique.smartseller.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;

public class PlanificationVenteWS {
    @JsonProperty("id")
    @DatabaseField(id = true)
    private Long id;
    @JsonProperty("frequence")
    @DatabaseField
    private int frequence;
    @JsonProperty("lundi")
    @DatabaseField
    private boolean lundi;
    @JsonProperty("mardi")
    @DatabaseField
    private boolean mardi;
    @JsonProperty("mercredi")
    @DatabaseField
    private boolean mercredi;
    @JsonProperty("jeudi")
    @DatabaseField
    private boolean jeudi;
    @JsonProperty("vendredi")
    @DatabaseField
    private boolean vendredi;
    @JsonProperty("samedi")
    @DatabaseField
    private boolean samedi;
    @JsonProperty("dimanche")
    @DatabaseField
    private boolean dimanche;

    public PlanificationVenteWS() {

    }

    public Long getId() {
        return id;
    }

    public int getFrequence() {
        return frequence;
    }

    public boolean isLundi() {
        return lundi;
    }

    public boolean isMardi() {
        return mardi;
    }

    public boolean isMercredi() {
        return mercredi;
    }

    public boolean isJeudi() {
        return jeudi;
    }

    public boolean isVendredi() {
        return vendredi;
    }

    public boolean isSamedi() {
        return samedi;
    }

    public boolean isDimanche() {
        return dimanche;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public void setLundi(boolean lundi) {
        this.lundi = lundi;
    }

    public void setMardi(boolean mardi) {
        this.mardi = mardi;
    }

    public void setMercredi(boolean mercredi) {
        this.mercredi = mercredi;
    }

    public void setJeudi(boolean jeudi) {
        this.jeudi = jeudi;
    }

    public void setVendredi(boolean vendredi) {
        this.vendredi = vendredi;
    }

    public void setSamedi(boolean samedi) {
        this.samedi = samedi;
    }

    public void setDimanche(boolean dimanche) {
        this.dimanche = dimanche;
    }
}
