package symatique.smartseller.modules.Factures;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.data.Encaissements.Banque;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;

public class DialogChequePayement extends AlertDialog.Builder {
    @BindView(R.id.spinner_cheque_societe) Spinner spinnerChequeSociete;
    @BindView(R.id.txt_cheque_restepaye) AppCompatTextView txtChequeRestepaye;
    @BindView(R.id.txtedt_cheque_montant) AppCompatEditText txtedtChequeMontant;
    @BindView(R.id.txt_cheque_numero) AppCompatEditText txtChequeNumero;
    @BindView(R.id.spinner_cheque_banque) Spinner spinnerChequeBanque;
    @BindView(R.id.edttxt_cheque_date) AppCompatEditText edttxtChequeDate;
    @BindView(R.id.txtedt_cheque_ville) AppCompatEditText txtedtChequeVille;
    @BindView(R.id.btn_cheque_annuler) AppCompatButton btnChequeAnnuler;
    @BindView(R.id.btn_cheque_confirmer) AppCompatButton btnChequeConfirmer;
    private AlertDialog alertDialog = null;

    public DialogChequePayement(Context context) {
        super(context);
    }

    @Override
    public AlertDialog show() {
        setView(R.layout.dialog_payement_cheque);
        alertDialog = super.show();
        ButterKnife.bind(this, alertDialog);
        setupBanques();
        setUpClients();
        return alertDialog;
    }

    @OnClick(R.id.btn_cheque_annuler)
    public void btnChequeAnnulerOnClick() {

    }

    @OnClick(R.id.btn_cheque_confirmer)
    public void btnChequeConfirmerOnClick() {

    }

    public List<Banque> getListBanques(){
        List<Banque> banques = new ArrayList<>();
        try{
            banques = DataBaseManager.getInstance(getContext()).getHelper().getBanques().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banques;
    }

    public void setupBanques() {
        List<String> banqueLibels = new ArrayList<>();
        List<Banque> banques = getListBanques();
        if (!banques.isEmpty()) {
            for (Banque banque : banques) banqueLibels.add(banque.getLibelle());
        }else{
            Toast.makeText(this.getContext(),"Aucune banque trouvé , Merci de sychronisyer",Toast.LENGTH_LONG).show();
            //alertDialog.onBackPressed();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, banqueLibels);//setting the country_array to spinner
        spinnerChequeBanque.setAdapter(adapter);

    }

    public List<Client> getListClients(){
        List<Client> clients = new ArrayList<>();
        try{
            DatabaseHelper database =  DataBaseManager.getInstance(this.getContext()).getHelper();
            clients = database.getClients().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void setUpClients(){
        List<String> clientLabes = new ArrayList<>();
        List<Client> clients = getListClients();
        if(!clientLabes.isEmpty()){
            for(Client client:clients)
                clientLabes.add(client.getLibelle());
        }else{
            Toast.makeText(this.getContext(),"Aucune banque trouvé , Merci de sychronisyer",Toast.LENGTH_LONG).show();
            alertDialog.onBackPressed();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, (ArrayList)clientLabes);//setting the country_array to spinner
        spinnerChequeSociete.setAdapter(adapter);
    }

}
