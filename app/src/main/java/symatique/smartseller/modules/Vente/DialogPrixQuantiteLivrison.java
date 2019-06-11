package symatique.smartseller.modules.Vente;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.Window;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.utils.DialogResultDelegates;

public abstract class DialogPrixQuantiteLivrison extends AppCompatDialog implements DialogResultDelegates {
    @BindView(R.id.txt_qteprixlayout_lablivrison) AppCompatTextView txtQteprixlayoutLablivrison;
    @BindView(R.id.btn_qteprixlayout_qtemoin) AppCompatButton btnQteprixlayoutQtemoin;
    @BindView(R.id.edttxt_qteprixlayout_qtelivrison) AppCompatEditText edttxtQteprixlayoutQtelivrison;
    @BindView(R.id.btn_qteprixlayout_qteplus) AppCompatButton btnQteprixlayoutQteplus;
    @BindView(R.id.edttxt_qteprixlayout_prixlivrison) AppCompatTextView edttxtQteprixlayoutPrixlivrison;
    @BindView(R.id.btn_qteprixlayout_ajouter) AppCompatButton btnQteprixlayoutAjouter;
    private Packet workingPacket;

    public DialogPrixQuantiteLivrison(Context context,final Packet packet) {
        super(context);
        setUpView();
        setWorkingPacket(packet);
        setUpDelegates();
    }

    private void setWorkingPacket(final  Packet packet){
        this.workingPacket = packet;
        txtQteprixlayoutLablivrison.setText(packet.getLibelleArticle());
    }
    void setUpView() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_vente_qteprix);
        ButterKnife.bind(this);
    }

    void setUpDelegates() {
        btnQteprixlayoutQteplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentqte = Integer.parseInt(edttxtQteprixlayoutQtelivrison.getText().toString()) + 1;
                if(workingPacket.getQuantite() >= currentqte)edttxtQteprixlayoutQtelivrison.setText( String.valueOf( currentqte ) );
            }
        });
        btnQteprixlayoutQtemoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentqte = Integer.parseInt(edttxtQteprixlayoutQtelivrison.getText().toString()) - 1;
                if( currentqte >= 0 ) edttxtQteprixlayoutQtelivrison.setText( String.valueOf(currentqte) );

            }
        });

        btnQteprixlayoutAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnAccepted();
            }
        });
    }
}
