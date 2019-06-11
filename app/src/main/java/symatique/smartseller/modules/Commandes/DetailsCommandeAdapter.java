package symatique.smartseller.modules.Commandes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Commandes.LigneCommande;

public class DetailsCommandeAdapter extends RecyclerView.Adapter<DetailsCommandeAdapter.DetailCommandeItem> {

    private List<LigneCommande> ligneCommandes;

    public DetailsCommandeAdapter() {
        this.ligneCommandes = new ArrayList<>();
    }

    public DetailsCommandeAdapter(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
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
        LigneCommande ligneCommande = ligneCommandes.get(i);
        detailCommandeItem.clone(ligneCommande);
    }

    @Override
    public int getItemCount() {
        return ligneCommandes.size();
    }

    public class DetailCommandeItem extends RecyclerView.ViewHolder {

        @BindView(R.id.img_detailcommandeitem_imgarticle) ImageView imgDetailcommandeitemImgarticle;
        @BindView(R.id.txt_detailcommandeitem_libelarticle) TextView txtDetailcommandeitemLibelarticle;
        @BindView(R.id.txt_detailcommandeitem_montant) TextView txtDetailcCommandeitemMontant;
        @BindView(R.id.txt_detailcommandeitem_categoritearticle) TextView txtDetailcommandeitemCategoritearticle;

        public DetailCommandeItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void clone(LigneCommande ligneCommande) {
            //? photo
            txtDetailcommandeitemCategoritearticle.setText(ligneCommande.getLibelleCategorie());
            txtDetailcCommandeitemMontant.setText(ligneCommande.getPrixTotal().toString());
            txtDetailcommandeitemLibelarticle.setText(ligneCommande.getLibelle());
        }
    }
}
