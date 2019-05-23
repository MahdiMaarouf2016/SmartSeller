package symatique.smartseller.modules.Vente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import symatique.smartseller.R;

public class CodesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codes);
        setupToolBar();
        setUpCodes();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_searchonly, menu);
        return true;
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setUpCodes(){
        /*ArrayList<Packet> codes = new ArrayList<>();
        Packet packet = new Packet();
        packet.setLibelle("Eau minirale");
        packet.setCodeArticle("1239884");
        packet.setQuantite(12);

        codes.add(packet);
        codes.add(packet);
        codes.add(packet);
        codes.add(packet);

        CodesAdapter codesAdapter = new CodesAdapter(codes);
        RecyclerView recyclerView = findViewById(R.id.rec_codes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(codesAdapter);*/
    }
}
