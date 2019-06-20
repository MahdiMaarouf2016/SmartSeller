package symatique.smartseller.modules.Caisse;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Encaissements.Encaissement;
import symatique.smartseller.services.SQLiteService.DataBaseManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CaissesBonLivraisonFragment extends AppCompatDialogFragment {

    public CaissesBonLivraisonFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_caisse_bls, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private List<Encaissement> getListEncaissements() {
        List<Encaissement> encaissements = new ArrayList<>();
        try {
            DataBaseManager.getInstance(this.getContext()).getHelper().getTypeEncaissementVentes();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return encaissements;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
