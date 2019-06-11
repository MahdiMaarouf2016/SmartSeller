package symatique.smartseller.modules.Vente;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;
import symatique.smartseller.utils.ClickListener;
import symatique.smartseller.utils.RecyclerTouchListener;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodesActivity extends AppCompatActivity {

    public static final String KEY_EXTRA_CLIENT = "CLIENT";
    @BindView(R.id.rec_codesactivity_listcodes) RecyclerView recCodesactivityListcodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codes);
        ButterKnife.bind(this);
        setupToolBar();
        setUpCodes();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_searchonly, menu);
        return true;
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public List<Packet> getLigneStockParVendeursFiltrePanier(){
        List<Packet> packets = getLigneStockParVendeurs();
        List<Packet> ligneStockParVendeurstemp = getLigneStockParVendeurs();// WE SAID THAT AGO , IF YOU REMEMBER MY CODE AS WEEL
        if(!packets.isEmpty()){
            for (Packet ligneStockparVendeur:ligneStockParVendeurstemp) {
                if(PanierClientActivity.getPanierClientAdapter().getPackets().contains(ligneStockparVendeur))
                    packets.remove(ligneStockparVendeur);
            }
        }
        return packets;
    }

    public List<Packet> getLigneStockParVendeurs() {
        List<Packet> packets = new ArrayList<>();
        try {
            DatabaseHelper database = DataBaseManager.getInstance(this).getHelper();
            packets = database.getPacketsStock().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packets;
    }

    public void setUpCodes() {
        List<Packet> packets = getLigneStockParVendeursFiltrePanier();

        if (!packets.isEmpty()) {

            final CodesAdapter codesAdapter = new CodesAdapter(packets);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recCodesactivityListcodes.setLayoutManager(layoutManager);
            recCodesactivityListcodes.setItemAnimator(new DefaultItemAnimator());
            recCodesactivityListcodes.setAdapter(codesAdapter);
            recCodesactivityListcodes.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),
                    recCodesactivityListcodes, new ClickListener() {
                        @Override
                        public void onClick(View view, int position) {
                            final Packet packet = codesAdapter.getPackets().get(position);
                            DialogPrixQuantiteLivrison dialogPrixQuantiteLivrison = new DialogPrixQuantiteLivrison(view.getContext(), packet) {
                                @Override
                                public void OnAccepted() {
                                    PanierClientActivity.getPanierClientAdapter().AjouterLigneStockParVendeur(packet);
                                    hide();
                                }

                                @Override
                                public void OnRejected() {

                                }
                            };

                            dialogPrixQuantiteLivrison.show();
                        }

                        @Override
                        public void onLongClick(View view, int position) {
                            onClick(view, position);
                        }
                    })
            );
        }
    }
}
