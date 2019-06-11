package symatique.smartseller.modules.Panier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.data.Commandes.Commande;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;
import symatique.smartseller.utils.AdapterDelegates;

import java.sql.SQLException;
import java.util.List;

public class PanierActivity extends AppCompatActivity {

    @BindView(R.id.rec_panier_listarticles) RecyclerView recPanierListarticles;
    @BindView(R.id.txt_panier_labeltotalcommande) AppCompatTextView txtPanierLabeltotalcommande;
    @BindView(R.id.txt_panier_totalcommandes) AppCompatTextView txtPanierTotalcommandes;
    @BindView(R.id.txt_panier_quantitearticles) AppCompatTextView txtPanierQuantitearticles;
    @BindView(R.id.txt_panier_labelquantite) AppCompatTextView txtPanierLabelquantite;
    @BindView(R.id.btn_panier_commander) AppCompatButton btnPanierCommander;

    private static PanierAdapter panierAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        ButterKnife.bind(this);
        setupToolBar();
        setUpPaniers();
    }

    public static PanierAdapter getPanierAdapter() {
        if(panierAdapter == null) panierAdapter = new PanierAdapter() ;
        return panierAdapter;
    }

    @OnClick(R.id.btn_panier_commander)
    public void btnPanierCommanderOnClick() {
        Commande commande = getPanierAdapter().getCommande();
        try{
            DatabaseHelper database = DataBaseManager.getInstance(this).getHelper();
            database.getCommandes().create(commande);
            Log.v("Commandez","Commande a ete ajoute");
        } catch (SQLException e) {
            e.printStackTrace();
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
                txtPanierTotalcommandes.setText(String.valueOf(getPanierAdapter().getTotalCommande()));
                txtPanierQuantitearticles.setText(String.valueOf(getPanierAdapter().getTotalQuantite()));

            }

            @Override
            public void OnPanierPacketDeleted(Object object) {
                txtPanierTotalcommandes.setText(String.valueOf(getPanierAdapter().getTotalCommande()));
                txtPanierQuantitearticles.setText(String.valueOf(getPanierAdapter().getTotalQuantite()));

            }

            @Override
            public void OnPanierPacketUpdated(Object object) {
                txtPanierTotalcommandes.setText(String.valueOf(getPanierAdapter().getTotalCommande()));
                txtPanierQuantitearticles.setText(String.valueOf(getPanierAdapter().getTotalQuantite()));
                Log.v("OnPanierPacketUpdated",String.valueOf(getPanierAdapter().getTotalCommande()) + "|" + String.valueOf(getPanierAdapter().getTotalQuantite()));

            }

            @Override
            public void OnInitializedAdapter(List objects) {
                txtPanierTotalcommandes.setText(String.valueOf(getPanierAdapter().getTotalCommande()));
                txtPanierQuantitearticles.setText(String.valueOf(getPanierAdapter().getTotalQuantite()));

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recPanierListarticles.setLayoutManager(layoutManager);
        recPanierListarticles.setItemAnimator(new DefaultItemAnimator());
        recPanierListarticles.setAdapter(getPanierAdapter());

        txtPanierTotalcommandes.setText(String.valueOf(getPanierAdapter().getTotalCommande()));
        txtPanierQuantitearticles.setText(String.valueOf(getPanierAdapter().getTotalQuantite()));

    }
}
