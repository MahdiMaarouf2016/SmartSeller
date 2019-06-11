package symatique.smartseller.modules.Produits;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Articles.CategorieArticle;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;
import symatique.smartseller.utils.DialogResultDelegates;

public abstract class DialogCategories extends AppCompatDialog implements DialogResultDelegates {
    @BindView(R.id.btn_dialogcategorie_toutcategorie)
    AppCompatButton btnDialogcategorieToutcategorie;
    @BindView(R.id.rec_dialogcategorie_categories)
    RecyclerView recDialogcategorieCategories;
    public DialogResultDelegates dialogResultDelegates = null;

    public DialogCategories(Context context) {
        super(context);
        setUpView();
        setupCategories();
    }

    void setUpView() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.dialog_categories);
        ButterKnife.bind(this);
    }

    public List<CategorieArticle> getCategorieArticles() {
        List<CategorieArticle> categorieArticles = new ArrayList<>();
        try {
            DatabaseHelper database = DataBaseManager.getInstance(getContext()).getHelper();
            List<CategorieArticle> categories = database.getCategorieArtices().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorieArticles;
    }

    public void setupCategories() {

        CategoriesAdapter adapter = new CategoriesAdapter(getCategorieArticles());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recDialogcategorieCategories.setLayoutManager(layoutManager);
        recDialogcategorieCategories.setItemAnimator(new DefaultItemAnimator());
        recDialogcategorieCategories.setAdapter(adapter);

    }
}
