package symatique.smartseller.modules.Vente;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.Window;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.utils.DialogResultDelegates;

// + ************** GOOOD NOTES ************
// USE OVERRITE METHODE "CREATE()"
// - ************** GOOOD NOTES ************

public abstract class DialogRapportVisite extends AlertDialog.Builder implements DialogResultDelegates {
    @BindView(R.id.btn_rapporvistdialog_vente) AppCompatButton btnRapporvistdialogVente;
    @BindView(R.id.btn_rapporvistdialog_rapport) AppCompatButton btnRapporvistdialogRapport;

    private AlertDialog alertDialog = null;

    public DialogRapportVisite(Context context) {
        super(context);
    }

    @Override
    public AlertDialog show() {
        setView(R.layout.dialog_venteactivity_rapportvisite);
        alertDialog = super.show();
        ButterKnife.bind(this, alertDialog);
        return alertDialog;
    }

    @OnClick(R.id.btn_rapporvistdialog_vente)
    public void btnRapporvistdialogVenteOnClick() {
        OnRejected();
        alertDialog.dismiss();
    }

    @OnClick(R.id.btn_rapporvistdialog_rapport)
    public void btnRapporvistdialogRapportOnClick() {
        OnAccepted();
        alertDialog.dismiss();
    }

}
