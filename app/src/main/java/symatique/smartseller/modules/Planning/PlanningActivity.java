package symatique.smartseller.modules.Planning;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import symatique.smartseller.R;
import symatique.smartseller.data.Client;
import symatique.smartseller.data.Livreur;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.services.RetrofitService.ApiRegister;
import symatique.smartseller.services.RetrofitService.ApiService;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;

public class PlanningActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.abl_planning) AppBarLayout ablPlanning;
    @BindView(R.id.txt_planning_date) AppCompatTextView txtPlanningDate;
    @BindView(R.id.rec_planning_clients) RecyclerView recPlanningClients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        ButterKnife.bind(this);
        setupToolBar();
        setUpPlaningList();
    }

    private void setupToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
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

    public void setUpPlaningList() {

        DatabaseHelper database = DataBaseManager.getInstance(getApplicationContext()).getHelper();
        try {

            List<Client> clients = database.getClients().queryForAll();
            Log.v("ListClients size 0",clients.size() + "");
            PlanningAdapter planningAdapter = new PlanningAdapter(clients);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recPlanningClients.setLayoutManager(layoutManager);
            recPlanningClients.setItemAnimator(new DefaultItemAnimator());
            recPlanningClients.setAdapter(planningAdapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
