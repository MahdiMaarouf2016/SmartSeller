package symatique.smartseller.modules.Factures;

import android.content.Context;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.Window;
import android.widget.Spinner;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.services.SQLiteService.DataBaseManager;

public class DialogChequePayement extends AppCompatDialog {
    @BindView(R.id.spinner_cheque_societe)
     Spinner spinnerChequeSociete;
    @BindView(R.id.txt_cheque_restepaye)
     AppCompatTextView txtChequeRestepaye;
    @BindView(R.id.txtedt_cheque_montant)
     AppCompatEditText txtedtChequeMontant;
    @BindView(R.id.txt_cheque_numero)
     AppCompatEditText txtChequeNumero;
    @BindView(R.id.spinner_cheque_banque)
     Spinner spinnerChequeBanque;
    @BindView(R.id.edttxt_cheque_date)
     AppCompatEditText edttxtChequeDate;
    @BindView(R.id.txtedt_cheque_ville)
     AppCompatEditText txtedtChequeVille;
    @BindView(R.id.btn_cheque_annuler)
     AppCompatButton btnChequeAnnuler;
    @BindView(R.id.btn_cheque_confirmer)
     AppCompatButton btnChequeConfirmer;

    public DialogChequePayement(Context context) {
        super(context);
    }

    void setUpView() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.layout_cheque_dialig);
        ButterKnife.bind(this);
    }

    public void setupBanquesSpinner() {
        try {
            DataBaseManager.getInstance().getHelper().getBanques();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setUpSocietesSpinner(){
        try {
            DataBaseManager.getInstance().getHelper().getClients();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setUpDelegates(){
        btnChequeAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnChequeConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }
}
