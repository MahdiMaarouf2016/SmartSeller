package symatique.smartseller.modules.Stock;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.DetailStock;
import symatique.smartseller.data.StockParVendeur;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockItem> {

    private List<DetailStock> stockParVendeurs;

    public StockAdapter() {
        this.stockParVendeurs = new ArrayList<>();
    }

    public StockAdapter(List<DetailStock> stockRows) {
        this.stockParVendeurs = stockRows;
    }

    @NonNull
    @Override
    public StockItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_stockactivity_stock, viewGroup, false);

        return new StockItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StockItem stockItem, int i) {
        stockItem.clone(stockParVendeurs.get(i));
    }

    @Override
    public int getItemCount() {
        return stockParVendeurs.size();
    }

    public class StockItem extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_stockitem_code)
        AppCompatTextView txtStockitemCode;
        @BindView(R.id.txt_stockitem_produit)
        AppCompatTextView txtStockitemProduit;
        @BindView(R.id.txt_stockitem_qte)
        AppCompatTextView txtStockitemQte;
        @BindView(R.id.txt_stockitem_prix)
        AppCompatTextView txtStockitemPrix;

        public StockItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void clone(DetailStock detailStock) {

            //txtStockitemCode.setText();
            //txtStockitemPrix.setText();
            //txtStockitemProduit.setText(detailStock.getCode());
            /*
            textView.setText(stockRow.getCodeArticle());
            textView1.setText(stockRow.getLibelleArticle());
            textView2.setText(String.valueOf(stockRow.getQuantite()));
            textView3.setText(String.valueOf(stockRow.getPrixUnitaireHT()));
            */
        }
    }

}
