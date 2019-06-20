package symatique.smartseller.modules.Synchronisation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.j256.ormlite.field.DatabaseField;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import symatique.smartseller.R;
import symatique.smartseller.data.Articles.Article;
import symatique.smartseller.data.Commandes.EtatCommande;
import symatique.smartseller.data.Factures.Facture;
import symatique.smartseller.data.Stocks.BonDeSortie;
import symatique.smartseller.data.Stocks.BonDeSortiesResponse;
import symatique.smartseller.data.Encaissements.Banque;
import symatique.smartseller.data.Articles.CategorieArticle;
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.data.Commandes.Commande;
import symatique.smartseller.data.Ventes.NatureVente;
import symatique.smartseller.data.Factures.PrefixBL;
import symatique.smartseller.data.Factures.PrefixFacture;
import symatique.smartseller.data.Encaissements.TypeEncaissementVente;
import symatique.smartseller.data.Ventes.RapportVisite;
import symatique.smartseller.modules.Authentification.AuthentificationActivity;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.services.RetrofitService.ApiService;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;

public class SynchronisationActivity extends AppCompatActivity {

    @BindView(R.id.imgbtn_synchronactivity_export)
    AppCompatImageButton imgbtnSynchronactivityExport;
    @BindView(R.id.imgbtn_synchronactivity_import)
    AppCompatImageButton imgbtnSynchronactivityImport;
    @BindView(R.id.imgbtn_synchronactivity_print)
    AppCompatImageButton imgbtnSynchronactivityPrint;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public SynchronisationActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronisation);
        ButterKnife.bind(this);
        setupToolBar();
    }

    private void setupToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_panieroly, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.act_item_panier: {
                Intent intent = new Intent(this, PanierActivity.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @OnClick(R.id.imgbtn_synchronactivity_export)
    public void imgbtnSynchronactivityExportOnClick() {

        ajouterCommandes(this);

        //stockLivreur();
        //ajouterRapportVente();
        //exportFacturesBonsLivraisons();
        //exportFacturesBonsLivraisonsTemp();
        //ajouterNouveauClient();
        Toast.makeText(this, "Bien importés !", Toast.LENGTH_LONG).show();
        imgbtnSynchronactivityExport.setEnabled(false);
    }

    @OnClick(R.id.imgbtn_synchronactivity_import)
    public void imgbtnSynchronactivityImportOnClick() {
        Log.v("Handler button action", "IMPORTING");

        // + INITIAL STATE
        synchroniseClients();
        synchroniseCategorieArticles();
        synchroniseArticles();
        synchroniseBonDeSorties();
        synchroniseEtatCommandes();
        //synchronise
        //synchroniseCommandes();
        //synchroniseNatureVentes();
        //synchroniseTypeEncaissementVente();
        //synchroniseBanques();
        // - INITIAL STATE

        // + MAIN STATE
        //synchronisePrefixBls();
        //synchronisePrefixFactures();
        //synchroniseFactures();
        // - MAIN STATE
        Toast.makeText(this, "Bien importés !", Toast.LENGTH_LONG).show();
        imgbtnSynchronactivityImport.setEnabled(false);
    }

    private void synchroniseFactures() {
        ApiService.getApiService().getFactures(AuthentificationActivity.authenticationResponse.getIdLivreur(), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<Facture>>() {
            @Override
            public void onResponse(Call<List<Facture>> call, Response<List<Facture>> response) {
                if (response.isSuccessful()) {
                    try {
                        for (Facture facture : response.body()) {
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getFactures().create(facture);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.v("factrues IMP error", "Ya rabbi y3addi hal code 3la 5ir" + response.errorBody() + " " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Facture>> call, Throwable t) {
                Log.v("factrues IMP error", "PHP" + t.getMessage());
            }
        });
    }

    @OnClick(R.id.imgbtn_synchronactivity_print)
    public void imgbtnSynchronactivityPrintOnClick() {
        // PRINT DELEAGTE
    }

    //_____________________________________________________________

    public void synchroniseClients() {
        ApiService.getApiService().getClients(DatabaseHelper.getDateSynchroniseClients(this), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                if (response.isSuccessful()) {
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("CLIENT IN DB", response.body().get(i).getLibelle());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getClients().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("Failed sync clients", response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }

    public void synchroniseArticles() {
        Log.v("synchroniseArticles", "begin");
        ApiService.getApiService().getArticles(DatabaseHelper.getDateSynchroniseArticles(this), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if (response.isSuccessful()) {
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("ARTICLE IN DB ", response.body().get(i).getLibelle());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getArticles().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("Failed sync articles ", response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
        Log.v("synchroniseArticles", "finished");
    }

    public void synchroniseCategorieArticles() {

        ApiService.getApiService().getAllCategory(DatabaseHelper.getDateSynchroniseCategorieArticles(this), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<CategorieArticle>>() {
            @Override
            public void onResponse(Call<List<CategorieArticle>> call, Response<List<CategorieArticle>> response) {
                if (response.isSuccessful()) {
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("CATEGORIE IN DB", response.body().get(i).getLibelleArb());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getCategorieArtices().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("Failed sync categories", response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<CategorieArticle>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }

    public void synchroniseNatureVentes() {
        ApiService.getApiService().synchroniserNatureVentes(DatabaseHelper.getDateSynchroniseNatureVentes(this), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<NatureVente>>() {
            @Override
            public void onResponse(Call<List<NatureVente>> call, Response<List<NatureVente>> response) {
                if (response.isSuccessful()) {
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("NATURE VENTE IN DB", response.body().get(i).getLibelle());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getNatureVentes().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("Failed sync naturevente", response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<NatureVente>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }

    public void synchroniseTypeEncaissementVente() {
        ApiService.getApiService().synchroniserTypeEncaissementVente(DatabaseHelper.getDateSynchroniseTypeEncaissementVente(this), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<TypeEncaissementVente>>() {
            @Override
            public void onResponse(Call<List<TypeEncaissementVente>> call, Response<List<TypeEncaissementVente>> response) {
                if (response.isSuccessful()) {
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("TYPE ENCAISS IN DB", response.body().get(i).getLibelle());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getTypeEncaissementVentes().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("Failed sync typeencaiss", response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<TypeEncaissementVente>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }

    public void synchroniseEtatCommandes() {
        ApiService.getApiService().getEtatCommande(DatabaseHelper.getDateSynchroniseNatureVentes(this), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<EtatCommande>>() {
            @Override
            public void onResponse(Call<List<EtatCommande>> call, Response<List<EtatCommande>> response) {
                if (response.isSuccessful()) {
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("EtatCommande IN DB", response.body().get(i).getLibelle());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getEtatCommandes().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("Failed sync ECS", response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<EtatCommande>> call, Throwable t) {
                Log.e("F2ailed sync ECS", t.getMessage());
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }


    public void synchroniseCommandes() {
        ApiService.getApiService().synchroniserVendeurCommande(DatabaseHelper.getDateSynchroniseCommandes(this), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<Commande>>() {
            @Override
            public void onResponse(Call<List<Commande>> call, Response<List<Commande>> response) {
                try {
                    for (int i = 0; i < response.body().size(); i++)
                        DataBaseManager.getInstance(getApplicationContext()).getHelper().getCommandes().createOrUpdate(response.body().get(i));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Commande>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
                Log.v("commande response", "failerSssDF");
            }
        });
    }

    public void synchroniseBanques() {
        ApiService.getApiService().synchroniserBanque(DatabaseHelper.getDateSynchroniseBanques(this), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<Banque>>() {
            @Override
            public void onResponse(Call<List<Banque>> call, Response<List<Banque>> response) {
                if (response.isSuccessful()) {
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("BANQUE IN DB", response.body().get(i).getLibelle());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getBanques().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.v("FAILD SYNC BANQUES", response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Banque>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }

    public void synchroniseBonDeSorties() {
        ApiService.getApiService().getBonSortie(AuthentificationActivity.authenticationResponse.getCode(), AuthentificationActivity.authenticationResponse.getIdEntreprise(), false).enqueue(new Callback<BonDeSortiesResponse>() {
            @Override
            public void onResponse(Call<BonDeSortiesResponse> call, Response<BonDeSortiesResponse> response) {
                if (response.isSuccessful()) {
                    try {

                        for (BonDeSortie bonDeSortie : response.body().getListBonSortiePaquetWS()) {
                            for (Packet packet : bonDeSortie.getListPaquet()) {
                                Log.v("PACKET IN DB", response.body().toString());
                                DataBaseManager.getInstance(getApplicationContext()).getHelper().getPacketsStock().createOrUpdate(packet);
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.v("FAILD SYNC BONDESORTIE", response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<BonDeSortiesResponse> call, Throwable t) {
                Log.v("onFailure BONDESORTIE", t.getMessage());
            }
        });
    }

    public void synchronisePrefixFactures() {
        ApiService.getApiService().getPrefixsFacture(AuthentificationActivity.authenticationResponse.getIdLivreur(), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<PrefixFacture>>() {
            @Override
            public void onResponse(Call<List<PrefixFacture>> call, Response<List<PrefixFacture>> response) {
                try {
                    for (int i = 0; i < response.body().size(); i++)
                        DataBaseManager.getInstance(getApplicationContext()).getHelper().getPrefixFactures().createOrUpdate(response.body().get(i));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<PrefixFacture>> call, Throwable t) {
                Log.v("Factures response", "failerSDF" + t.getMessage());
            }
        });
    }

    public void synchronisePrefixBls() {
        ApiService.getApiService().getPrefixsBL(AuthentificationActivity.authenticationResponse.getIdLivreur(), AuthentificationActivity.authenticationResponse.getIdEntreprise()).enqueue(new Callback<List<PrefixBL>>() {
            @Override
            public void onResponse(Call<List<PrefixBL>> call, Response<List<PrefixBL>> response) {
                if (response.isSuccessful()) {
                    try {
                        for (int i = 0; i < response.body().size(); i++)
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getPrefixBLS().createOrUpdate(response.body().get(i));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.v("FAILD SYNC BLS", response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<PrefixBL>> call, Throwable t) {
                Log.v("BL response BL", "failerSDF" + t.getMessage());
            }
        });
    }

// + ******************************************* EXPORT ********************************************


    public void stockLivreur() {
        List<Packet> packets = new ArrayList<>();

        try {
            packets = DataBaseManager.getInstance(getApplicationContext()).getHelper().getPacketsStock().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!packets.isEmpty()) {
            ApiService.getApiService().stockLivreur(packets).enqueue(new Callback<List<Packet>>() {
                @Override
                public void onResponse(Call<List<Packet>> call, Response<List<Packet>> response) {

                }

                @Override
                public void onFailure(Call<List<Packet>> call, Throwable t) {

                }
            });
        }

    }

    public void ajouterRapportVente() {
        List<RapportVisite> rapportVisites = new ArrayList<>();
        try {
            rapportVisites = DataBaseManager.getInstance(this).getHelper().getRapportVisites().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!rapportVisites.isEmpty()) {
            ApiService.getApiService().ajouterRapportVente(rapportVisites).enqueue(new Callback<List<RapportVisite>>() {
                @Override
                public void onResponse(Call<List<RapportVisite>> call, Response<List<RapportVisite>> response) {

                }

                @Override
                public void onFailure(Call<List<RapportVisite>> call, Throwable t) {

                }
            });
        }
    }

    public void exportFacturesBonsLivraisons() {
        List<Facture> factures = new ArrayList<>();

        try {
            factures = DataBaseManager.getInstance(this).getHelper().getFactures().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!factures.isEmpty()) {
            ApiService.getApiService().exportFacturesBonsLivraisons(factures).enqueue(new Callback<List<Facture>>() {
                @Override
                public void onResponse(Call<List<Facture>> call, Response<List<Facture>> response) {

                }

                @Override
                public void onFailure(Call<List<Facture>> call, Throwable t) {

                }
            });
        }
    }

    public void exportFacturesBonsLivraisonsTemp() {
        exportFacturesBonsLivraisons();
    }

    public void ajouterCommandes(Context context) {
        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            List<Commande> commandes = database.getCommandes().queryForAll();
            if (!commandes.isEmpty()) {
                List<Commande> commandeList = new ArrayList<>();

                for (Commande commande : commandes) if (commande.getDateSynch() == 0) commandeList.add(commande);

                ApiService.getApiService().ajouterCommandes(commandeList).enqueue(new Callback<List<Commande>>() {
                    @Override
                    public void onResponse(Call<List<Commande>> call, Response<List<Commande>> response) {
                        if (response.isSuccessful()) {
                            try {
                                EtatCommande etatCommande = DatabaseHelper.getEtatCommandeByArgs(context, "rang", 0);
                                for (Commande commande : commandeList) {
                                    commande.setEtatCommande(etatCommande);
                                }
                                database.getCommandes().create(commandeList);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Commande>> call, Throwable t) {
                    }
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void ajouterNouveauClient() {

    }

// - ******************************************* EXPORT ********************************************

}

/*
  AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                            alertDialog.setTitle("Synchronisation");
                            alertDialog.setMessage("Do you want to turn on GPS?");
                            alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });

                            alertDialog.show();
 */