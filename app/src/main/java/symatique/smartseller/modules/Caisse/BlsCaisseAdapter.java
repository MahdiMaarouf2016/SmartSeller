package symatique.smartseller.modules.Caisse;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import symatique.smartseller.R;
import symatique.smartseller.data.PrefixBL;

public class BlsCaisseAdapter extends RecyclerView.Adapter<BlsCaisseAdapter.BlCaisseItem> {

    @BindView(R.id.txt_caisseblitem_numero)
     AppCompatTextView txtCaisseblitemNumero;
    @BindView(R.id.txt_caisseblitem_client)
     AppCompatTextView txtCaisseblitemClient;
    @BindView(R.id.txt_caisseblitem_valeur)
     AppCompatTextView txtCaisseblitemValeur;
    @BindView(R.id.txt_caisseblitem_paie)
     AppCompatTextView txtCaisseblitemPaie;
    @BindView(R.id.imgbtn_caisseblitem_print)
     AppCompatImageButton imgbtnCaisseblitemPrint;

    private List<PrefixBL> prefixBLS;

    public BlsCaisseAdapter(List<PrefixBL> prefixBLS) {
        this.prefixBLS = prefixBLS;
    }

    public BlsCaisseAdapter() {
        this.prefixBLS = new ArrayList<>();
    }

    @NonNull
    @Override
    public BlCaisseItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_caissesblfragment_bl, viewGroup, false);
        return new BlCaisseItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BlCaisseItem blCaisseItem, int i) {
        blCaisseItem.clone(prefixBLS.get(i));
    }

    @Override
    public int getItemCount() {
        return prefixBLS.size();
    }

    public class BlCaisseItem extends RecyclerView.ViewHolder {

        public BlCaisseItem(@NonNull View itemView) {
            super(itemView);
        }

        public void clone(PrefixBL prefixBL) {
            txtCaisseblitemClient.setText(prefixBL.getClient().getNom());
            txtCaisseblitemNumero.setText(prefixBL.getNumero());
            //txtCaisseblitemPaie.setText(prefixBL.);
            //txtCaisseblitemValeur

            imgbtnCaisseblitemPrint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // PRINT DELEGATE ACTION IS HERE
                    
                }
            });
        }
    }
}
