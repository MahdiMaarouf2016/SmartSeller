package symatique.smartseller.modules.Stock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.services.SQLiteService.DataBaseManager;

public class StockActivity extends AppCompatActivity {

    @BindView(R.id.rec_stockactivity_liststock) RecyclerView recStockactivityListstock;
    @BindView(R.id.txt_stockactivity_valeurtotal) AppCompatTextView txtStockactivityValeurtotal;
    @BindView(R.id.txt_stockactivity_nbrarticles) AppCompatTextView txtStockactivityNbrarticles;
    @BindView(R.id.txt_stockactivity_nbrarticlespanier) AppCompatTextView txtStockactivityNbrarticlespanier;
    @BindView(R.id.tableLayout4) TableLayout tableLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        ButterKnife.bind(this);

        setupToolBar();
        setUpStocks();
    }

    public List<Packet> getLigneStockParVendeurs() {
        List<Packet> packets = new ArrayList<>();

        try {
            packets = DataBaseManager.getInstance(getApplicationContext()).getHelper().getPacketsStock().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packets;
    }

    public void setUpStocks() {

        StockAdapter stockAdapter = new StockAdapter(getLigneStockParVendeurs());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recStockactivityListstock.setLayoutManager(layoutManager);
        recStockactivityListstock.setItemAnimator(new DefaultItemAnimator());
        recStockactivityListstock.setAdapter(stockAdapter);

        txtStockactivityNbrarticles.setText(String.valueOf(stockAdapter.getNombreArticles()));
        txtStockactivityValeurtotal.setText(String.valueOf(stockAdapter.getValeurTotale()));
        txtStockactivityNbrarticlespanier.setText(String.valueOf(PanierActivity.getPanierAdapter().getItemCount()));
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_panier_search, menu);
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
