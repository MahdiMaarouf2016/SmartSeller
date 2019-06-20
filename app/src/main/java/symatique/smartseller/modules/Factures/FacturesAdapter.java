package symatique.smartseller.modules.Factures;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Factures.Facture;

import java.util.ArrayList;
import java.util.List;

public class FacturesAdapter extends RecyclerView.Adapter<FacturesAdapter.FactureItem> {

    private List<Facture> factures = null;
    private Facture selectedFacture = null;

    public FacturesAdapter() {
        factures = new ArrayList<>();
    }

    public FacturesAdapter(List<Facture> factures) {
        setFactures(factures);
    }

    public Facture getSelectedFacture() {
        return selectedFacture;
    }

    @NonNull
    @Override
    public FactureItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_factureractivity_facture, viewGroup, false);
        return new FacturesAdapter.FactureItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FactureItem factureItem, int i) {
        Facture facture = factures.get(i);
        factureItem.clone(facture);
    }

    @Override
    public int getItemCount() {
        return factures.size();
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
        notifyDataSetChanged();
    }

    public class FactureItem extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_factureitem_apayer)
        AppCompatTextView txtFactureitemApayer;
        @BindView(R.id.txt_factureitem_total)
        AppCompatTextView txtFactureitemTotal;
        @BindView(R.id.txt_factureitem_entreprise)
        AppCompatTextView txtFactureitemEntreprise;


        public FactureItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void clone(Facture facture) {
            txtFactureitemEntreprise.setText(facture.getLibelleEntreprise());
            txtFactureitemTotal.setText(facture.getMontantHT().toString());
            if (facture.getEncaissement() != null) {
                txtFactureitemApayer.setText("Payé");
                itemView.setBackgroundColor(itemView.getResources().getColor(R.color.white));
            }
            txtFactureitemApayer.setText(facture.getMontantHT().toString() + " TD");
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.setBackgroundColor(itemView.getResources().getColor(R.color.colorPrimary));
                    selectedFacture = facture;
                }
            });
        }
    }
}
