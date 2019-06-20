package symatique.smartseller.modules.Factures;

import android.accounts.AuthenticatorException;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;

import android.view.View;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.bases.RetrofitBases;
import symatique.smartseller.data.Encaissements.Encaissement;
import symatique.smartseller.data.Encaissements.TypeEncaissementVente;
import symatique.smartseller.data.Factures.Facture;
import symatique.smartseller.data.Factures.PrefixBL;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.modules.Authentification.AuthentificationActivity;
import symatique.smartseller.services.SQLiteService.DataBaseManager;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacturerActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.abl_creatvte)
    AppBarLayout ablCreatvte;
    @BindView(R.id.rec_facturesactivity_listpayementclient)
    RecyclerView recFacturesactivityListpayementclient;
    public static final String KEY_CLIENT_EXTRA = "Client";
    public static final String KEY_LISTFACTURES_EXTRA = "FACTURES";
    public static List<Facture> factureListTarget = null;
    @BindView(R.id.btn_factureactivity_chequepayement)
    AppCompatButton btnFactureactivityChequepayement;
    @BindView(R.id.btn_factureactivity_creditpayement)
    AppCompatButton btnFactureactivityCreditpayement;
    @BindView(R.id.btn_factureactivity_especepayement)
    AppCompatButton btnFactureactivityEspecepayement;
    @BindView(R.id.btn_factureactivity_bl)
    AppCompatButton btnFactureactivityBl;
    @BindView(R.id.btn_factureactivity_facture)
    AppCompatButton btnFactureractivityFacture;
    @BindView(R.id.txt_factureractivity_codeclient)
    AppCompatTextView txtFactureractivityCodeclient;
    @BindView(R.id.txt_factureractivity_libclient)
    AppCompatTextView txtFactureractivityLibclient;
    @BindView(R.id.lyc_factureactivity_finalaction)
    LinearLayoutCompat lycFactureactivityFinalaction;
    @BindView(R.id.txt_factureractivity_nbrfactures)
    AppCompatTextView txtFactureractivityNbrFactures;
    @BindView(R.id.txt_factureractivity_totalefactures)
    AppCompatTextView txtFactureractivityTotaleFactures;
    @BindView(R.id.btn_factureactivity_verifier)
    AppCompatButton btnFactureactivityVerifier;
    private Client clientTarget = null;
    private FacturesAdapter facturesAdapter = null;

    public static double getTotalTouteCompte(List<Facture> factures) {
        double total = 0;
        for (Facture facture : factures) total += facture.getMontantTTC().doubleValue();
        return total;
    }

    public static double getTotalTva(List<Facture> factures) {
        double tva = 0;
        for (Facture facture : factures) tva += facture.getMontantTVA().doubleValue();
        return tva;
    }

    public static double getTotalHorsTaxe(List<Facture> factures) {
        double tht = 0;
        for (Facture facture : factures) tht += facture.getMontantHT().doubleValue();
        return tht;
    }

    private void setupToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturer);
        ButterKnife.bind(this);
        setupToolBar();
        setUpTargets();
        setUpFactures();
        btnFactureactivityVerifier.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onBackPressed() {
        factureListTarget = null;
        super.onBackPressed();
    }

    private void setUpTargets() {
        clientTarget = (Client) getIntent().getExtras().get(KEY_CLIENT_EXTRA);
        txtFactureractivityCodeclient.setText(clientTarget.getCode());
        txtFactureractivityLibclient.setText(clientTarget.getLibelle());
    }

    public void setUpFactures() {

        facturesAdapter = new FacturesAdapter(factureListTarget);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recFacturesactivityListpayementclient.setLayoutManager(layoutManager);
        recFacturesactivityListpayementclient.setItemAnimator(new DefaultItemAnimator());

        recFacturesactivityListpayementclient.setAdapter(facturesAdapter);

        txtFactureractivityNbrFactures.setText("1");//factureListTarget.size()

        txtFactureractivityTotaleFactures.setText(getTotalTouteCompte(factureListTarget) + " TD");
    }


    @OnClick(R.id.btn_factureactivity_verifier)
    public void btnFactureactivityVerifierOnClick() {


    }

    @OnClick(R.id.btn_factureactivity_chequepayement)
    public void setBtnFactureactivityChequepayementOnClick() {

        if (facturesAdapter.getSelectedFacture() == null)
            Toast.makeText(this, "Selectiooner une facture a payé ! ", Toast.LENGTH_LONG).show();
        else {
            affichierDialogChequePayement();
        }
    }

    @OnClick(R.id.btn_factureactivity_creditpayement)
    public void setBtnFactureactivityCreditpayementOnClick() {
        if (facturesAdapter.getSelectedFacture() == null)
            Toast.makeText(this, "Selectiooner une facture a payé ! ", Toast.LENGTH_LONG).show();
        else {

            Facture facture = facturesAdapter.getSelectedFacture();
            List<Facture> factures = facturesAdapter.getFactures();
            factures.remove(facture);

            Encaissement encaissement = new Encaissement();
            encaissement.setId(new Date().getTime() + AuthentificationActivity.authenticationResponse.getIdLivreur());
            encaissement.setLibelle("Credit");
            encaissement.setValeur(facture.getMontantHT());

            facture.setEncaissement(encaissement);
            factures.add(facture);
            facturesAdapter.setFactures(factures);
            facturesAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Payment credit a ete bien affecte", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btn_factureactivity_especepayement)
    public void setBtnFactureactivityEspecepayementOnClick() {

        if (facturesAdapter.getSelectedFacture() == null)
            Toast.makeText(this, "Selectionner une facture a payé ! ", Toast.LENGTH_LONG).show();
        else {
            Facture facture = facturesAdapter.getSelectedFacture();
            List<Facture> factures = facturesAdapter.getFactures();
            factures.remove(facture);

            Encaissement encaissement = new Encaissement();
            encaissement.setId(new Date().getTime() + AuthentificationActivity.authenticationResponse.getIdLivreur());
            encaissement.setLibelle("Espece");
            encaissement.setValeur(facture.getMontantHT());

            facture.setEncaissement(encaissement);
            factures.add(facture);
            facturesAdapter.setFactures(factures);
            facturesAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Payment espece a ete bien affecte", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btn_factureactivity_facture)
    public void setBtnFacturerFactureOnClick() {
        double tt = 1.2d;

        DialogConfirmFacture dialogConfirmFacture = new DialogConfirmFacture(this, getTotalHorsTaxe(factureListTarget), getTotalTva(factureListTarget), tt, getTotalTouteCompte(factureListTarget)) {
            @Override
            public void OnAccepted() {

                for (Facture facture : factureListTarget) facture.setBonLivraison(false);

                try {
                    DataBaseManager.getInstance(this.getContext()).getHelper().getFactures().create(factureListTarget);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                affichierDialogPrintFacture(this.getContext());

            }

            @Override
            public void OnRejected() {
                onBackPressed();
            }
        };
        dialogConfirmFacture.show();
    }

    @OnClick(R.id.btn_factureactivity_bl)
    public void setBtnFacturerBlOnClick() {

        double tt = 1.2d;

        DialogConfirmFacture dialogConfirmFacture = new DialogConfirmFacture(this, getTotalHorsTaxe(factureListTarget), getTotalTva(factureListTarget), tt, getTotalTouteCompte(factureListTarget)) {
            @Override
            public void OnAccepted() {
                for (Facture facture : factureListTarget) facture.setBonLivraison(true);
                try {
                    DataBaseManager.getInstance(this.getContext()).getHelper().getFactures().create(factureListTarget);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                affichierDialogPrintFacture(this.getContext());

            }

            @Override
            public void OnRejected() {
                onBackPressed();
            }
        };
        dialogConfirmFacture.show();
    }

    private void affichierDialogChequePayement() {
        DialogChequePayement dialogChequePayement = new DialogChequePayement(this);
        dialogChequePayement.show();
    }

    private void affichierDialogPrintFacture(Context context) {
        DialogPrintFacture dialogPrintFacture = new DialogPrintFacture(context) {
            @Override
            public void OnAccepted() {
                onBackPressed();
            }

            @Override
            public void OnRejected() {

            }
        };
        dialogPrintFacture.show();
    }

}
