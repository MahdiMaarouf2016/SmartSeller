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

public class FacturesBonLivraisonFragment extends AppCompatDialogFragment {
    @BindView(R.id.rec_bltab_listprefixbls)
    RecyclerView recBltabListprefixbls;
    Unbinder unbinder;

    public FacturesBonLivraisonFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facturesblactivity_blstab, container, false);
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
                if (facture.isBonLivraison()) filtredfactures.add(facture);
            }
            if (!filtredfactures.isEmpty()) {
                FacturesListBonLivraisonAdapter facturesListBonLivraisonAdapter = new FacturesListBonLivraisonAdapter(filtredfactures);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
                recBltabListprefixbls.setLayoutManager(layoutManager);
                recBltabListprefixbls.setItemAnimator(new DefaultItemAnimator());

                recBltabListprefixbls.setAdapter(facturesListBonLivraisonAdapter);
            } else Toast.makeText(this.getContext(), "Aucune facture a ete trouvé", Toast.LENGTH_LONG).show();
        } else Toast.makeText(this.getContext(), "Aucune facture a ete trouvé ! ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
