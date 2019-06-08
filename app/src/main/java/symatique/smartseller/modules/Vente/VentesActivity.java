package symatique.smartseller.modules.Vente;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import java.sql.SQLException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Client;
import symatique.smartseller.modules.Planning.PlanningAdapter;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.utils.ClickListener;
import symatique.smartseller.utils.RecyclerTouchListener;

public class VentesActivity extends AppCompatActivity {

    @BindView(R.id.edttxt_vente_search)
     AppCompatEditText edttxtVenteSearch;
    @BindView(R.id.btn_vente_clientpassage)
     AppCompatButton btnVenteClientpassage;
    @BindView(R.id.rec_vente_listclients)
     RecyclerView recVenteListclients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vente);
        ButterKnife.bind(this);
        setupToolBar();
        setUpClients();

    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setUpClients() {

        try {
            List<Client> clients = DataBaseManager.getInstance(getApplicationContext()).getHelper().getClients().queryForAll();
            PlanningAdapter planningAdapter = new PlanningAdapter(clients);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recVenteListclients.setLayoutManager(layoutManager);
            recVenteListclients.setItemAnimator(new DefaultItemAnimator());
            recVenteListclients.setAdapter(planningAdapter);
            recVenteListclients.addOnItemTouchListener(new RecyclerTouchListener(this,
                    recVenteListclients, new ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    DialogRapportVisite dialogRapportVisite = new DialogRapportVisite(view.getContext());
                    dialogRapportVisite.show();
                }

                @Override
                public void onLongClick(View view, int position) {
                    onClick(view, position);
                }
            }));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
