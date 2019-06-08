package symatique.smartseller.modules.Panier;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;

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
    @BindView(R.id.constraintLayout)
    ConstraintLayout constraintLayout;
    public static List<PanierAdapter.PanierItem.PanierPacket> panierPackets = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panier);
        ButterKnife.bind(this);
        setupToolBar();
        setUpPaniers();
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setUpPaniers() {

        PanierAdapter panierAdapter = new PanierAdapter(panierPackets);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recPanierListarticles.setLayoutManager(layoutManager);
        recPanierListarticles.setItemAnimator(new DefaultItemAnimator());
        recPanierListarticles.setAdapter(panierAdapter);

    }
}
