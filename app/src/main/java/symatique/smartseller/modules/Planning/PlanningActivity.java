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
import android.view.Menu;
import android.view.MenuItem;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.modules.Panier.PanierActivity;
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
        setUpDatePlanning();
        setUpPlaningList();
    }

    private void setupToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setUpDatePlanning(){
        txtPlanningDate.setText("Planning du : " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
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
            //Log.v("ListClients size 0",clients.size() + "");
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
