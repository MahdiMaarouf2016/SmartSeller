package symatique.smartseller.modules.Vente;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.Window;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.utils.DialogResultDelegates;

public abstract class DialogPrixQuantiteLivrison extends AlertDialog.Builder implements DialogResultDelegates {
    @BindView(R.id.txt_qteprixlayout_lablivrison) AppCompatTextView txtQteprixlayoutLablivrison;
    @BindView(R.id.edttxt_qteprixlayout_qtelivrison) AppCompatEditText edttxtQteprixlayoutQtelivrison;
    public AlertDialog alertDialog = null;
    @BindView(R.id.btn_qteprixlayout_ajouter) AppCompatButton btnQteprixlayoutAjouter;
    @BindView(R.id.edttxt_qteprixlayout_prixlivrison)
    AppCompatEditText edttxtQteprixlayoutPrixlivrison;
    private Packet workingPacket = null;

    public DialogPrixQuantiteLivrison(Context context, final Packet packet) {
        super(context);
        this.workingPacket = packet;
    }

    private void setWorkingPacket(final Packet packet) {
        txtQteprixlayoutLablivrison.setText(packet.getLibelleArticle());
        edttxtQteprixlayoutPrixlivrison.setText(packet.getPrixConsommateur().toString());
    }

    @Override
    public AlertDialog show() {
        setView(R.layout.dialog_vente_qteprix);
        alertDialog = super.show();
        ButterKnife.bind(this, alertDialog);
        setWorkingPacket(workingPacket);
        return alertDialog;
    }

    @OnClick(R.id.btn_qteprixlayout_ajouter)
    void BtnQteprixlayoutAjouterOnClick() {
        //if(workingPacket.setPri;)
        OnAccepted();
    }
}
