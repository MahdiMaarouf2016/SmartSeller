package symatique.smartseller.modules.Factures;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.SQLException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import symatique.smartseller.R;
import symatique.smartseller.data.PrefixFacture;
import symatique.smartseller.services.SQLiteService.DataBaseManager;

public class FactureFragment extends Fragment {

    @BindView(R.id.rec_facturestab_listprefixfactures)
     RecyclerView recFacturestabListprefixfactures;
    Unbinder unbinder;

    public FactureFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_factureblactivity_facturetab, container, false);
        unbinder = ButterKnife.bind(this, view);
        setUpListFactures();
        return view;
    }

    void setUpListFactures() {
        try {
            List<PrefixFacture> prefixFactures = DataBaseManager.getInstance().getHelper().getPrefixFactures().queryForAll();

            PrefixFacturesAdapter facturesAdapter = new PrefixFacturesAdapter(prefixFactures);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
            recFacturestabListprefixfactures.setLayoutManager(layoutManager);
            recFacturestabListprefixfactures.setItemAnimator(new DefaultItemAnimator());

            recFacturestabListprefixfactures.setAdapter(facturesAdapter);
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
