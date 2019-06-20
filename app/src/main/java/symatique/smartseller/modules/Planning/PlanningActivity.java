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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.data.Ventes.PlanificationVenteWS;
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

    public List<Client> getFiltredListClient() {
        List<Client> clients = getLitsClients();
        List<Client> filtredclients = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (!clients.isEmpty()) {
            for (Client client : clients) {
                PlanificationVenteWS planificationVenteWS = client.getPlanificationVenteWS();

                switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                    case 1:
                        if (planificationVenteWS.isDimanche()) filtredclients.add(client);
                        break;
                    case 2:
                        if (planificationVenteWS.isLundi()) filtredclients.add(client);
                        break;
                    case 3:
                        if (planificationVenteWS.isMardi()) filtredclients.add(client);
                        break;
                    case 4:
                        if (planificationVenteWS.isMercredi()) filtredclients.add(client);
                        break;
                    case 5:
                        if (planificationVenteWS.isJeudi()) filtredclients.add(client);
                        break;
                    case 6:
                        if (planificationVenteWS.isVendredi()) filtredclients.add(client);
                        break;
                    case 7:
                        if (planificationVenteWS.isSamedi()) filtredclients.add(client);
                        break;
                }
            }
        }

        return filtredclients;
    }

    private List<Client> getLitsClients() {
        List<Client> clients = new ArrayList<>();
        try {
            DatabaseHelper database = DataBaseManager.getInstance(getApplicationContext()).getHelper();
            clients = database.getClients().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return clients;
    }

    public void setUpPlaningList() {
        PlanningAdapter planningAdapter = new PlanningAdapter(getFiltredListClient());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recPlanningClients.setLayoutManager(layoutManager);
        recPlanningClients.setItemAnimator(new DefaultItemAnimator());
        recPlanningClients.setAdapter(planningAdapter);

    }

}
