package symatique.smartseller.modules.Factures;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;

public class PayementFactureActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.abl_ajouter_client) AppBarLayout ablAjouterClient;
    @BindView(R.id.textView9) AppCompatTextView textView9;
    @BindView(R.id.txt_panierclient_clientlabel) AppCompatTextView txtPanierclientClientlabel;
    @BindView(R.id.linearLayout9) LinearLayoutCompat linearLayout9;
    @BindView(R.id.textView13) AppCompatTextView textView13;
    @BindView(R.id.textView17) AppCompatTextView textView17;
    @BindView(R.id.textView12) AppCompatTextView textView12;
    @BindView(R.id.linearLayout4) LinearLayoutCompat linearLayout4;
    @BindView(R.id.rec_payementfactureactivity_ventes) RecyclerView recPayementfactureactivityVentes;
    @BindView(R.id.constraintLayout3) ConstraintLayout constraintLayout3;
    @BindView(R.id.textView37) AppCompatTextView textView37;
    @BindView(R.id.txt_payementfactureactivity_nbr) AppCompatTextView txtPayementfactureactivityNbr;
    @BindView(R.id.lab_payementfactureactivity_totale) AppCompatTextView labPayementfactureactivityTotale;
    @BindView(R.id.txt_payementfactureactivity_totale) AppCompatTextView txtpayementfactureactivitytotale;
    @BindView(R.id.constraintLayout6) ConstraintLayout constraintLayout6;
    @BindView(R.id.btn_payementfactureactivity_cheque) AppCompatButton btnPayementfactureactivityCheque;
    @BindView(R.id.btn_payementfactureactivity_espece) AppCompatButton btnPayementfactureactivityEspece;
    @BindView(R.id.btn_payementfactureactivity_credit) AppCompatButton btnPayementfactureactivityCredit;
    @BindView(R.id.tableLayout3) TableLayout tableLayout3;
    @BindView(R.id.btn_payementfactureactivity_verifier) AppCompatButton btnPayementfactureactivityVerifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payement_facture);
        ButterKnife.bind(this);
        setupToolBar();
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @OnClick(R.id.btn_payementfactureactivity_verifier)
    public void OnClickBtnPayementfactureactivityVerifier(){

    }

}
