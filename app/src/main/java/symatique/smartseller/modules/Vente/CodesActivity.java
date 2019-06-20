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
    @BindView(R.id.toolbar)
    Toolbar toolbar;

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
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public List<Packet> getListPacketsFiltrePanier() {
        List<Packet> packets = getListPackets();
        List<Packet> ligneStockParVendeurstemp = getListPackets();// WE SAID THAT AGO , IF YOU REMEMBER MY CODE AS WEEL
        if(!packets.isEmpty()){
            for (Packet ligneStockparVendeur:ligneStockParVendeurstemp) {
                if(PanierClientActivity.getPanierClientAdapter().getPackets().contains(ligneStockparVendeur))
                    packets.remove(ligneStockparVendeur);
            }
        }
        return packets;
    }

    public List<Packet> getListPackets() {
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
        List<Packet> packets = getListPacketsFiltrePanier();
        final Context context = this;
        if (!packets.isEmpty()) {

            final CodesAdapter codesAdapter = new CodesAdapter(packets);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recCodesactivityListcodes.setLayoutManager(layoutManager);
            recCodesactivityListcodes.setItemAnimator(new DefaultItemAnimator());
            recCodesactivityListcodes.setAdapter(codesAdapter);
        }
    }
}
