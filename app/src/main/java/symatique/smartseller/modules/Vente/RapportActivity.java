package symatique.smartseller.modules.Vente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Ventes.NatureVente;
import symatique.smartseller.data.Ventes.RapportVisite;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RapportActivity extends AppCompatActivity {
    public static final String KEY_EXTRA_CLIENT = "CLIENT";

    @BindView(R.id.btn_rapportactivity_valider) AppCompatButton btnrapportactivityvalider;
    @BindView(R.id.spinner_rapportactivity_motifs) AppCompatSpinner spinnerrapportactivitymotifs;
    @BindView(R.id.plantext_rapportactivity_description) MultiAutoCompleteTextView plantextrapportactivitydescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapport);
        ButterKnife.bind(this);
        setupToolBar();
        setUpMotifs();
        setUpDelegates();
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setUpDelegates(){
        btnrapportactivityvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RapportVisite rapportVisite = new RapportVisite();
                rapportVisite.setMessage(plantextrapportactivitydescription.getText().toString());
                rapportVisite.setDateVente(new Date().getTime());
                //? NOT ALL ,
                try {
                    DatabaseHelper database = DataBaseManager.getInstance(v.getContext()).getHelper();
                    database.getRapportVisites().create(rapportVisite);
                    Log.v("RAPPORT VISTE","INSERTED SUCCIFULLY");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public List<NatureVente> getListNatureVente() {
        List<NatureVente> natureVentes = new ArrayList<>();

        try{
            DatabaseHelper database = DataBaseManager.getInstance(this).getHelper();
            natureVentes = database.getNatureVentes().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return natureVentes;
    }

    private void setUpMotifs() {
        List<String> motifs = new ArrayList<>();
        List<NatureVente> natureVentes = getListNatureVente();
        if(!natureVentes.isEmpty()){
            for(NatureVente natureVente:natureVentes)
                motifs.add(natureVente.getLibelle());
        }else{
            motifs.add("Autre");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, motifs);//setting the country_array to spinner
        spinnerrapportactivitymotifs.setAdapter(adapter);
    }


}
