package symatique.smartseller.modules.Panier;

import android.support.annotation.NonNull;
import android.support.constraint.Guideline;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Article;
import symatique.smartseller.data.CategorieArticle;
import symatique.smartseller.services.SQLiteService.DataBaseManager;

public class PanierAdapter extends RecyclerView.Adapter<PanierAdapter.PanierItem> {



    private List<PanierItem.PanierPacket> panierElements = null;

    public PanierAdapter() {
        this.panierElements = new ArrayList<>();
    }

    public PanierAdapter(List<PanierItem.PanierPacket> panierElements) {
        setPanierElements(panierElements);
    }

    public List<PanierItem.PanierPacket> getPanierElements() {
        return panierElements;
    }

    public void setPanierElements(List<PanierItem.PanierPacket> panierElements) {
        this.panierElements = panierElements;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PanierItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_panieractivity_panier, viewGroup, false);
        return new PanierItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PanierItem panierItem, int i) {
        PanierItem.PanierPacket panierPacket = panierElements.get(i);
        panierItem.clone(panierPacket);
    }

    @Override
    public int getItemCount() {
        return panierElements.size();
    }

    public class PanierItem extends RecyclerView.ViewHolder {

        @BindView(R.id.img_panieritem_prodbackimg)
        AppCompatImageView imgPanieritemProdbackimg;
        @BindView(R.id.txt_panieritiem_prodlibelle)
        AppCompatTextView txtPanieritiemProdlibelle;
        @BindView(R.id.txt_produitiem_prodcode)
        AppCompatTextView txtProduitiemProdcode;
        @BindView(R.id.txt_panieritiem_categorie)
        AppCompatTextView txtPanieritiemCategorie;
        @BindView(R.id.txt_panieritiem_prix)
        AppCompatTextView txtPanieritiemPrix;
        @BindView(R.id.btn_panieritiem_plus)
        AppCompatButton btnPanieritiemPlus;
        @BindView(R.id.txtedit_panieritiem_prodqte)
        TextInputEditText txteditPanieritiemProdqte;
        @BindView(R.id.btn_panieritiem_moin)
        AppCompatButton btnPanieritiemMoin;
        @BindView(R.id.linearLayoutCompat)
        LinearLayoutCompat linearLayoutCompat;
        @BindView(R.id.fab_panier_delete)
        FloatingActionButton fabPanierDelete;
        @BindView(R.id.guideline7)
        Guideline guideline7;

        public PanierItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void clone(final PanierPacket panierPacket) {

            txteditPanieritiemProdqte.setText(String.valueOf(panierPacket.getQuantite()));
            txtPanieritiemCategorie.setText(panierPacket.getArticle().getLibelleArb());
            txtPanieritiemPrix.setText(String.valueOf(panierPacket.getArticle().getPromoUnitaire()));
            txtProduitiemProdcode.setText(panierPacket.getArticle().getCode());
            txtPanieritiemProdlibelle.setText(panierPacket.getArticle().getLibelle());

            btnPanieritiemPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double currenqte = Integer.parseInt(txteditPanieritiemProdqte.getText().toString());
                    txteditPanieritiemProdqte.setText(String.valueOf(currenqte + 1));
                }
            });
            btnPanieritiemMoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double currenqte = Integer.parseInt(txteditPanieritiemProdqte.getText().toString());
                    if(currenqte - 1 >= 0)txteditPanieritiemProdqte.setText(String.valueOf(currenqte - 1));
                }
            });

            fabPanierDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(panierElements.remove(panierPacket)){
                        setPanierElements(panierElements);
                    }
                }
            });

        }

        public class PanierPacket implements Serializable {

            private long quantite;
            private Article article;
            public PanierPacket() {

            }

            public long getQuantite() {
                return quantite;
            }

            public Article getArticle() {
                return article;
            }

            public void setQuantite(long quantite) {
                this.quantite = quantite;
            }

            public void setArticle(Article article) {
                this.article = article;
            }
        }

    }

}
