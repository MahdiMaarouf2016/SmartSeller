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
import symatique.smartseller.data.PrefixFacture;

public class FacturesCaisseAdapter extends RecyclerView.Adapter<FacturesCaisseAdapter.FactureCaisseItem> {

    @BindView(R.id.txt_caissefactureitem_numero)
     AppCompatTextView txtCaissefactureitemNumero;
    @BindView(R.id.txt_caissefactureitem_client)
     AppCompatTextView txtCaissefactureitemClient;
    @BindView(R.id.txt_caissefactureitem_valeur)
     AppCompatTextView txtCaissefactureitemValeur;
    @BindView(R.id.txt_caissefactureitem_paie)
     AppCompatTextView txtCaissefactureitemPaie;
    @BindView(R.id.txt_caissefactureitem_numbl)
     AppCompatTextView txtCaissefactureitemNumbl;
    @BindView(R.id.imgbtn_caissefactureitem_print)
     AppCompatImageButton imgbtnCaissefactureitemPrint;

    private List<PrefixFacture> prefixFactures;

    public FacturesCaisseAdapter(List<PrefixFacture> prefixFactures) {
        this.prefixFactures = prefixFactures;
    }

    public FacturesCaisseAdapter() {
        prefixFactures = new ArrayList<>();
    }

    @NonNull
    @Override
    public FactureCaisseItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_caissesfacturesfragment_facture, viewGroup, false);
        return new FactureCaisseItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FactureCaisseItem factureCaisseItem, int i) {
        factureCaisseItem.clone(prefixFactures.get(i));
    }

    @Override
    public int getItemCount() {
        return prefixFactures.size();
    }

    public class FactureCaisseItem extends RecyclerView.ViewHolder {

        public FactureCaisseItem(@NonNull View itemView) {
            super(itemView);
        }

        public void clone(PrefixFacture prefixFacture) {
            txtCaissefactureitemClient.setText(prefixFacture.getCodeClient());
            txtCaissefactureitemNumbl.setText(prefixFacture.getNumeroFact());
            //txt
            //
            imgbtnCaissefactureitemPrint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // PRINT DELAGETE ACTION IS HERE
                }
            });
        }
    }
}
