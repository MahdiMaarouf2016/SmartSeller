package symatique.smartseller.modules.Produits;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Articles.CategorieArticle;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesItem> {

    private List<CategorieArticle> categories = null;

    CategoriesAdapter() {
        this.categories = new ArrayList<>();
    }

    public CategoriesAdapter(final List<CategorieArticle> categories) {
        setCategories(categories);
    }


    public void setCategories(List<CategorieArticle> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CategoriesItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_categoriesfragment_categorie, viewGroup, false);
        return new CategoriesItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesItem categoriesItem, int i) {
        CategorieArticle categorie = categories.get(i);
        Log.e("article cat i : ", i + "");
        categoriesItem.clone(categorie);
    }

    @Override
    public int getItemCount() {
        Log.e("SIZE", categories.size() + "");
        return categories.size();
    }

    public List<CategorieArticle> getCategories() {
        return categories;
    }

    public class CategoriesItem extends RecyclerView.ViewHolder {

        //@BindView(R.id.txt_categorieitem_lebelcategorie) AppCompatTextView txtCategorieitemLebelcategorie;

        public CategoriesItem(@NonNull View itemView) {
            super(itemView);
            // ButterKnife.bind(this,itemView);
        }

        public void clone(CategorieArticle categorie) {
            AppCompatTextView txtCategorieitemLebelcategorie = itemView.findViewById(R.id.txt_categorieitem_lebelcategorie);
            txtCategorieitemLebelcategorie.setText(categorie.getLibelle());
        }
    }

}
