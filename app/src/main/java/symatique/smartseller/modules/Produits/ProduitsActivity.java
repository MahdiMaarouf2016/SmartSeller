package symatique.smartseller.modules.Produits;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import java.sql.SQLException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Article;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;

public class ProduitsActivity extends AppCompatActivity {

    @BindView(R.id.edttxt_produits_findarticle)
     AppCompatEditText edttxtProduitsFindarticle;
    @BindView(R.id.rec_produits_listaricles)
     RecyclerView recProduitsListaricles;
    @BindView(R.id.fab_produitsactivity_gocategories)
     FloatingActionButton fabProduitsactivityGocategories;
    @BindView(R.id.toolbar)
     Toolbar toolbar;
    @BindView(R.id.abl_produit)
     AppBarLayout ablProduit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);
        ButterKnife.bind(this);
        setupToolBar();
        setupProductsList();
        setUpDelegates();
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

    public void setupProductsList() {

        DatabaseHelper database = DataBaseManager.getInstance().getHelper();
        try {

            List<Article> articles = database.getArticles().queryForAll();
            ProduitsAdapter produitsAdapter = new ProduitsAdapter(articles);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recProduitsListaricles.setLayoutManager(layoutManager);
            recProduitsListaricles.setItemAnimator(new DefaultItemAnimator());
            recProduitsListaricles.setAdapter(produitsAdapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUpDelegates() {
        fabProduitsactivityGocategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCategories dialog = new DialogCategories(getBaseContext());
                dialog.show();
            }
        });
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
