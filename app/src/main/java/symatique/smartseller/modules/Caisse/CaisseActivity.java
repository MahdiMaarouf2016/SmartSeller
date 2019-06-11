package symatique.smartseller.modules.Caisse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.modules.Factures.BLFragment;
import symatique.smartseller.modules.Factures.FactureFragment;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.utils.ViewPagerAdapter;

;

public class CaisseActivity extends AppCompatActivity {

    @BindView(R.id.btnimg_caisseactivity_print) AppCompatImageButton btnimgCaisseactivityPrint;
    @BindView(R.id.txt_caisseactivity_medoil) AppCompatTextView txtCaisseactivityMedoil;
    @BindView(R.id.txt_caisseactivity_totalventes) AppCompatTextView txtCaisseactivityTotalventes;
    @BindView(R.id.txt_caisseactivity_medoilbm) AppCompatTextView txtCaisseactivityMedoilbm;
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
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setupTabHostes() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FactureFragment(), "Factures");
        adapter.addFragment(new BLFragment(), "BL");
        pagerCaisseactivityScrolpager.setAdapter(adapter);
        tabsCaisseactivityTabs.setupWithViewPager(pagerCaisseactivityScrolpager);
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
