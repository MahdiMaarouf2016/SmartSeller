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
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import symatique.smartseller.R;
import symatique.smartseller.data.PrefixBL;
import symatique.smartseller.data.PrefixFacture;
import symatique.smartseller.services.SQLiteService.DataBaseManager;

public class BLFragment extends Fragment {
    @BindView(R.id.rec_bltab_listprefixbls)
     RecyclerView recBltabListprefixbls;
    Unbinder unbinder;
     LayoutInflater inflater = null;

    public BLFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facturesblactivity_blstab, container, false);
        // Inflate the layout for this fragment
        unbinder = ButterKnife.bind(this, view);
        setUpRecycle();
        return view;
    }

    private void setUpRecycle() {
        try {
            List<PrefixBL> prefixBLS = DataBaseManager.getInstance().getHelper().getPrefixBLS().queryForAll();

            PrefixBlsAdapter facturesAdapter = new PrefixBlsAdapter(prefixBLS);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            recBltabListprefixbls.setLayoutManager(layoutManager);
            recBltabListprefixbls.setItemAnimator(new DefaultItemAnimator());

            recBltabListprefixbls.setAdapter(facturesAdapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
