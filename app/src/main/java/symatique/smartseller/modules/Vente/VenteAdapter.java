package symatique.smartseller.modules.Vente;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import symatique.smartseller.R;

public class VenteAdapter extends RecyclerView.Adapter<VenteAdapter.VenteItem> {
    //ArrayList<Packet> ventes;


    public VenteAdapter() {
    }

    @NonNull
    @Override
    public VenteItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_ventesactivity_vente, viewGroup, false);

        return new VenteItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VenteItem venteItem, int i) {
        //Packet vente = ventes.get(i);
        //venteItem.clone(vente);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VenteItem extends RecyclerView.ViewHolder {
        public VenteItem(@NonNull View itemView) {
            super(itemView);
        }

    /*public void clone(Packet vente) {

        AppCompatTextView textView = itemView.findViewById(R.id.txt_venterow_code);
        AppCompatTextView textView1 = itemView.findViewById(R.id.txt_venterow_prod);
        AppCompatTextView textView2 = itemView.findViewById(R.id.txt_venterow_qte);

        textView.setText(vente.getCodeArticle());
        textView1.setText(vente.getLibelleArticle());
        textView2.setText(String.valueOf(vente.getQuantite()));
    }*/
    }

}
