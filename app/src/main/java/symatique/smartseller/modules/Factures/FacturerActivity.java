package symatique.smartseller.modules.Factures;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;

public class FacturerActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.abl_creatvte)
    AppBarLayout ablCreatvte;
    @BindView(R.id.textView27)
    AppCompatTextView textView27;
    @BindView(R.id.textView28)
    AppCompatTextView textView28;
    @BindView(R.id.textView26)
    AppCompatTextView textView26;
    @BindView(R.id.linearLayout8)
    LinearLayoutCompat linearLayout8;
    @BindView(R.id.linearLayoutCompat3)
    LinearLayoutCompat linearLayoutCompat3;
    @BindView(R.id.rec_facturesactivity_listpayementclient)
    RecyclerView recFacturesactivityListpayementclient;
    @BindView(R.id.constraintLayout4)
    ConstraintLayout constraintLayout4;
    @BindView(R.id.constraintLayout9)
    ConstraintLayout constraintLayout9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturer);
        ButterKnife.bind(this);
        setupToolBar();
    }

    private void setupToolBar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
