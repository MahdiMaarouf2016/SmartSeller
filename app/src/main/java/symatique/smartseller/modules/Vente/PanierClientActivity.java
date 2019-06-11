package symatique.smartseller.modules.Vente;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.modules.Panier.PanierAdapter;
import symatique.smartseller.utils.AdapterDelegates;

import java.util.List;

public class PanierClientActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.abl_ajouter_client) AppBarLayout ablAjouterClient;
    @BindView(R.id.textView2) AppCompatTextView textView2;
    @BindView(R.id.btn_panierclient_scan) AppCompatButton btnPanierclientScan;
    @BindView(R.id.btn_panierclient_code) AppCompatButton btnPanierclientCode;
    @BindView(R.id.constraintLayout10) ConstraintLayout constraintLayout10;
    @BindView(R.id.textView9) AppCompatTextView textView9;
    @BindView(R.id.txt_panierclient_clientlabel) AppCompatTextView txtPanierclientClientlabel;
    @BindView(R.id.textView13) AppCompatTextView textView13;
    @BindView(R.id.textView17) AppCompatTextView textView17;
    @BindView(R.id.textView12) TextView textView12;
    @BindView(R.id.linearLayout4) LinearLayout linearLayout4;
    @BindView(R.id.rec_panierclient_ventes) RecyclerView recPanierclientVentes;
    @BindView(R.id.constraintLayout3) ConstraintLayout constraintLayout3;
    @BindView(R.id.guideline16) Guideline guideline16;
    @BindView(R.id.textView18) AppCompatTextView textView18;
    @BindView(R.id.txt_panierclient_montanttotal) AppCompatTextView txtPanierclientMontanttotal;
    @BindView(R.id.textView21) AppCompatTextView textView21;
    @BindView(R.id.txt_panierclient_nbrarticles) AppCompatTextView txtPanierclientNbrarticles;
    @BindView(R.id.guideline17) Guideline guideline17;
    @BindView(R.id.tableLayout) ConstraintLayout tableLayout;
    @BindView(R.id.btn_panierclient_annuler) AppCompatButton btnPanierclientAnnuler;
    @BindView(R.id.btn_panierclient_facturer) AppCompatButton btnPanierclientFacturer;
    @BindView(R.id.linearLayout13) LinearLayout linearLayout13;
    @BindView(R.id.guideline18) Guideline guideline18;
    private Client workingClient = null;

    private static PanierClientAdapter panierClientAdapter = null;
    public static final String KEY_EXTRA_CLIENT = "CLIENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panierclient);
        ButterKnife.bind(this);
        setupToolBar();
        setUpVentes();
        setUpWorkingClient();

    }

    @OnClick(R.id.btn_panierclient_code)
    public void btnPanierclientCodeOnClick(){
        Intent intent = new Intent(this, CodesActivity.class);
        intent.putExtra(CodesActivity.KEY_EXTRA_CLIENT, workingClient);
        startActivity(intent);
    }

    @OnClick(R.id.btn_panierclient_scan)
    public void btnPanierClientScanOnClick(){
        // scan LOOOL
    }

    @OnClick(R.id.btn_panierclient_facturer)
    public void btnPanierclientFacturerOnClick(){

    }

    @OnClick(R.id.btn_panierclient_annuler)
    public void btnPanierclientAnnulerOnClick(){
        onBackPressed();
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setUpWorkingClient() {
        workingClient = (Client) getIntent().getExtras().get(KEY_EXTRA_CLIENT);
        AppCompatTextView textView = findViewById(R.id.txt_panierclient_clientlabel);
        textView.setText(workingClient.getLibelle());

    }


    public void setUpVentes() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recPanierclientVentes.setLayoutManager(layoutManager);
        recPanierclientVentes.setItemAnimator(new DefaultItemAnimator());

        recPanierclientVentes.setAdapter(getPanierClientAdapter());
        getPanierClientAdapter().setAdapterDelegates(new AdapterDelegates() {
            @Override
            public void OnPanierPacketInserted(Object object) {
                txtPanierclientNbrarticles.setText(String.valueOf(getPanierClientAdapter().getPackets().size()));
                double montantTotal = 0;
                for(Packet packet :getPanierClientAdapter().getPackets()){
                    montantTotal += packet.getQuantite() * packet.getPrixUnitaireHT().doubleValue();
                }
                txtPanierclientMontanttotal.setText(String.valueOf(PanierAdapter.round(montantTotal,3)));
            }

            @Override
            public void OnPanierPacketDeleted(Object object) {
                txtPanierclientNbrarticles.setText(getPanierClientAdapter().getPackets().size());
                double montantTotal = 0;
                for(Packet packet :getPanierClientAdapter().getPackets()){
                    montantTotal += packet.getQuantite() * packet.getPrixUnitaireHT().doubleValue();
                }
                txtPanierclientMontanttotal.setText(String.valueOf(PanierAdapter.round(montantTotal,3)));
            }

            @Override
            public void OnPanierPacketUpdated(Object object) {

            }

            @Override
            public void OnInitializedAdapter(List objects) {
                txtPanierclientNbrarticles.setText(getPanierClientAdapter().getPackets().size());
                double montantTotal = 0;
                for(Packet packet :getPanierClientAdapter().getPackets()){
                    montantTotal += packet.getQuantite() * packet.getPrixUnitaireHT().doubleValue();
                }
                txtPanierclientMontanttotal.setText(String.valueOf(PanierAdapter.round(montantTotal,3)));
            }
        });
    }

    public static PanierClientAdapter getPanierClientAdapter(){
        if(panierClientAdapter == null) panierClientAdapter = new PanierClientAdapter();
        return panierClientAdapter;
    }





}
