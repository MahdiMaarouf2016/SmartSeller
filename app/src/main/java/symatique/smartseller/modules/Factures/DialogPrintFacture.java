package symatique.smartseller.modules.Factures;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.utils.DialogResultDelegates;

import java.util.zip.Inflater;

public abstract class DialogPrintFacture extends AlertDialog.Builder implements DialogResultDelegates {

    @butterknife.BindView(R.id.img_printfacturedialog_printicon)
    AppCompatImageView imgPrintfacturedialogPrinticon;
    @butterknife.BindView(R.id.txt_printfacturedialog_labquestion)
    AppCompatTextView txtPrintfacturedialogLabquestion;
    @butterknife.BindView(R.id.btn_printfacturedialog_oneprint)
    AppCompatButton btnPrintfacturedialogOneprint;
    @butterknife.BindView(R.id.btn_printfacturedialog_towprint)
    AppCompatButton btnPrintfacturedialogTowprint;
    private AlertDialog alertDialog = null;
    public DialogPrintFacture(Context context) {
        super(context);
        setView(R.layout.dialog_print_facture);
        setCancelable(true);

    }

    @Override
    public AlertDialog show() {
        alertDialog = super.show();
        ButterKnife.bind(this, alertDialog);
        return alertDialog;
    }

    @OnClick(R.id.btn_printfacturedialog_oneprint)
    public void btnPrintfacturedialogOneprintOnClick() {
        Log.v("PRINT", "ONE FACTURE");
        OnAccepted();
    }

    @OnClick(R.id.btn_printfacturedialog_towprint)
    void btnPrintfacturedialogTowprint() {
        Log.v("PRINT", "TOW FACTURE");
        OnAccepted();
    }
}
