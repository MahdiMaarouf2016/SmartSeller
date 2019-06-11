package symatique.smartseller.modules.Factures;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Window;
import butterknife.ButterKnife;
import symatique.smartseller.R;

public class DialogConfirmFacture extends AppCompatDialog {
    public DialogConfirmFacture(Context context) {
        super(context);
        setUpView();
    }
    void setUpView() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_confirm_facture);
    }
}
