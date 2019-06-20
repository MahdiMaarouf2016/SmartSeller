package symatique.smartseller.modules.Panier;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import symatique.smartseller.R;
import symatique.smartseller.bases.RetrofitBases;
import symatique.smartseller.data.Articles.Article;
import symatique.smartseller.data.Commandes.Commande;
import symatique.smartseller.data.Commandes.LigneCommande;
import symatique.smartseller.modules.Authentification.AuthentificationActivity;
import symatique.smartseller.modules.Produits.ProduitsActivity;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;
import symatique.smartseller.utils.AdapterDelegates;

import static java.lang.Math.round;

public class PanierAdapter extends RecyclerView.Adapter<PanierAdapter.PanierItem> {

    private List<PanierPacket> panierElements = null;

    private AdapterDelegates adapterDelegates;

    public AdapterDelegates getAdapterDelegates() {
        return adapterDelegates;
    }

    public void setAdapterDelegates(AdapterDelegates adapterDelegates) {
        this.adapterDelegates = adapterDelegates;
    }

    public PanierAdapter() {

        adapterDelegates = new AdapterDelegates() {
            @Override
            public void OnPanierPacketInserted(Object object) {
                Log.v("OnPanierPacketInserted", "EMPTY");
            }

            @Override
            public void OnPanierPacketDeleted(Object object) {
                Log.v("OnPanierPacketDeleted", "EMPTY");
            }

            @Override
            public void OnPanierPacketUpdated(Object object) {
                Log.v("OnPanierPacketUpdated", "EMPTY");
            }

            @Override
            public void OnInitializedAdapter(List objects) {
                Log.v("OnInitializedAdapter", "EMPTY");
            }
        };
        this.panierElements = new ArrayList<>();
        setPanierElements(panierElements);
    }


    public long getTotalQuantite() {
        long totalQuantite = 0;
        for (PanierPacket panierPacket : panierElements) {
            totalQuantite += panierPacket.getQuantite();
        }

        return totalQuantite;
    }

    public double getTotalCommande() {
        double totalCommande = 0.000d;
        for (PanierPacket panierPacket : panierElements) {
            totalCommande += panierPacket.getArticle().getPrixRevendeur().doubleValue() * panierPacket.getQuantite();
        }
        return round(totalCommande, 3);
    }

    public static double round(final double value,final int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        long tmp = Math.round(value * factor);
        return (double) tmp / factor;
    }

    public void setPanierElements(List<PanierPacket> panierElements) {
        this.panierElements = panierElements;
        notifyDataSetChanged();
        this.adapterDelegates.OnInitializedAdapter(panierElements);
    }

    public void ajouterArticle(final Article article, final long quantite) {
        PanierPacket panierPacket = getPacketByArticle(article);
        if (panierPacket == null) {
            panierPacket = new PanierPacket(article, quantite);
            panierElements.add(panierPacket);
            notifyDataSetChanged();
            this.adapterDelegates.OnPanierPacketInserted(null);

        } else {
            panierPacket.setQuantite(panierPacket.getQuantite() + quantite);
            this.adapterDelegates.OnPanierPacketUpdated(panierPacket);
        }

        setPanierElements(panierElements);
    }

    public List<PanierPacket> getPanierElements() {
        return panierElements;
    }

    public void retirerArticle(final Article article) {
        PanierPacket panierPacket = getPacketByArticle(article);
        if (panierPacket != null) {
            panierElements.remove(panierPacket);
            notifyDataSetChanged();
            this.adapterDelegates.OnPanierPacketDeleted(panierPacket);
        }

        setPanierElements(panierElements);
    }

    public PanierPacket getPacketByArticle(final Article article) {
        PanierPacket panierPacket = null;
        for (PanierPacket panierPack1 : panierElements) {
            if (panierPack1.getArticle().equals(article)) {
                panierPacket = panierPack1;
                break;
            }
        }
        return panierPacket;
    }

    public boolean hasArticle(final Article article) {
        boolean find = false;
        for (PanierPacket panierPack : panierElements) {
            if (panierPack.getArticle().equals(article)) {
                find = true;
                break;
            }
        }
        return find;
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
        PanierPacket panierPacket = panierElements.get(i);
        panierItem.clone(panierPacket);
    }

    @Override
    public int getItemCount() {
        return panierElements.size();
    }

    public class PanierItem extends RecyclerView.ViewHolder {

        @BindView(R.id.img_panieritem_prodbackimg) AppCompatImageView imgPanieritemProdbackimg;
        @BindView(R.id.txt_panieritiem_prodlibelle) AppCompatTextView txtPanieritiemProdlibelle;
        @BindView(R.id.txt_produitiem_prodcode) AppCompatTextView txtProduitiemProdcode;
        @BindView(R.id.txt_panieritiem_categorie) AppCompatTextView txtPanieritiemCategorie;
        @BindView(R.id.txt_panieritiem_prix) AppCompatTextView txtPanieritiemPrix;
        @BindView(R.id.btn_panieritiem_plus) AppCompatButton btnPanieritiemPlus;
        @BindView(R.id.txtedit_panieritiem_prodqte) TextInputEditText txteditPanieritiemProdqte;
        @BindView(R.id.btn_panieritiem_moin) AppCompatButton btnPanieritiemMoin;
        @BindView(R.id.fab_panier_delete) FloatingActionButton fabPanierDelete;

        public PanierItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void clone(final PanierPacket panierPacket) {

            txteditPanieritiemProdqte.setText(String.valueOf(panierPacket.getQuantite()));
            txtPanieritiemCategorie.setText(panierPacket.getArticle().getLibelleCategorie());
            txtPanieritiemPrix.setText(String.valueOf(panierPacket.getArticle().getPrixRevendeur()) + " TD");
            txtProduitiemProdcode.setText(panierPacket.getArticle().getCode());
            txtPanieritiemProdlibelle.setText(panierPacket.getArticle().getLibelle());
            Picasso.get().load(RetrofitBases.BASE_URL + "/SmartSeller" + panierPacket.getArticle().getPhoto1()).into(imgPanieritemProdbackimg);
            btnPanieritiemPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int currenqte = Integer.parseInt(txteditPanieritiemProdqte.getText().toString());
                    txteditPanieritiemProdqte.setText(String.valueOf(currenqte + 1));
                    panierPacket.setQuantite(currenqte);
                    adapterDelegates.OnPanierPacketUpdated(panierPacket);
                }
            });
            btnPanieritiemMoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int currenqte = Integer.parseInt(txteditPanieritiemProdqte.getText().toString());
                    if (currenqte - 1 >= 0) {
                        txteditPanieritiemProdqte.setText(String.valueOf(currenqte - 1));
                        panierPacket.setQuantite(currenqte);
                        adapterDelegates.OnPanierPacketUpdated(panierPacket);
                    }
                }
            });

            fabPanierDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (panierElements.remove(panierPacket)) {
                        setPanierElements(panierElements);
                        adapterDelegates.OnPanierPacketDeleted(panierPacket);
                    }
                }
            });

        }
    }

    public class PanierPacket {

        private long quantite;
        private Article article;

        public PanierPacket() {

        }

        public PanierPacket(final Article article, final long quantite) {
            this.quantite = quantite;
            this.article = article;
        }

        public PanierPacket(final Article article) {
            this.quantite = 1;
            this.article = article;
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

        @Override
        public boolean equals(Object object) {
            PanierPacket panierPacket;
            boolean equal = true;
            try {
                panierPacket = ((PanierPacket) object);
                equal = panierPacket.getArticle().equals(this.article);
            } catch (ClassCastException e) {
                equal = false;
            }
            return equal;
        }
    }


}
