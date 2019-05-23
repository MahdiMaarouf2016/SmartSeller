package symatique.smartseller.modules.Vente;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.Window;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.RapportVisite;

public class DialogRapportVisite extends AppCompatDialog {
    @BindView(R.id.btn_rapporvistdialog_vente)
     AppCompatButton btnRapporvistdialogVente;
    @BindView(R.id.btn_rapporvistdialog_rapport)
     AppCompatButton btnRapporvistdialogRapport;

    public DialogRapportVisite(Context context) {
        super(context);
        setUpView();
        setUpDelegates();
    }

    void setUpView() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_venteactivity_rapportvisite);
        ButterKnife.bind(this);
    }

    void setUpDelegates(){
        btnRapporvistdialogRapport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),RapportVisite.class);
                getContext().startActivity(intent);
            }
        });
        btnRapporvistdialogVente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CreateVenteActivity.class);
                getContext().startActivity(intent);
            }
        });

    }
}
