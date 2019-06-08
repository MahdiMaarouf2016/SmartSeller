package symatique.smartseller.modules.Commandes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.j256.ormlite.dao.ForeignCollection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Commande;
import symatique.smartseller.data.DetailCommande;
import symatique.smartseller.modules.Panier.PanierActivity;

public class DetailCommandeActivity extends AppCompatActivity {

    @BindView(R.id.rec_detailscommande_listdetailscommande)
     RecyclerView recDetailscommandeListdetailscommande;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_commande);
        ButterKnife.bind(this);
        setupToolBar();
        setUp(savedInstanceState);
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

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

    public void setUp(Bundle savedInstanceState) {
        try {

            /*Commande commande = (Commande) getIntent().getExtras().get("Commande");
            List<DetailCommande> detailCommandes = ((ForeignCollection)commande.getDetailCommandes()).getDao().queryForAll();
            DetailsCommandeAdapter detailsCommandeAdapter = new DetailsCommandeAdapter(detailCommandes);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recDetailscommandeListdetailscommande.setLayoutManager(layoutManager);
            recDetailscommandeListdetailscommande.setItemAnimator(new DefaultItemAnimator());
            recDetailscommandeListdetailscommande.setAdapter(detailsCommandeAdapter);
            */
        } catch (Exception ex) {
            Log.v("COMMANDE DATA MESSAGE", ex.getMessage());
        }

    }
}
