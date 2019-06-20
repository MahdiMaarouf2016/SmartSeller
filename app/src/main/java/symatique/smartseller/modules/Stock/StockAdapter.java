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
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.modules.Panier.PanierAdapter;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockItem> {

    private List<Packet> stockParVendeurs;

    public StockAdapter() {
        this.stockParVendeurs = new ArrayList<>();
    }

    public StockAdapter(List<Packet> stockRows) {
        this.stockParVendeurs = stockRows;
    }

    public int getNombreArticles(){
     return stockParVendeurs.size();
    }

    public double getValeurTotale(){
        double valeurTotale = 0;
        for(Packet packet:stockParVendeurs){
            valeurTotale += packet.getQuantite() * packet.getPrixRevendeur().doubleValue();
        }

        return PanierAdapter.round(valeurTotale,3);
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
        @BindView(R.id.txt_stockitem_code) AppCompatTextView txtStockitemCode;
        @BindView(R.id.txt_stockitem_produit) AppCompatTextView txtStockitemProduit;
        @BindView(R.id.txt_stockitem_qte) AppCompatTextView txtStockitemQte;
        @BindView(R.id.txt_stockitem_prix) AppCompatTextView txtStockitemPrix;

        public StockItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void clone(Packet packet) {

            txtStockitemCode.setText(packet.getCodeArticle());
            txtStockitemPrix.setText(packet.getPrixRevendeur().toString());
            txtStockitemProduit.setText(packet.getLibelleArticle());
            txtStockitemQte.setText(String.valueOf(packet.getQuantite()));

        }
    }

}
