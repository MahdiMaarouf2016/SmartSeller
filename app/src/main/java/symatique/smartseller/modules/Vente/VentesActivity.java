package symatique.smartseller.modules.Vente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import symatique.smartseller.R;
import symatique.smartseller.data.Articles.Article;
import symatique.smartseller.data.Ventes.Client;
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
        setUpClients(getClients());
    }

    @OnTextChanged(R.id.edttxt_vente_search)
    public void edttxtProduitsFindarticleOnTextChanged() {
        String findWord = edttxtVenteSearch.getText().toString().toLowerCase();

        if (findWord.isEmpty()) {
            setUpClients(getClients());
        } else {
            List<Client> clients = getClients();
            List<Client> filtredClients = new ArrayList<>();
            for (Client client : clients) {
                if (client.getLibelle().toLowerCase().contains(findWord)) filtredClients.add(client);
            }
            setUpClients(filtredClients);
        }
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        try {
            clients = DataBaseManager.getInstance(getApplicationContext()).getHelper().getClients().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void setUpClients(List<Client> clients) {

        if (!clients.isEmpty()) {
            final PlanningAdapter planningAdapter = new PlanningAdapter(clients);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recVenteListclients.setLayoutManager(layoutManager);
            recVenteListclients.setItemAnimator(new DefaultItemAnimator());
            recVenteListclients.setAdapter(planningAdapter);
            recVenteListclients.addOnItemTouchListener(new RecyclerTouchListener(this,
                    recVenteListclients, new ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    final Client client = planningAdapter.getClients().get(position);
                    DialogRapportVisite dialogRapportVisite = new DialogRapportVisite(view.getContext()) {
                        @Override
                        public void OnAccepted() {
                            Intent intent = new Intent(getContext(), RapportActivity.class);
                            intent.putExtra(RapportActivity.KEY_EXTRA_CLIENT, client);
                            getContext().startActivity(intent);
                        }

                        @Override
                        public void OnRejected() {
                            Intent intent = new Intent(getContext(), PanierClientActivity.class);
                            intent.putExtra(PanierClientActivity.KEY_EXTRA_CLIENT, client);
                            getContext().startActivity(intent);
                        }
                    };
                    dialogRapportVisite.show();
                }

                @Override
                public void onLongClick(View view, int position) {
                    onClick(view, position);
                }
            }));
        }
    }

    @OnClick(R.id.btn_vente_clientpassage)
    public void btnVenteClientpassageOnClick() {
        Intent intent = new Intent(this, AjouterClient.class);
        startActivity(intent);
    }

}
