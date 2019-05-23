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

public class DialogPrixQuantiteLivrison extends AppCompatDialog {
    @BindView(R.id.txt_qteprixlayout_lablivrison)
     AppCompatTextView txtQteprixlayoutLablivrison;
    @BindView(R.id.btn_qteprixlayout_qtemoin)
     AppCompatButton btnQteprixlayoutQtemoin;
    @BindView(R.id.edttxt_qteprixlayout_qtelivrison)
     AppCompatEditText edttxtQteprixlayoutQtelivrison;
    @BindView(R.id.btn_qteprixlayout_qteplus)
     AppCompatButton btnQteprixlayoutQteplus;
    @BindView(R.id.edttxt_qteprixlayout_prixlivrison)
     AppCompatTextView edttxtQteprixlayoutPrixlivrison;
    @BindView(R.id.btn_qteprixlayout_ajouter)
     AppCompatButton btnQteprixlayoutAjouter;

    public DialogPrixQuantiteLivrison(Context context) {
        super(context);
    }

    void setUpView() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.layout_vente_qteprix);
        ButterKnife.bind(this);
    }

    void setUpDelegates() {
        btnQteprixlayoutQteplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double currentqte = Double.parseDouble(edttxtQteprixlayoutQtelivrison.getText().toString());
                edttxtQteprixlayoutQtelivrison.setText( String.valueOf( currentqte + 1 ) );
            }
        });
        btnQteprixlayoutQtemoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double currentqte = Double.parseDouble(edttxtQteprixlayoutQtelivrison.getText().toString());
                if( currentqte - 1 >= 0 ) edttxtQteprixlayoutQtelivrison.setText( String.valueOf(currentqte - 1) );
            }
        });
    }
}
