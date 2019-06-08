package symatique.smartseller.modules.Synchronisation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import symatique.smartseller.R;
import symatique.smartseller.data.Article;
import symatique.smartseller.data.Banque;
import symatique.smartseller.data.BonDeSortie;
import symatique.smartseller.data.CategorieArticle;
import symatique.smartseller.data.Client;
import symatique.smartseller.data.Commande;
import symatique.smartseller.data.NatureVente;
import symatique.smartseller.data.PrefixBL;
import symatique.smartseller.data.PrefixFacture;
import symatique.smartseller.data.TypeEncaissementVente;
import symatique.smartseller.modules.Authentification.AuthentificationActivity;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.services.RetrofitService.ApiService;
import symatique.smartseller.services.SQLiteService.DataBaseManager;

public class SynchronisationActivity extends AppCompatActivity {

    @BindView(R.id.imgbtn_synchronactivity_export)
     AppCompatImageButton imgbtnSynchronactivityExport;
    @BindView(R.id.imgbtn_synchronactivity_import)
     AppCompatImageButton imgbtnSynchronactivityImport;
    @BindView(R.id.imgbtn_synchronactivity_print)
     AppCompatImageButton imgbtnSynchronactivityPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronisation);
        ButterKnife.bind(this);
        setupToolBar();
        setUpDelegates();
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
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

    public void setUpDelegates() {

        imgbtnSynchronactivityExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EXPORT DELEAGTE
            }
        });
        imgbtnSynchronactivityImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // IMPORT DELEAGTE
                Log.v("Handler button action","IMPORTING");
                synchroniseClients();
                synchroniseCategorieArticles();
                synchroniseArticles();
                synchroniseCommandes();
                synchroniseNatureVentes();
                synchroniseTypeEncaissementVente();
                //synchronisePrefixBls();
                //synchronisePrefixFactures();
                synchroniseBanques();
                synchroniseBonDeSorties();

            }
        });
        imgbtnSynchronactivityPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // PRINT DELEAGTE
            }
        });

    }

    public void synchroniseClients() {
        ApiService.getApiService().getClients(new Date().getTime(), Long.parseLong(AuthentificationActivity.authenticationResponse.getCodeEntreprise())).enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                if(response.isSuccessful()){
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("CLIENT IN DB", response.body().get(i).getLibelle());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getClients().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                   Log.e("Failed sync clients",response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }

    public void synchroniseArticles() {
        Log.v("synchroniseArticles","begin");
        ApiService.getApiService().getArticles(new Date().getTime(), Long.parseLong(AuthentificationActivity.authenticationResponse.getCodeEntreprise())).enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if(response.isSuccessful()) {
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("ARTICLE IN DB ", response.body().get(i).getLibelle());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getArticles().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.e("Failed sync articles ",response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
        Log.v("synchroniseArticles","finished");
    }

    public void synchroniseCategorieArticles() {

        ApiService.getApiService().getAllCategory(new Date().getTime(), Long.parseLong(AuthentificationActivity.authenticationResponse.getCodeEntreprise())).enqueue(new Callback<List<CategorieArticle>>() {
            @Override
            public void onResponse(Call<List<CategorieArticle>> call, Response<List<CategorieArticle>> response) {
                if(response.isSuccessful()){
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("CATEGORIE IN DB",response.body().get(i).getLibelleArb());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getCategorieArtices().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.e("Failed sync categories",response.code() + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<CategorieArticle>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }

    public void synchroniseNatureVentes() {
        ApiService.getApiService().synchroniserNatureVentes(new Date().getTime(), Long.parseLong(AuthentificationActivity.authenticationResponse.getCodeEntreprise())).enqueue(new Callback<List<NatureVente>>() {
            @Override
            public void onResponse(Call<List<NatureVente>> call, Response<List<NatureVente>> response) {
               if(response.isSuccessful()){
                   try {
                       for (int i = 0; i < response.body().size(); i++) {
                           Log.v("NATURE VENTE IN DB",response.body().get(i).getLibelle());
                           DataBaseManager.getInstance(getApplicationContext()).getHelper().getNatureVentes().createOrUpdate(response.body().get(i));
                       }
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               } else {
                   Log.e("Failed sync naturevente",response.code() + response.message());
               }
            }

            @Override
            public void onFailure(Call<List<NatureVente>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }

    public void synchroniseTypeEncaissementVente() {
        ApiService.getApiService().synchroniserTypeEncaissementVente(new Date().getTime(), Long.parseLong(AuthentificationActivity.authenticationResponse.getCodeEntreprise())).enqueue(new Callback<List<TypeEncaissementVente>>() {
            @Override
            public void onResponse(Call<List<TypeEncaissementVente>> call, Response<List<TypeEncaissementVente>> response) {
               if(response.isSuccessful()){
                   try {
                       for (int i = 0; i < response.body().size(); i++){
                           Log.v("TYPE ENCAISS IN DB",response.body().get(i).getLibelle());
                           DataBaseManager.getInstance(getApplicationContext()).getHelper().getTypeEncaissementVentes().createOrUpdate(response.body().get(i));
                       }
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }else{
                   Log.e("Failed sync typeencaiss",response.code() + response.message());
               }
            }

            @Override
            public void onFailure(Call<List<TypeEncaissementVente>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }

    public void synchroniseCommandes(){
        ApiService.getApiService().synchroniserVendeurCommande(new Date().getTime(), Long.parseLong(AuthentificationActivity.authenticationResponse.getCodeEntreprise())).enqueue(new Callback<List<Commande>>() {
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
            }
        });
    }

    public void synchronisePrefixFactures(){
        ApiService.getApiService().getPrefixsFacture(new Date().getTime(), Long.parseLong(AuthentificationActivity.authenticationResponse.getCodeEntreprise())).enqueue(new Callback<List<PrefixFacture>>() {
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
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }
    public void synchronisePrefixBls(){
        ApiService.getApiService().getPrefixsBL(new Date().getTime(), Long.parseLong(AuthentificationActivity.authenticationResponse.getCodeEntreprise())).enqueue(new Callback<List<PrefixBL>>() {
            @Override
            public void onResponse(Call<List<PrefixBL>> call, Response<List<PrefixBL>> response) {
                if(response.isSuccessful()){
                    try {
                        for (int i = 0; i < response.body().size(); i++)
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getPrefixBLS().createOrUpdate(response.body().get(i));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.v("FAILD SYNC BLS",response.code() + response.message() );
                }
            }

            @Override
            public void onFailure(Call<List<PrefixBL>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }

    public void synchroniseBanques(){
        ApiService.getApiService().synchroniserBanque(new Date().getTime(), Long.parseLong(AuthentificationActivity.authenticationResponse.getCodeEntreprise())).enqueue(new Callback<List<Banque>>() {
            @Override
            public void onResponse(Call<List<Banque>> call, Response<List<Banque>> response) {
                if(response.isSuccessful()){
                    try {
                        for (int i = 0; i < response.body().size(); i++) {
                            Log.v("BANQUE IN DB",response.body().get(i).getLibelle());
                            DataBaseManager.getInstance(getApplicationContext()).getHelper().getBanques().createOrUpdate(response.body().get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.v("FAILD SYNC BANQUES",response.code() + response.message() );
                }
            }

            @Override
            public void onFailure(Call<List<Banque>> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }
    public void synchroniseBonDeSorties(){
        ApiService.getApiService().getBonSortie(AuthentificationActivity.authenticationResponse.getCode(),AuthentificationActivity.authenticationResponse.getIdEntreprise(),false).enqueue(new Callback<BonDeSortie>() {
            @Override
            public void onResponse(Call<BonDeSortie> call, Response<BonDeSortie> response) {
                if(response.isSuccessful()){
                    try {
                        Log.v("BONDESORTIE IN DB",response.body().toString());
                        DataBaseManager.getInstance(getApplicationContext()).getHelper().getBonDeSortieDao().createOrUpdate(response.body());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.v("FAILD SYNC BONDESORTIE",response.code() + response.message() );
                }
            }

            @Override
            public void onFailure(Call<BonDeSortie> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
            }
        });
    }
}