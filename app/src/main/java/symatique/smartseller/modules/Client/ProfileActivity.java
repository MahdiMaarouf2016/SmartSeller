package symatique.smartseller.modules.Client;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Ventes.Client;

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
    @BindView(R.id.textView14)
    AppCompatTextView textView14;
    @BindView(R.id.textView15)
    AppCompatTextView textView15;
    @BindView(R.id.textView16)
    AppCompatTextView textView16;
    @BindView(R.id.tableLayout2)
    TableLayout tableLayout2;
    @BindView(R.id.constraintLayout2)
    ConstraintLayout constraintLayout2;
    @BindView(R.id.textView8)
    AppCompatTextView textView8;
    @BindView(R.id.imageView2)
    AppCompatImageView imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        setupToolBar();
    }

    private void setupToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpClientProfile((Client) getIntent().getExtras().get(KEY_EXTRA_CLIENT));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_panieroly, menu);
        return true;
    }

    private void setUpClientProfile(final Client client) {
        Log.e("CLIENT PROFILE", client.getLibelle() + client.getCode());
    }

}
