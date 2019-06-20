package symatique.smartseller.modules.Vente;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import symatique.smartseller.R;
import symatique.smartseller.data.Articles.Article;
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.modules.Panier.PanierAdapter;
import symatique.smartseller.utils.AdapterDelegates;

import java.util.ArrayList;
import java.util.List;

public class PanierClientAdapter extends RecyclerView.Adapter<PanierClientAdapter.VenteItem> {

    private List<Packet> packets = null;
    private AdapterDelegates adapterDelegates = null;


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

    public PanierClientAdapter(final List<Packet> packets) {
        this();
        setPackets(packets);
    }

    public PanierClientAdapter(final List<Packet> packets, final AdapterDelegates adapterDelegates) {
        this(adapterDelegates);
        setPackets(packets);
    }

    public void ajouterPacket(final Packet packet) {
        Log.v("Adding packet" + packet.getCodeArticle(), packets.add(packet) + "");
        notifyDataSetChanged();
        this.adapterDelegates.OnPanierPacketInserted(packet);
    }
    @NonNull
    @Override
    public VenteItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_panierclientactivity_packetspanier, viewGroup, false);
        return new VenteItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VenteItem venteItem, int i) {
        Packet packet = packets.get(i);
        Log.v("onBindViewHolder", packet.getCodeArticle());

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

    public AdapterDelegates getAdapterDelegates() {
        return adapterDelegates;
    }

    public void setAdapterDelegates(AdapterDelegates adapterDelegates) {
        this.adapterDelegates = adapterDelegates;
    }


    public List<Packet> getPackets() {
        return packets;
    }

    public class VenteItem extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_venterow_code) AppCompatTextView txtVenterowCode;
        @BindView(R.id.txt_venterow_prod) AppCompatTextView txtVenterowProd;
        @BindView(R.id.txt_venterow_qte) AppCompatTextView txtVenterowQte;
        @BindView(R.id.imgbtn_venterow_delete)
        AppCompatImageButton imgbtnVenterowDelete;

        public VenteItem(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void clone(final Packet packet) {

            txtVenterowCode.setText(packet.getCodeArticle());
            txtVenterowProd.setText(packet.getLibelleArticle());
            txtVenterowQte.setText(String.valueOf(packet.getQuantite()));

            imgbtnVenterowDelete.setOnClickListener(new View.OnClickListener() {
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
