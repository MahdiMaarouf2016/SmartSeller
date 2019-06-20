package symatique.smartseller.modules.Caisse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.data.Factures.Facture;
import symatique.smartseller.modules.Factures.FacturesBonLivraisonFragment;
import symatique.smartseller.modules.Factures.FacturesFactureFragment;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.utils.ViewPagerAdapter;

;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaisseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btnimg_caisseactivity_print) AppCompatImageButton btnimgCaisseactivityPrint;
    @BindView(R.id.rec_caisse_caissepardomaines)
    RecyclerView recCaisseCaissepardomaines;
    @BindView(R.id.txt_caisseactivity_totalventes) AppCompatTextView txtCaisseactivityTotalventes;
    @BindView(R.id.pager_caisseactivity_scrolpager)ViewPager pagerCaisseactivityScrolpager;
    @BindView(R.id.tabs_caisseactivity_tabs) TabLayout tabsCaisseactivityTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caisse);
        ButterKnife.bind(this);
        setupToolBar();
        setupTabHostes();
    }

    private void setupToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setupTabHostes() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FacturesFactureFragment(), "Facture");
        adapter.addFragment(new FacturesBonLivraisonFragment(), "BL");
        pagerCaisseactivityScrolpager.setAdapter(adapter);
        tabsCaisseactivityTabs.setupWithViewPager(pagerCaisseactivityScrolpager);

        List<Facture> factures = new ArrayList<>();

        try {
            factures = DataBaseManager.getInstance(this).getHelper().getFactures().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        double total = 0;
        for (Facture facture : factures) {
            total += facture.getMontantHT().doubleValue();
        }
        txtCaisseactivityTotalventes.setText(total + "");
    }

    @Override
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

    @OnClick(R.id.btnimg_caisseactivity_print)
    public void onViewClicked() {

    }
}
