package symatique.smartseller.modules.Authentification;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import symatique.smartseller.R;
import symatique.smartseller.data.Articles.Article;
import symatique.smartseller.data.Articles.CategorieArticle;
import symatique.smartseller.data.Commandes.Commande;
import symatique.smartseller.data.Encaissements.Banque;
import symatique.smartseller.data.Encaissements.TypeEncaissementVente;
import symatique.smartseller.data.Factures.PrefixBL;
import symatique.smartseller.data.Factures.PrefixFacture;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.data.Ventes.NatureVente;
import symatique.smartseller.services.RetrofitService.ApiService;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class OnExecuteSplashScreen extends AppCompatActivity {

    static long dateSynchronisationArticles = 0;
    static long dateSynchronisationBanques = 0;
    static long dateSynchronisationCategorieArticles = 0;
    static long dateSynchronisationClients = 0;
    static long dateSynchronisationCommandes = 0;
    static long dateSynchronisationNatureVentes = 0;
    static long dateSynchronisationPrefixBls = 0;
    static long dateSynchronisationPrefixFactures = 0;
    static long dateSynchronisationTypeEncaissementVente = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chargement);
        startHeavyProcessing();
    }

    private void startHeavyProcessing() {
        new LongOperation().execute("");
    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return "done";
        }

        @Override
        protected void onPostExecute(String result) {
            Intent intent = new Intent(getBaseContext(), AuthentificationActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        protected void onPreExecute() {
            DatabaseHelper database = DataBaseManager.getInstance(getBaseContext()).getHelper();
           /* ueryBuilder<Client,> qBuilder = myEntityDao.queryBuilder();
            qBuilder.orderby("my_field_column_name",false); // false for descending order
            qBuilder.limit(1);
            List<MyEntity> listOfOne = qBuilder.query();
            database.getClients().*/
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }


}
