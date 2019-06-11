package symatique.smartseller.modules.Vente;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.utils.AdapterDelegates;

import java.util.ArrayList;
import java.util.List;

public class PanierClientAdapter extends RecyclerView.Adapter<PanierClientAdapter.VenteItem> {

    private List<Packet> packets;
    private AdapterDelegates adapterDelegates = null;

    public AdapterDelegates getAdapterDelegates() {
        return adapterDelegates;
    }

    public void setAdapterDelegates(AdapterDelegates adapterDelegates) {
        this.adapterDelegates = adapterDelegates;
    }
    public PanierClientAdapter() {
        packets = new ArrayList<>();
        setAdapterDelegates(new AdapterDelegates() {
            @Override
            public void OnPanierPacketInserted(Object object) {

            }

            @Override
            public void OnPanierPacketDeleted(Object object) {

            }

            @Override
            public void OnPanierPacketUpdated(Object object) {

            }

            @Override
            public void OnInitializedAdapter(List objects) {

            }
        });
    }

    public PanierClientAdapter(final AdapterDelegates adapterDelegates) {
        this();
        setAdapterDelegates(adapterDelegates);
    }

    public PanierClientAdapter(final List<Packet> packets, final AdapterDelegates adapterDelegates) {
        this(adapterDelegates);
        this.packets = packets;
    }

    public void AjouterLigneStockParVendeur(final Packet packet){
        packets.add(packet);
        notifyDataSetChanged();
        this.adapterDelegates.OnPanierPacketInserted(packet);
    }
    @NonNull
    @Override
    public VenteItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_ventesactivity_vente, viewGroup, false);
        return new VenteItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VenteItem venteItem, int i) {
        Packet packet = packets.get(i);
        venteItem.clone(packet);
    }

    @Override
    public int getItemCount() {
        return packets.size();
    }

    public void setPackets(List<Packet> packets) {
        this.packets = packets;
        notifyDataSetChanged();
        this.adapterDelegates.OnInitializedAdapter(packets);
    }

    public List<Packet> getPackets() {
        return packets;
    }

    public class VenteItem extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_venterow_code) AppCompatTextView txtVenterowCode;
        @BindView(R.id.txt_venterow_prod) AppCompatTextView txtVenterowProd;
        @BindView(R.id.txt_venterow_qte) AppCompatTextView txtVenterowQte;
        @BindView(R.id.fab_venterow_delete) FloatingActionButton fabventerowdelete;

        public VenteItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }

        public void clone(final Packet packet) {
            txtVenterowCode.setText(packet.getCodeArticle());
            txtVenterowProd.setText(packet.getLibelleArticle());
            txtVenterowQte.setText(String.valueOf(packet.getQuantite()));
            fabventerowdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    packets.remove(packet);
                    notifyDataSetChanged();
                    adapterDelegates.OnPanierPacketDeleted(packet);
                }
            });
        }
    }


}
