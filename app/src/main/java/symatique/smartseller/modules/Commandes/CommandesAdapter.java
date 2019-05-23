package symatique.smartseller.modules.Commandes;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import symatique.smartseller.R;
import symatique.smartseller.data.Commande;

public class CommandesAdapter extends RecyclerView.Adapter<CommandesAdapter.CommandeItem> {

    @BindView(R.id.txt_commandeitem_numero)
     AppCompatTextView txtCommandeitemNumero;
    @BindView(R.id.txt_commandeitem_etat)
     AppCompatTextView txtCommandeitemEtat;
    @BindView(R.id.txt_commandeitem_datesynchro)
     AppCompatTextView txtCommandeitemDatesynchro;
    @BindView(R.id.txt_commandeitem_montant)
     AppCompatTextView txtCommandeitemMontant;
    @BindView(R.id.fab_commandeitem_goprofile)
     FloatingActionButton fabCommandeitemGoprofile;
    private List<Commande> commandes;

    public CommandesAdapter() {
        this.commandes = new ArrayList<>();
    }

    public CommandesAdapter(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @NonNull
    @Override
    public CommandeItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_activiycommandes_commande, viewGroup, false);
        return new CommandeItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommandeItem commandeItem, int i) {
        Commande commande = commandes.get(i);
        commandeItem.clone(commande);
    }

    @Override
    public int getItemCount() {
        return this.commandes.size();
    }

    public class CommandeItem extends RecyclerView.ViewHolder {
        private View itemView;

        public CommandeItem(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void clone(final Commande commande) {
            txtCommandeitemNumero.setText(commande.getNumero());
            Date date = new Date(commande.getDateSynch());
            txtCommandeitemDatesynchro.setText(date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
            txtCommandeitemEtat.setText(commande.getEtatCommande().getLibelle());
            txtCommandeitemMontant.setText(commande.getMontantHT().toString());
            fabCommandeitemGoprofile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),DetailCommandeActivity.class);
                    intent.putExtra("Commande",commande);
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
