package symatique.smartseller.data.Stocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.ArrayList;

/***************************************************************************
 *
 *                               RETROFIT SERVICE ONLY
 *
 ***************************************************************************/

public class BonDeSortiesResponse implements Serializable {

    @JsonProperty("msgErreur")
    private  String msgErreur;
    @JsonProperty("listBonSortiePaquetWS")
    private ArrayList<BonDeSortie> listBonSortiePaquetWS;
    @JsonProperty("idEntreprise")
    private long idEntreprise;

    public BonDeSortiesResponse() {

    }

    public BonDeSortiesResponse(String msgErreur, ArrayList<BonDeSortie> listBonSortiePaquetWS, long idEntreprise) {
        this.msgErreur = msgErreur;
        this.listBonSortiePaquetWS = listBonSortiePaquetWS;
        this.idEntreprise = idEntreprise;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public void setMsgErreur(String msgErreur) {
        this.msgErreur = msgErreur;
    }

    public void setListBonSortiePaquetWS(ArrayList<BonDeSortie> listBonSortiePaquetWS) {
        this.listBonSortiePaquetWS = listBonSortiePaquetWS;
    }


    public String getMsgErreur() {
        return msgErreur;
    }

    public ArrayList<BonDeSortie> getListBonSortiePaquetWS() {
        return listBonSortiePaquetWS;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }
}
