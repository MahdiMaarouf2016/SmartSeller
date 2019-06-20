package symatique.smartseller.modules.Vente;

import android.accounts.AuthenticatorException;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import symatique.smartseller.R;
import symatique.smartseller.data.Factures.Facture;
import symatique.smartseller.data.Factures.LigneFacture;
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.modules.Authentification.AuthentificationActivity;
import symatique.smartseller.modules.Factures.FacturerActivity;
import symatique.smartseller.modules.Panier.PanierAdapter;
import symatique.smartseller.modules.Synchronisation.SynchronisationActivity;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;
import symatique.smartseller.utils.AdapterDelegates;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PanierClientActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.abl_ajouter_client) AppBarLayout ablAjouterClient;
    @BindView(R.id.btn_panierclient_scan) AppCompatButton btnPanierclientScan;
    @BindView(R.id.btn_panierclient_code) AppCompatButton btnPanierclientCode;
    @BindView(R.id.txt_panierclient_clientlabel) AppCompatTextView txtPanierclientClientlabel;
    @BindView(R.id.rec_panierclient_ventes) RecyclerView recPanierclientVentes;
    @BindView(R.id.txt_panierclient_montanttotal) AppCompatTextView txtPanierclientMontanttotal;
    @BindView(R.id.txt_panierclient_nbrarticles) AppCompatTextView txtPanierclientNbrarticles;
    @BindView(R.id.btn_panierclient_annuler) AppCompatButton btnPanierclientAnnuler;
    @BindView(R.id.btn_panierclient_facturer) AppCompatButton btnPanierclientFacturer;

    private Client clientTarget = null;
    private IntentIntegrator integrator;
    private List<Packet> packets;
    private static PanierClientAdapter panierClientAdapter = null;
    public static final String KEY_EXTRA_CLIENT = "CLIENT";

    public static PanierClientAdapter getPanierClientAdapter() {
        if (panierClientAdapter == null) panierClientAdapter = new PanierClientAdapter();
        return panierClientAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panierclient);
        ButterKnife.bind(this);
        setupToolBar();
        setUpWorkingClient();
        setUpIntentIntegrator();
        setUpListPackets();
        setUpPanieClient();
    }

    @Override
    public void onBackPressed() {
        panierClientAdapter = null;
        super.onBackPressed();
    }

    private void setUpListPackets() {
        packets = new ArrayList<>();
        try {
            DatabaseHelper database = DataBaseManager.getInstance(this).getHelper();
            packets = database.getPacketsStock().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setUpIntentIntegrator() {
        integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scan code article");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
    }

    @OnClick(R.id.btn_panierclient_code)
    public void btnPanierclientCodeOnClick() {
        if (!packets.isEmpty()) {
            Intent intent = new Intent(this, CodesActivity.class);
            intent.putExtra(CodesActivity.KEY_EXTRA_CLIENT, clientTarget);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Vous n'avez aucun article en votre stock , Merci d'impoter votre stocks et bon des livraison", Toast.LENGTH_LONG).show();
            Intent synchroIntent = new Intent(this, SynchronisationActivity.class);
            startActivity(synchroIntent);
        }

    }

    @OnClick(R.id.btn_panierclient_scan)
    public void btnPanierClientScanOnClick() {

        if (!packets.isEmpty()) {
            integrator.initiateScan();
        } else {
            Toast.makeText(this, "Vous n'avez aucun article en votre stock , Merci d'impoter votre stocks et bon des livraison", Toast.LENGTH_LONG).show();
            Intent synchroIntent = new Intent(this, SynchronisationActivity.class);
            startActivity(synchroIntent);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Sacn code a bare a ete annulé", Toast.LENGTH_LONG).show();
            } else {
                String scannedCodeBarre = result.getContents();
                boolean found = false;
                for (Packet packet : packets) {
                    if (packet.getCodeBarre() == scannedCodeBarre) {
                        DialogPrixQuantiteLivrison dialogPrixQuantiteLivrison = new DialogPrixQuantiteLivrison(this, packet) {
                            @Override
                            public void OnAccepted() {
                                PanierClientActivity.getPanierClientAdapter().ajouterPacket(packet);
                                alertDialog.dismiss();
                            }

                            @Override
                            public void OnRejected() {

                            }
                        };
                        dialogPrixQuantiteLivrison.show();
                        break;
                    }
                }

                if (!found) Toast.makeText(this, "Ce code n'existe pas dans votre stock", Toast.LENGTH_LONG).show();

            }
        }
    }

    @OnClick(R.id.btn_panierclient_facturer)
    public void btnPanierclientFacturerOnClick() {

        if (!panierClientAdapter.getPackets().isEmpty()) {
            List<Facture> factures = new ArrayList<>();

            if (!AuthentificationActivity.authenticationResponse.isMultiDomaine()) {
                Facture preparefacture = null;

                for (Packet packet : getPanierClientAdapter().getPackets()) {


                    for (Facture preparedfacture : factures) {
                        if (preparedfacture.getIdDomaine() == packet.getIdDomaine()) {
                            preparefacture = preparedfacture;
                            break;
                        }
                    }

                    if (preparefacture == null) {

                        preparefacture = new Facture();

                        preparefacture.setAvImpot(false);
                        preparefacture.setCodeClient(clientTarget.getCode());
                        preparefacture.setIdClient(clientTarget.getId());
                        preparefacture.setLibelleLivreur(AuthentificationActivity.authenticationResponse.getPrenom() + " " + AuthentificationActivity.authenticationResponse.getNom());
                        preparefacture.setCodeEntreprise(AuthentificationActivity.authenticationResponse.getCodeEntreprise());
                        preparefacture.setId(new Date().getTime() + AuthentificationActivity.authenticationResponse.getIdLivreur());
                        preparefacture.setCodeCommercial(AuthentificationActivity.authenticationResponse.getCodeCommercial());
                        preparefacture.setDateCreation(new Date().getTime());
                        preparefacture.setIdLivreur(AuthentificationActivity.authenticationResponse.getIdLivreur());
                        preparefacture.setLibelleEntreprise(AuthentificationActivity.authenticationResponse.getLibelleEntreprise());

                        factures.add(preparefacture);
                    }

                    LigneFacture ligneFacture = new LigneFacture();
                    ligneFacture.setCodeArticle(packet.getCodeArticle());
                    ligneFacture.setId(new Date().getTime() + AuthentificationActivity.authenticationResponse.getIdLivreur());
                    ligneFacture.setIdArticle(ligneFacture.getIdArticle());
                    ligneFacture.setLibelleArticle(packet.getLibelleArticle());
                    //ligneFacture.setPrixUnitaireHT(packet.getPrixUnitaireHT());
                    ligneFacture.setQuantite(packet.getQuantite());
                    ligneFacture.setTvaArticle(packet.getTva());
                    //ligneFacture.setValeurHT(packet.getPrixUnitaireHTLie());

                    preparefacture.getListLigneFacture().add(ligneFacture);
                }
            } else {

                Facture facture = new Facture();
                facture.setAvImpot(false);
                facture.setCodeClient(clientTarget.getCode());
                facture.setIdClient(clientTarget.getId());
                facture.setLibelleLivreur(AuthentificationActivity.authenticationResponse.getPrenom() + " " + AuthentificationActivity.authenticationResponse.getNom());
                facture.setCodeEntreprise(AuthentificationActivity.authenticationResponse.getCodeEntreprise());
                facture.setId(new Date().getTime() + AuthentificationActivity.authenticationResponse.getIdLivreur());
                facture.setCodeCommercial(AuthentificationActivity.authenticationResponse.getCodeCommercial());
                facture.setDateCreation(new Date().getTime());
                facture.setIdLivreur(AuthentificationActivity.authenticationResponse.getIdLivreur());
                facture.setLibelleEntreprise(AuthentificationActivity.authenticationResponse.getLibelleEntreprise());
                List<LigneFacture> ligneFactures = new ArrayList<>();
                for (Packet packet : getPanierClientAdapter().getPackets()) {
                    LigneFacture ligneFacture = new LigneFacture();
                    ligneFacture.setCodeArticle(packet.getCodeArticle());
                    ligneFacture.setId(new Date().getTime() + AuthentificationActivity.authenticationResponse.getIdLivreur());
                    ligneFacture.setIdArticle(ligneFacture.getIdArticle());
                    ligneFacture.setLibelleArticle(packet.getLibelleArticle());
                    //ligneFacture.setPrixUnitaireHT(packet.getPrixUnitaireHT());
                    ligneFacture.setQuantite(packet.getQuantite());
                    ligneFacture.setTvaArticle(packet.getTva());
                    //ligneFacture.setValeurHT(packet.getPrixUnitaireHTLie());
                    ligneFactures.add(ligneFacture);
                }

                facture.setListLigneFacture((ArrayList<LigneFacture>) ligneFactures);
                facture.setListPacketsVendus((ArrayList<Packet>) getPanierClientAdapter().getPackets());
                factures.add(facture);

            }

            for (Facture facture : factures) {
                double totalHT = 0, TVA = 0, TTC = 0;
                for (LigneFacture ligneFacture : facture.getListLigneFacture()) {
                    totalHT += ligneFacture.getPrixUnitaireHT().doubleValue() * ligneFacture.getQuantite();
                    TVA += ligneFacture.getTvaArticle();
                    TTC += (ligneFacture.getTvaArticle() * (ligneFacture.getPrixUnitaireHT().doubleValue() * ligneFacture.getQuantite())) / 100 + ligneFacture.getPrixUnitaireHT().doubleValue() * ligneFacture.getQuantite();
                }
                facture.setMontantTTC(BigDecimal.valueOf(TTC));
                facture.setMontantHT(BigDecimal.valueOf(totalHT));
                facture.setMontantTVA(BigDecimal.valueOf(TVA));
            }

            FacturerActivity.factureListTarget = factures;
            Intent intent = new Intent(this, FacturerActivity.class);
            intent.putExtra(FacturerActivity.KEY_CLIENT_EXTRA, clientTarget);
            startActivity(intent);
        } else
            Toast.makeText(this, "Aucune commande client ! , Remplir la apnier client svp ", Toast.LENGTH_LONG).show();
    }

    private void setupToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @OnClick(R.id.btn_panierclient_annuler)
    public void btnPanierclientAnnulerOnClick() {
        onBackPressed();
    }

    private void setUpWorkingClient() {

        clientTarget = (Client) getIntent().getExtras().get(KEY_EXTRA_CLIENT);
        txtPanierclientClientlabel.setText(clientTarget.getLibelle());
    }

    public void setUpPanieClient() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recPanierclientVentes.setLayoutManager(layoutManager);
        recPanierclientVentes.setItemAnimator(new DefaultItemAnimator());

        recPanierclientVentes.setAdapter(getPanierClientAdapter());
        getPanierClientAdapter().setAdapterDelegates(new AdapterDelegates() {
            @Override
            public void OnPanierPacketInserted(Object object) {
                txtPanierclientNbrarticles.setText(String.valueOf(getPanierClientAdapter().getItemCount()));
                double montantTotal = 0;
                for (Packet packet : getPanierClientAdapter().getPackets()) {
                    /// montantTotal += packet.getQuantite() * packet.getPrixUnitaireHT().doubleValue();
                }
                txtPanierclientMontanttotal.setText(String.valueOf(PanierAdapter.round(montantTotal, 3)));
                recPanierclientVentes.setAdapter(getPanierClientAdapter());
            }

            @Override
            public void OnPanierPacketDeleted(Object object) {

                double montantTotal = 0;
                for (Packet packet : getPanierClientAdapter().getPackets()) {
                    // montantTotal += packet.getQuantite() * packet.getPrixUnitaireHT().doubleValue();
                }
                txtPanierclientMontanttotal.setText(String.valueOf(PanierAdapter.round(montantTotal, 3)));
                txtPanierclientNbrarticles.setText(getPanierClientAdapter().getPackets().size());
                recPanierclientVentes.setAdapter(getPanierClientAdapter());
            }

            @Override
            public void OnPanierPacketUpdated(Object object) {

            }

            @Override
            public void OnInitializedAdapter(List objects) {
                txtPanierclientNbrarticles.setText(getPanierClientAdapter().getItemCount());
                double montantTotal = 0;
                for (Packet packet : getPanierClientAdapter().getPackets()) {
                    //montantTotal += packet.getQuantite() * packet.getPrixUnitaireHT().doubleValue();
                }
                txtPanierclientMontanttotal.setText(String.valueOf(PanierAdapter.round(montantTotal, 3)));
                recPanierclientVentes.setAdapter(getPanierClientAdapter());
            }
        });
    }


}
