package symatique.smartseller.modules.Client;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.modules.Vente.PanierClientActivity;
import symatique.smartseller.modules.Vente.PanierClientAdapter;

public class ProfileActivity extends AppCompatActivity {

    public static final String KEY_EXTRA_CLIENT = "CLIENT";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.abl_profile)
    AppBarLayout ablProfile;
    @BindView(R.id.textView10)
    AppCompatTextView textView10;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.lab_profileactivity_nature)
    AppCompatTextView labProfileactivityNature;

    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        setupToolBar();
        client = (Client) getIntent().getExtras().get(KEY_EXTRA_CLIENT);
        setUpClientProfile(client);
    }

    private void setupToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_panieroly, menu);
        return true;
    }

    private void setUpClientProfile(final Client client) {

        AppCompatTextView nt = findViewById(R.id.lab_profileactivity_nature);
        AppCompatTextView nom = findViewById(R.id.txt__profileactivity_nomprenom);
        AppCompatTextView code = findViewById(R.id.textView10);
        AppCompatTextView matf = findViewById(R.id.txt__profileactivity_matfisc);
        AppCompatTextView reg = findViewById(R.id.txt__profileactivity_regcom);
        AppCompatTextView mail = findViewById(R.id.txt__profileactivity_mail);
        AppCompatTextView tel = findViewById(R.id.txt__profileactivity_tel);
        AppCompatTextView etat = findViewById(R.id.txt__profileactivity_etat);
        nt.setText("Nature : " + client.getNature());
        nom.setText(client.getLibelle());
        code.setText(client.getCode());
        matf.setText("Matricule fiscale : " + client.getMatriculeFiscale());
        reg.setText("Registre de commerce : " + client.getRegistreCommerce());
        mail.setText("E-mail  : " + client.getEmail());
        tel.setText("Telephone : " + client.getGsm());
        etat.setText("Etat   : active");

    }

    @OnClick(R.id.btn__profileactivity_panier)
    public void OnClick() {
        Intent intent = new Intent(this, PanierClientActivity.class);
        intent.putExtra(PanierClientActivity.KEY_EXTRA_CLIENT, client);
        startActivity(intent);
    }

    @OnClick(R.id.btn_profileactivity_call)
    public void OnClick1() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + client.getGsm()));
        startActivity(intent);
    }
    /*


     */

}
