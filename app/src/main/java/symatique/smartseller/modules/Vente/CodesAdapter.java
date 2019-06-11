package symatique.smartseller.modules.Vente;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Stocks.Packet;

import java.util.ArrayList;
import java.util.List;

public class CodesAdapter extends RecyclerView.Adapter<CodesAdapter.CodeItem> {

     List<Packet> packets;

    public CodesAdapter() {
        this.packets = new ArrayList<>();
    }

    public CodesAdapter(final List<Packet> packets) {
        this.packets = packets;
    }

    public List<Packet> getPackets() {
        return packets;
    }

    public void setPackets(List<Packet> packets) {
        this.packets = packets;
    }

    @NonNull
    @Override
    public CodeItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_codesactivity_code, viewGroup, false);
        return new CodeItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CodeItem codeItem, int i) {
        Packet packet = packets.get(i);
        codeItem.clone(packet);
    }

    @Override
    public int getItemCount() {
        return packets.size();
    }

    public class CodeItem extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_code_code) AppCompatTextView txtCodeCode;
        @BindView(R.id.txt_code_produit) AppCompatTextView txtCodeProduit;
        @BindView(R.id.txt_code_qte) AppCompatTextView txtCodeQte;

        public CodeItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void clone(Packet packet) {
            txtCodeCode.setText(packet.getCodeArticle());
            txtCodeQte.setText(String.valueOf(packet.getQuantite()));
            txtCodeProduit.setText(packet.getLibelleArticle());
        }
    }

}
