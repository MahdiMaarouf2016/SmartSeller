package symatique.smartseller.modules.Produits;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import symatique.smartseller.R;
import symatique.smartseller.data.Article;


public class ProduitsAdapter extends RecyclerView.Adapter<ProduitsAdapter.ProduitItem> {

    @BindView(R.id.img_panieritem_prodbackimg) AppCompatImageView imgProdbackimg;
    @BindView(R.id.txt_panieritiem_prodlibelle) AppCompatTextView txtProduitiemProdlibelle;
    @BindView(R.id.txt_produitiem_prodcode) AppCompatTextView txtProduitiemProdcode;
    @BindView(R.id.txt_produitiem_categorie) AppCompatTextView txtProduitiemCategorie;
    @BindView(R.id.btn_panieritiem_plus) AppCompatButton btnProduitiemPlus;
    @BindView(R.id.txtedt_produitiem_quantite) TextInputEditText txtedtProduitiemQuantite;
    @BindView(R.id.btn_panieritiem_moin) AppCompatButton btnProduitiemMoin;
    @BindView(R.id.linearLayoutCompat) AppCompatButton btnProduitiemAjouter;

    private List<Article> articles;

    public ProduitsAdapter() {
        this.articles = new ArrayList<>();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    public ProduitsAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public ProduitItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_produitsactivity_article, viewGroup, false);

        return new ProduitItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitItem produitItem, int i) {
        Article produit = this.articles.get(i);
        produitItem.clone(produit);
    }

    @Override
    public int getItemCount() {
        return this.articles.size();
    }

    public class ProduitItem extends RecyclerView.ViewHolder {

        public ProduitItem(@NonNull View itemView) {
            super(itemView);
        }

        public ProduitItem(@NonNull View itemView, Article articles) {
            this(itemView);
            this.clone(articles);
        }

        public void clone(final Article article) {

            txtedtProduitiemQuantite.setText("0");
            txtProduitiemCategorie.setText(article.getCategorieArticle().getLibelle());
            txtProduitiemProdcode.setText(article.getCode());
            txtProduitiemProdlibelle.setText(article.getLibelle());
            btnProduitiemPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double currentqe = Integer.parseInt(txtedtProduitiemQuantite.getText().toString());
                    txtedtProduitiemQuantite.setText(String.valueOf(currentqe + 1));
                }
            });
            btnProduitiemMoin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double currentqe = Integer.parseInt(txtedtProduitiemQuantite.getText().toString());
                    if(currentqe - 1 >= 0)txtedtProduitiemQuantite.setText(String.valueOf(currentqe - 1));
                }
            });

            btnProduitiemAjouter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(articles.remove(article)){
                        setArticles(articles);
                    }

                }
            });
        }

    }

}
