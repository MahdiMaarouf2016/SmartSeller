package symatique.smartseller.modules.Produits;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Articles.Article;
import symatique.smartseller.data.Articles.CategorieArticle;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.modules.Panier.PanierAdapter;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;
import symatique.smartseller.utils.ClickListener;
import symatique.smartseller.utils.RecyclerTouchListener;

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
        setupProduitsList(getListArticlesFiltrePanier());
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

    public List<Article> getListArticles() {
        List<Article> articles = new ArrayList<>();
        try {
            DatabaseHelper database = DataBaseManager.getInstance(this).getHelper();
            articles = database.getArticles().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public List<Article> getListArticlesFiltrePanier() {

        List<Article> articles = getListArticles();
        List<PanierAdapter.PanierPacket> panierPackets = PanierActivity.getPanierAdapter().getPanierElements();
        if (!articles.isEmpty() && !panierPackets.isEmpty()) {
            for (PanierAdapter.PanierPacket panierPacket : panierPackets) {
                articles.remove(panierPacket.getArticle());
            }

        }
        return articles;
    }

    public List<Article> getListArticlesFiltreCategorie(final CategorieArticle categorieArticle) {

        List<Article> articles = getListArticlesFiltrePanier();
        List<Article> tempArticles = getListArticlesFiltrePanier();// DO NOT AFFECT HIM 'articles' ?! PLEASE ... PLEAAASE .
        if (!articles.isEmpty()) {

            for (Article article : tempArticles) {
                if(article.getIdCategorie() != categorieArticle.getId())
                    articles.remove(article);
            }
        }
        return articles;
    }

    public void setupProduitsList(final List<Article> articles) {


        ProduitsAdapter produitsAdapter = new ProduitsAdapter(articles);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recProduitsListaricles.setLayoutManager(layoutManager);
        recProduitsListaricles.setItemAnimator(new DefaultItemAnimator());
        recProduitsListaricles.setAdapter(produitsAdapter);

    }

    public void setUpDelegates() {
        final Context context = this;
        fabProduitsactivityGocategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCategories dialog = new DialogCategories(context) {
                    @Override
                    public void OnAccepted() {
                        this.btnDialogcategorieToutcategorie.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setupProduitsList(getListArticlesFiltrePanier());
                            }
                        });
                        recDialogcategorieCategories.addOnItemTouchListener(new RecyclerTouchListener(this.getContext(),
                                        recDialogcategorieCategories, new ClickListener() {
                                    @Override
                                    public void onClick(View view, int position) {
                                        CategorieArticle categorieArticle = ((CategoriesAdapter)recDialogcategorieCategories.getAdapter()).getCategories().get(position);
                                        setupProduitsList(getListArticlesFiltreCategorie(categorieArticle));
                                    }

                                    @Override
                                    public void onLongClick(View view, int position) {
                                        onClick(view, position);
                                    }
                                })
                        );
                    }

                    @Override
                    public void OnRejected() {

                    }
                };
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
