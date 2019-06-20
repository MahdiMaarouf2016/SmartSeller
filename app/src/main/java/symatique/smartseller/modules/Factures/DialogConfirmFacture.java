package symatique.smartseller.modules.Factures;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.utils.DialogResultDelegates;

public abstract class DialogConfirmFacture extends AlertDialog.Builder implements DialogResultDelegates {
    @butterknife.BindView(R.id.txt_confirmfacturedialog_totalHT)
    AppCompatTextView txtConfirmfacturedialogTotalHT;
    @butterknife.BindView(R.id.txt_confirmfacturedialog_totaltva)
    AppCompatTextView txtConfirmfacturedialogTotaltva;
    @butterknife.BindView(R.id.txt_confirmfacturedialog_totalTimbre)
    AppCompatTextView txtConfirmfacturedialogTotalTimbre;
    @butterknife.BindView(R.id.txt_confirmfacturedialog_totalTTC)
    AppCompatTextView txtConfirmfacturedialogTotalTTC;
    @butterknife.BindView(R.id.btn_confirmfacturedialog_passerfacture)
    AppCompatButton btnConfirmFacturedialogPasserFacture;
    @butterknife.BindView(R.id.btn_confirmfacturedialog_annulerfacture)
    AppCompatButton btnConfirmFacturedialogAnnulerfacture;
    private AlertDialog alertDialog = null;
    private double THT, TTVA, TT, TTC;

    public DialogConfirmFacture(Context context, double THT, double TTVA, double TT, double TTC) {
        super(context);
        setView(R.layout.dialog_confirm_facture);
        setCancelable(false);
        this.THT = THT;
        this.TTVA = TTVA;
        this.TTC = TTC;
        this.TT = TT;

    }

    public void setUpValues() {
        txtConfirmfacturedialogTotalHT.setText(String.valueOf(THT));
        txtConfirmfacturedialogTotalTTC.setText(String.valueOf(TTC));
        txtConfirmfacturedialogTotalTimbre.setText(String.valueOf(TT));
        txtConfirmfacturedialogTotaltva.setText(String.valueOf(TTVA));

    }

    @Override
    public AlertDialog show() {
        alertDialog = super.show();
        ButterKnife.bind(this, alertDialog);
        setUpValues();
        return alertDialog;
    }

    @OnClick(R.id.btn_confirmfacturedialog_passerfacture)
    public void btn_confirmfacturedialog_passerfactureOnClick() {
        OnAccepted();
        alertDialog.dismiss();
    }

    @OnClick(R.id.btn_confirmfacturedialog_annulerfacture)
    public void btnConfirmFacturedialogAnnulerfactureOnClick() {
        OnRejected();
        alertDialog.dismiss();
    }
}
