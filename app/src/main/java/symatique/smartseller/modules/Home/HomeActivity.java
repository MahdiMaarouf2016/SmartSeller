package symatique.smartseller.modules.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.modules.Caisse.CaisseActivity;
import symatique.smartseller.modules.Client.ClientsActivity;
import symatique.smartseller.modules.Commandes.CommandesActivity;
import symatique.smartseller.modules.Factures.FacturesActivity;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.modules.Parametres.ParametresActivity;
import symatique.smartseller.modules.Planning.PlanningActivity;
import symatique.smartseller.modules.Produits.ProduitsActivity;
import symatique.smartseller.modules.Stock.StockActivity;
import symatique.smartseller.modules.Synchronisation.SynchronisationActivity;
import symatique.smartseller.modules.Vente.VentesActivity;
import symatique.smartseller.utils.RecyclerTouchListener;
import symatique.smartseller.utils.ClickListener;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setupToolBar();
        setUpMenu();
    }

    private void setupToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_panier_quit, menu);
        return true;
    }

    private void setUpMenu(){

        MenuAdapter MenuAdapter = new MenuAdapter();
        RecyclerView recyclerView = findViewById(R.id.rec_menu_home);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(MenuAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, final int position) {
                switch (position){
                    case 0 :{
                        Intent intent = new Intent(getBaseContext(),PlanningActivity.class);
                        startActivity(intent); break;
                    }
                    case 1:{
                        Intent intent = new Intent(getBaseContext(),ProduitsActivity.class);
                        startActivity(intent); break;
                    }
                    case 2:{
                        Intent intent = new Intent(getBaseContext(),CommandesActivity.class);
                        startActivity(intent); break;
                    }
                    case 3:{
                        Intent intent = new Intent(getBaseContext(),VentesActivity.class);
                        startActivity(intent); break;
                    }
                    case 4:{
                        Intent intent = new Intent(getBaseContext(),FacturesActivity.class);
                        startActivity(intent); break;
                    }
                    case 5:{
                        Intent intent = new Intent(getBaseContext(),StockActivity.class);
                        startActivity(intent); break;
                    }
                    case 6:{
                        Intent intent = new Intent(getBaseContext(),ClientsActivity.class);
                        startActivity(intent); break;
                    }
                    case 7:{
                        Intent intent = new Intent(getBaseContext(),CaisseActivity.class);
                        startActivity(intent); break;
                    }
                    case 8:{
                        Intent intent = new Intent(getBaseContext(),SynchronisationActivity.class);
                        startActivity(intent); break;
                    }
                    case 9:{
                        Intent intent = new Intent(getBaseContext(),ParametresActivity.class);
                        startActivity(intent); break;
                    }

                }
            }

            @Override
            public void onLongClick(View view, int position) {
                this.onClick(view,position);
            }
        }));

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.act_item_panier:{
                Intent intent = new Intent(getBaseContext(),PanierActivity.class);
                startActivity(intent);
                return true;

            }
            case R.id.act_item_quit: {
                finish();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);

        }
    }


    public void insertStockItem() {

    }

    public void insertPlanningItem() {

    }
}
