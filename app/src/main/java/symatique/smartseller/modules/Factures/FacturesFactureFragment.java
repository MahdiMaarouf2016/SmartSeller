package symatique.smartseller.modules.Factures;

import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import symatique.smartseller.R;
import symatique.smartseller.data.Factures.Facture;
import symatique.smartseller.services.SQLiteService.DataBaseManager;

public class FacturesFactureFragment extends AppCompatDialogFragment {

    public static double total = 0;
    @BindView(R.id.rec_facturestab_listprefixfactures)
    RecyclerView recFacturestabListprefixfactures;
    Unbinder unbinder;

    public FacturesFactureFragment() {

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

    public List<Facture> getListFactures() {
        List<Facture> factures = new ArrayList<>();

        try {
            factures = DataBaseManager.getInstance(getContext()).getHelper().getFactures().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return factures;
    }

    void setUpListFactures() {
        List<Facture> factures = getListFactures();

        if (!factures.isEmpty()) {
            List<Facture> filtredfactures = new ArrayList<>();
            for (Facture facture : factures) {
                if (!facture.isBonLivraison()) filtredfactures.add(facture);
                total += facture.getMontantHT().doubleValue();
            }
            if (!filtredfactures.isEmpty()) {

                FacturesListFacturesAdapter facturesListFacturesAdapter = new FacturesListFacturesAdapter(filtredfactures);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
                recFacturestabListprefixfactures.setLayoutManager(layoutManager);
                recFacturestabListprefixfactures.setItemAnimator(new DefaultItemAnimator());

                recFacturestabListprefixfactures.setAdapter(facturesListFacturesAdapter);
            } else Toast.makeText(this.getContext(), "Aucune facture a ete trouvé", Toast.LENGTH_LONG).show();


        } else Toast.makeText(this.getContext(), "Aucune facture a ete trouvé ! ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
