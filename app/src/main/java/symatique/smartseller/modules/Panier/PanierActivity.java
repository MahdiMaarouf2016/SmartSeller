package symatique.smartseller.modules.Panier;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import symatique.smartseller.R;
import symatique.smartseller.data.Commandes.Commande;
import symatique.smartseller.data.Commandes.EtatCommande;
import symatique.smartseller.data.Commandes.LigneCommande;
import symatique.smartseller.modules.Authentification.AuthentificationActivity;
import symatique.smartseller.modules.Produits.ProduitsActivity;
import symatique.smartseller.modules.Synchronisation.SynchronisationActivity;
import symatique.smartseller.services.RetrofitService.ApiService;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;
import symatique.smartseller.utils.AdapterDelegates;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PanierActivity extends AppCompatActivity {

    @BindView(R.id.rec_panier_listarticles)
    RecyclerView recPanierListarticles;
    @BindView(R.id.txt_panier_labeltotalcommande)
    AppCompatTextView txtPanierLabeltotalcommande;
    @BindView(R.id.txt_panier_totalcommandes)
    AppCompatTextView txtPanierTotalcommandes;
    @BindView(R.id.txt_panier_quantitearticles)
    AppCompatTextView txtPanierQuantitearticles;
    @BindView(R.id.txt_panier_labelquantite)
    AppCompatTextView txtPanierLabelquantite;
    @BindView(R.id.btn_panier_commander)
    AppCompatButton btnPanierCommander;

    private static PanierAdapter panierAdapter = null;

    public static PanierAdapter getPanierAdapter() {
        if (panierAdapter == null) panierAdapter = new PanierAdapter();
        return panierAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        ButterKnife.bind(this);
        setupToolBar();
        setUpPaniers();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ProduitsActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_panier_commander)
    public void btnPanierCommanderOnClick() {
        List<PanierAdapter.PanierPacket> panierPackets = getPanierAdapter().getPanierElements();

        if (!panierPackets.isEmpty()) {

            List<Commande> commandes = new ArrayList<>();

            if (AuthentificationActivity.authenticationResponse.isMultiDomaine()) {


                for (PanierAdapter.PanierPacket panierPacket : panierPackets) {
                    Commande preparecommande = null;
                    // + CHECK IF THE COMMANDE WITH THE SAME CODE DOMAINE EXISTS ALERDY
                    for (Commande preparedCommande : commandes) {
                        if (preparedCommande.getIdDomaine() == panierPacket.getArticle().getIddomaine()) {
                            preparecommande = preparedCommande;
                            break;
                        }
                    }
                    // - CHECK IF THE COMMANDE WITH THE SAME CODE DOMAINE EXISTS ALERDY
                    // + IF THE LAST CHECK IS TRUE
                    if (preparecommande == null) {
                        // + PREPARING THE NEW COMMANDE AND ADD IT TO THE LIST COMMANDES
                        preparecommande = new Commande();
                        preparecommande.setCodeClient(AuthentificationActivity.authenticationResponse.getCode());
                        preparecommande.setCodeEntreprise(AuthentificationActivity.authenticationResponse.getCodeEntreprise());
                        preparecommande.setDateSynch(0);
                        preparecommande.setDateCommande(new Date().getTime());
                        preparecommande.setId(String.valueOf(AuthentificationActivity.authenticationResponse.getIdEntreprise() + new Date().getTime()));
                        preparecommande.setLibelleEtatCommande("PAS ENCORE ENVOYER AU SERVEUR");
                        preparecommande.setSuppCmd(false);
                        preparecommande.setNumero(preparecommande.getId());
                        preparecommande.setIdEntreprise(AuthentificationActivity.authenticationResponse.getIdEntreprise());
                        preparecommande.setLibelleEntreprise(AuthentificationActivity.authenticationResponse.getLibelleEntreprise());
                        preparecommande.setCodeEntreprise(AuthentificationActivity.authenticationResponse.getCodeEntreprise());
                        commandes.add(preparecommande);
                        // + PREPARING THE NEW COMMANDE AND ADD IT TO THE LIST COMMANDES
                    }
                    // - IF THE LAST CHECK IS TRUE
                    // + PREPARRE THE NEW LIGNE COMMANDE FOR THE PREPARING COMMANDE
                    LigneCommande ligneCommande = new LigneCommande(panierPacket.getArticle());

                    ligneCommande.setCodeEntreprise(preparecommande.getCodeEntreprise());
                    ligneCommande.setCodeDomaine(preparecommande.getCodeDomaine());
                    ligneCommande.setDateAchat(preparecommande.getDateCommande());
                    ligneCommande.setQteCommande(panierPacket.getQuantite());
                    ligneCommande.setIdcommande(preparecommande.getId());
                    ligneCommande.setPrixTotal(BigDecimal.valueOf(panierAdapter.getTotalCommande()));
                    // - PREPARRE THE NEW LIGNE COMMANDE FOR THE PREPARING COMMANDE
                    preparecommande.ajouterLigneCommande(ligneCommande);
                }

            } else {

                // + PREPARING THE NEW COMMANDE AND ADD IT TO THE LIST COMMANDES
                Commande preparecommande = new Commande();
                preparecommande.setCodeClient(AuthentificationActivity.authenticationResponse.getCode());
                preparecommande.setCodeEntreprise(AuthentificationActivity.authenticationResponse.getCodeEntreprise());
                preparecommande.setDateSynch(0);
                preparecommande.setDateCommande(new Date().getTime());
                preparecommande.setId(String.valueOf(AuthentificationActivity.authenticationResponse.getIdEntreprise() + new Date().getTime()));
                preparecommande.setLibelleEtatCommande("PAS ENCORE ENVOYER AU SERVEUR");
                preparecommande.setSuppCmd(false);
                preparecommande.setNumero(preparecommande.getId());
                preparecommande.setIdEntreprise(AuthentificationActivity.authenticationResponse.getIdEntreprise());
                preparecommande.setLibelleEntreprise(AuthentificationActivity.authenticationResponse.getLibelleEntreprise());
                preparecommande.setCodeEntreprise(AuthentificationActivity.authenticationResponse.getCodeEntreprise());
                commandes.add(preparecommande);
                // - PREPARING THE NEW COMMANDE AND ADD IT TO THE LIST COMMANDES

                // + *** SETUP DETAILS COMMANDE
                List<LigneCommande> ligneCommandes = new ArrayList<>();
                for (PanierAdapter.PanierPacket panierPacket : getPanierAdapter().getPanierElements()) {

                    LigneCommande ligneCommande = new LigneCommande(panierPacket.getArticle());

                    ligneCommande.setCodeEntreprise(preparecommande.getCodeEntreprise());
                    ligneCommande.setCodeDomaine(preparecommande.getCodeDomaine());
                    ligneCommande.setDateAchat(preparecommande.getDateCommande());
                    ligneCommande.setQteCommande(panierPacket.getQuantite());
                    ligneCommande.setIdcommande(preparecommande.getId());
                    ligneCommande.setPrixTotal(BigDecimal.valueOf(panierAdapter.getTotalCommande()));

                    ligneCommandes.add(ligneCommande);
                }
                // - *** SETUP DETAILS COMMANDE
                preparecommande.setDetailCommandes(ligneCommandes);
            }


            synchronisyerCommandes(commandes);

            getPanierAdapter().setPanierElements(new ArrayList<>());
        } else Toast.makeText(this, "Panier est vide ! ,Charger votre panier pour commander", Toast.LENGTH_LONG).show();

    }

    public void synchronisyerCommandes(List<Commande> commandes) {

        DatabaseHelper database = DataBaseManager.getInstance(this).getHelper();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        if (!commandes.isEmpty()) {
            ApiService.getApiService().ajouterCommandes(commandes).enqueue(new Callback<List<Commande>>() {
                @Override
                public void onResponse(Call<List<Commande>> call, Response<List<Commande>> response) {
                    if (response.isSuccessful()) {
                        try {
                            EtatCommande etatCommande = database.getEtatCommandes().queryBuilder().where().eq("rang", 0).queryForFirst();
                            for (Commande commande : commandes) {
                                commande.setEtatCommande(etatCommande);
                            }
                            database.getCommandes().create(commandes);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            database.getCommandes().create(commandes);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        alertDialog.setTitle("Synchronisation Commandes");
                        alertDialog.setMessage("Vos Commandes n'ont synchronisé , ils ont sauvgardés localement");

                        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        alertDialog.show();
                    }
                }

                @Override
                public void onFailure(Call<List<Commande>> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setUpPaniers() {

        getPanierAdapter().setAdapterDelegates(new AdapterDelegates() {
            @Override
            public void OnPanierPacketInserted(Object object) {
                txtPanierTotalcommandes.setText(String.valueOf(getPanierAdapter().getTotalCommande()) + " TD");
                txtPanierQuantitearticles.setText(String.valueOf(getPanierAdapter().getTotalQuantite()));

            }

            @Override
            public void OnPanierPacketDeleted(Object object) {
                txtPanierTotalcommandes.setText(String.valueOf(getPanierAdapter().getTotalCommande()) + " TD");
                txtPanierQuantitearticles.setText(String.valueOf(getPanierAdapter().getTotalQuantite()));

            }

            @Override
            public void OnPanierPacketUpdated(Object object) {
                txtPanierTotalcommandes.setText(String.valueOf(getPanierAdapter().getTotalCommande()) + " TD");
                txtPanierQuantitearticles.setText(String.valueOf(getPanierAdapter().getTotalQuantite()));
                Log.v("OnPanierPacketUpdated", String.valueOf(getPanierAdapter().getTotalCommande()) + "|" + String.valueOf(getPanierAdapter().getTotalQuantite()));

            }

            @Override
            public void OnInitializedAdapter(List objects) {
                txtPanierTotalcommandes.setText(String.valueOf(getPanierAdapter().getTotalCommande()) + " TD");
                txtPanierQuantitearticles.setText(String.valueOf(getPanierAdapter().getTotalQuantite()));

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recPanierListarticles.setLayoutManager(layoutManager);
        recPanierListarticles.setItemAnimator(new DefaultItemAnimator());
        recPanierListarticles.setAdapter(getPanierAdapter());

        txtPanierTotalcommandes.setText(String.valueOf(getPanierAdapter().getTotalCommande()) + " TD");
        txtPanierQuantitearticles.setText(String.valueOf(getPanierAdapter().getTotalQuantite()));

    }
}
