package symatique.smartseller.modules.Factures;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Factures.PrefixBL;

public class PrefixBlsAdapter extends RecyclerView.Adapter<PrefixBlsAdapter.PrefixBlItem> {

    private List<PrefixBL> prefixBLS;

    public PrefixBlsAdapter(List<PrefixBL> prefixBLS) {
        this.prefixBLS = prefixBLS;
    }

    public PrefixBlsAdapter() {
        this.prefixBLS = new ArrayList<>();
    }

    @NonNull
    @Override
    public PrefixBlItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_prefixblfragment_prefixbl, viewGroup, false);
        return new PrefixBlItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PrefixBlItem blItem, int i) {
        PrefixBL prefixBL = prefixBLS.get(i);
        blItem.clone(prefixBL);
    }

    @Override
    public int getItemCount() {
        return prefixBLS.size();
    }

    public class PrefixBlItem extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_prefixblitem_numero)
        AppCompatTextView txtPrefixblitemNumero;
        @BindView(R.id.txt_prefixblitem_client)
        AppCompatTextView txtPrefixblitemClient;
        @BindView(R.id.txt_prefixblitem_valeur)
        AppCompatTextView txtPrefixblitemValeur;
        @BindView(R.id.txt_prefixblitem_paie)
        AppCompatTextView txtPrefixblitemPaie;
        @BindView(R.id.img_prefixblitem_print)
        AppCompatImageView imgPrefixblitemPrint;

        public PrefixBlItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void clone(PrefixBL prefixBL) {
            txtPrefixblitemClient.setText("PAS ENCORE PROGRAAME");
            txtPrefixblitemNumero.setText(prefixBL.getNumero());
            //txtPrefixblitemPaie.setText(prefixBL.);
            //txtPrefixblitemValeur.setText(prefixBL.getNumeroFact());
            imgPrefixblitemPrint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // PRINT BL ACTION
                }
            });
        }
    }
}
