package symatique.smartseller.modules.Produits;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import symatique.smartseller.R;
import symatique.smartseller.data.Articles.CategorieArticle;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;
import symatique.smartseller.utils.ClickListener;
import symatique.smartseller.utils.DialogResultDelegates;
import symatique.smartseller.utils.RecyclerTouchListener;

public abstract class DialogCategories extends AlertDialog.Builder {
    @BindView(R.id.btn_dialogcategorie_toutcategorie)
    AppCompatButton btnDialogcategorieToutcategorie;
    @BindView(R.id.rec_dialogcategorie_categories)
    RecyclerView recDialogcategorieCategories;
    public AlertDialog alertDialog = null;
    public DialogResultDelegates dialogResultDelegates = null;

    public DialogCategories(Context context) {
        super(context);
        setView(R.layout.dialog_categories);
    }

    @Override
    public AlertDialog show() {
        alertDialog = super.show();
        ButterKnife.bind(this, alertDialog);
        setupCategories();
        return alertDialog;
    }

    @OnClick(R.id.btn_dialogcategorie_toutcategorie)
    public abstract void btnDialogcategorieToutcategorieOnClick();

    public abstract void onCategorieArticleSelected(CategorieArticle categorieArticle);

    public List<CategorieArticle> getCategorieArticles() {
        List<CategorieArticle> categorieArticles = new ArrayList<>();
        try {
            DatabaseHelper database = DataBaseManager.getInstance(getContext()).getHelper();
            categorieArticles = database.getCategorieArtices().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Log.e("List cat size : ", categorieArticles.size() + "");
        return categorieArticles;
    }

    public void setupCategories() {

        CategoriesAdapter adapter = new CategoriesAdapter(getCategorieArticles());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(alertDialog.getContext());
        recDialogcategorieCategories.setLayoutManager(layoutManager);
        recDialogcategorieCategories.setItemAnimator(new DefaultItemAnimator());
        recDialogcategorieCategories.setAdapter(adapter);
        recDialogcategorieCategories.addOnItemTouchListener(new RecyclerTouchListener(this.getContext(),
                        recDialogcategorieCategories, new ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        CategorieArticle categorieArticle = ((CategoriesAdapter) recDialogcategorieCategories.getAdapter()).getCategories().get(position);
                        onCategorieArticleSelected(categorieArticle);
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        onClick(view, position);
                    }
                })
        );

    }
}
