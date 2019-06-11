package symatique.smartseller.modules.Client;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.modules.Panier.PanierActivity;
import symatique.smartseller.modules.Planning.PlanningAdapter;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;
import symatique.smartseller.utils.ClickListener;
import symatique.smartseller.utils.RecyclerTouchListener;

public class ClientsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.abl_planning) AppBarLayout ablPlanning;
    @BindView(R.id.rec_clients_listclient) RecyclerView recClientsListclient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);
        ButterKnife.bind(this);
        setupToolBar();
        setUpClientsList();
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

    private List<Client> getClients() {
        List<Client> clients = new ArrayList<>();

        try {
            DatabaseHelper database = DataBaseManager.getInstance(this).getHelper();
            clients = database.getClients().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void setUpClientsList() {

        final PlanningAdapter planningAdapter = new PlanningAdapter(getClients());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recClientsListclient.setLayoutManager(layoutManager);
        recClientsListclient.setItemAnimator(new DefaultItemAnimator());
        recClientsListclient.setAdapter(planningAdapter);

        recClientsListclient.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),
                        recClientsListclient, new ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent intent = new Intent(getBaseContext(), ProfileActivity.class);

                        intent.putExtra(ProfileActivity.KEY_EXTRA_CLIENT,planningAdapter.getClients().get(position));
                        startActivity(intent);
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        onClick(view, position);
                    }
                })
        );


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
