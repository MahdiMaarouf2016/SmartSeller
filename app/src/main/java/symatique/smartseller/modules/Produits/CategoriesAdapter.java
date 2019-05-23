package symatique.smartseller.modules.Produits;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import symatique.smartseller.R;
import symatique.smartseller.data.CategorieArticle;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesItem> {

    private List<CategorieArticle> categories;
    @BindView(R.id.btn_categorieitem_lebelcategorie)
     AppCompatButton btnCategorieitemLebelcategorie;

    CategoriesAdapter() {
        this.categories = new ArrayList<>();
    }

    public CategoriesAdapter(List<CategorieArticle> categories) {
        this.categories = categories;
    }

    public List<CategorieArticle> getCategories() {
        return categories;
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
        categoriesItem.clone(categorie);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


    public class CategoriesItem extends RecyclerView.ViewHolder {

        public CategoriesItem(@NonNull View itemView) {
            super(itemView);
        }

        public CategoriesItem clone(CategorieArticle categorie) {
            btnCategorieitemLebelcategorie.setText(categorie.getLibelle());
            return this;
        }
    }

}
