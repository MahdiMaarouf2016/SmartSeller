package symatique.smartseller.modules.Vente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import symatique.smartseller.R;

public class CreateVenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_vente);
        setupToolBar();
        setUpVentes();
        setUpEvents();

    }
    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void setUpVentes(){

        /*ArrayList<Packet> ventes = new ArrayList<>();
        Packet packet = new Packet();
        packet.setLibelle("Eau minirale");
        packet.setCodeArticle("1239884");
        packet.setQuantite(12);

        ventes.add(packet);
        ventes.add(packet);
        ventes.add(packet);
        ventes.add(packet);

        VenteAdapter venteAdapter = new VenteAdapter(ventes);

        RecyclerView recyclerView = findViewById(R.id.rec_ventes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(venteAdapter);
        */
    }

    private void setUpEvents(){
        AppCompatButton button = findViewById(R.id.btn_code);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),CodesActivity.class);
                startActivity(intent);
            }
        });
        AppCompatButton button1 = findViewById(R.id.btn_fact_facturer);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(getBaseContext(),Fa.class);
                //startActivity(intent);
            }
        });
    }

}
