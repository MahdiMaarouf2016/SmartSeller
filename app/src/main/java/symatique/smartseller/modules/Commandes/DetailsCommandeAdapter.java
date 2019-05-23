package symatique.smartseller.modules.Commandes;

import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import symatique.smartseller.R;
import symatique.smartseller.data.DetailCommande;

public class DetailsCommandeAdapter extends RecyclerView.Adapter<DetailsCommandeAdapter.DetailCommandeItem> {

    @BindView(R.id.img_detailcommandeitem_imgarticle)
     ImageView imgDetailcommandeitemImgarticle;
    @BindView(R.id.txt_detailcommandeitem_libelarticle)
     TextView txtDetailcommandeitemLibelarticle;
    @BindView(R.id.txt_detailcommandeitem_datesynchro)
     TextView txtDetailcommandeitemDatesynchro;
    @BindView(R.id.txt_detailcommandeitem_categoritearticle)
     TextView txtDetailcommandeitemCategoritearticle;

    private List<DetailCommande> detailCommandes;

    public DetailsCommandeAdapter() {
        this.detailCommandes = new ArrayList<>();
    }

    public DetailsCommandeAdapter(List<DetailCommande> detailCommandes) {
        this.detailCommandes = detailCommandes;
    }

    @NonNull
    @Override
    public DetailCommandeItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_detailscommandeactivity_lignecommande, viewGroup, false);
        return new DetailCommandeItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailCommandeItem detailCommandeItem, int i) {
        DetailCommande detailCommande = detailCommandes.get(i);
        detailCommandeItem.clone(detailCommande);
    }

    @Override
    public int getItemCount() {
        return detailCommandes.size();
    }

    public class DetailCommandeItem extends RecyclerView.ViewHolder {

        public DetailCommandeItem(@NonNull View itemView) {
            super(itemView);
        }

        public void clone(DetailCommande detailCommande) {
            txtDetailcommandeitemCategoritearticle.setText(detailCommande.getLibelleCategorie());
            Date date = new Date(detailCommande.getDateSynchro());
            txtDetailcommandeitemDatesynchro.setText(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
            txtDetailcommandeitemLibelarticle.setText(detailCommande.getLibelle());
        }
    }
}
