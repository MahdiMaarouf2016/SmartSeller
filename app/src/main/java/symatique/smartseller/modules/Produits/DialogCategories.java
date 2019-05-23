package symatique.smartseller.modules.Produits;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import java.sql.SQLException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.CategorieArticle;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;

public class DialogCategories extends AppCompatDialog {


    @BindView(R.id.btn_dialogcategorie_toutcategorie)
     AppCompatButton btnDialogcategorieToutcategorie;
    @BindView(R.id.rec_dialogcategorie_categories)
     RecyclerView recDialogcategorieCategories;

    public DialogCategories(Context context) {
        super(context);
        setUpView();
        setupCategories();
    }

    void setUpView() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.fragment_categories);
        ButterKnife.bind(this);
    }

    public void setupCategories() {

        DatabaseHelper database = DataBaseManager.getInstance().getHelper();

        try {

            List<CategorieArticle> categories = database.getCategorieArtices().queryForAll();

            CategoriesAdapter adapter = new CategoriesAdapter(categories);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            recDialogcategorieCategories.setLayoutManager(layoutManager);
            recDialogcategorieCategories.setItemAnimator(new DefaultItemAnimator());
            recDialogcategorieCategories.setAdapter(adapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
