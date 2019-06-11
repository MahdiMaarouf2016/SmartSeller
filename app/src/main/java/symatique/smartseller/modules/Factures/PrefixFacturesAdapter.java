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
import symatique.smartseller.data.Factures.PrefixFacture;

public class PrefixFacturesAdapter extends RecyclerView.Adapter<PrefixFacturesAdapter.FactureItem> {

    private List<PrefixFacture> factures;

    public PrefixFacturesAdapter() {
        factures = new ArrayList<>();
    }

    public PrefixFacturesAdapter(List<PrefixFacture> factures) {
        this.factures = factures;
    }

    @NonNull
    @Override
    public FactureItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_prefixfacturefragment_prefixfacture, viewGroup, false);
        return new FactureItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FactureItem factureItem, int i) {
        PrefixFacture facture = factures.get(i);
        factureItem.clone(facture);
    }

    @Override
    public int getItemCount() {
        return factures.size();
    }

    public class FactureItem extends RecyclerView.ViewHolder {
        @BindView(R.id.img_prefixfacture_print)
        AppCompatImageView imgPrefixfacturePrint;
        @BindView(R.id.txt_prefixfacture_numero)
        AppCompatTextView txtPrefixfactureNumero;
        @BindView(R.id.txt_prefixfacture_client)
        AppCompatTextView txtPrefixfactureClient;
        @BindView(R.id.txt_prefixfacture_paie)
        AppCompatTextView txtPrefixfacturePaie;
        @BindView(R.id.txt_prefixfacture_valeur)
        AppCompatTextView txtPrefixfactureValeur;

        public FactureItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void clone(PrefixFacture facture) {
            txtPrefixfactureClient.setText(facture.getCodeClient());
            txtPrefixfactureNumero.setText(facture.getNumero());
            txtPrefixfacturePaie.setText(String.valueOf(facture.getMontantHT()));
            //txtPrefixfactureValeur
            imgPrefixfacturePrint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // PRINT FACURE ACTION
                }
            });

        }

    }
}