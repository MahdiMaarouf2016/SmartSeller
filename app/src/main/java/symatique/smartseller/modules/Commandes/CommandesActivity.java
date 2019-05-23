package symatique.smartseller.modules.Commandes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.SQLException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Commande;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.services.SQLiteService.DataBaseManager;

public class CommandesActivity extends AppCompatActivity {

    @BindView(R.id.rec_commandes_listcommandes)
     RecyclerView recCommandesListcommandes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commandes);
        ButterKnife.bind(this);
        setUpCommandes();
        setupToolBar();
    }

    private void setUpCommandes() {
        try {
            List<Commande> commandes = DataBaseManager.getInstance().getHelper().getCommandes().queryForAll();
            CommandesAdapter commandesAdapter = new CommandesAdapter(commandes);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recCommandesListcommandes.setLayoutManager(layoutManager);
            recCommandesListcommandes.setItemAnimator(new DefaultItemAnimator());
            recCommandesListcommandes.setAdapter(commandesAdapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
}
