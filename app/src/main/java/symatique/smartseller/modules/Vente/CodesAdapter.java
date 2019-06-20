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

import java.math.BigDecimal;
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    affichierDialog(packet);
                }
            });
        }

        public void affichierDialog(Packet packet) {

            DialogPrixQuantiteLivrison dialogPrixQuantiteLivrison = new DialogPrixQuantiteLivrison(itemView.getContext(), packet) {
                @Override
                public void OnAccepted() {
                    //txtCodeQte.setText(packet.getQuantite() - Integer.parseInt(edttxtQteprixlayoutQtelivrison.getText().toString()) + "");
                    //Packet packet1 = new Packet(packet.getId(),packet.getLibelle(),packet.getCodeBarre(),packet.getQuantite(),packet.getPrixUnitaireHT(),packet.isEtatSynchronisation(),packet.isEtatVendu(),packet.getTva(),packet.getIdArticle(),packet.getCodeArticle(),packet.getIdEntreprise(),packet.getLibelleEntreprise(),packet.getDate(),packet.getDateVente(),packet.getCodeEntreprise(),packet.getCodeClient(),packet.getDescription(),packet.getLot(),packet.getLibelleArticle(),packet.getIdBonSortie(),packet.getIdClient(),packet.getLibelleClient(),packet.isArticleLie(),packet.getTvaLie(),packet.getPrixUnitaireHTLie(),packet.getCodeArticleLie(),packet.getLibelleArticleLie(),packet.getPoids(),packet.isSupprimer(),packet.getDateSynchro(),packet.getIdDomaine(),packet.getLibelleDomaine(),packet.getCodeDomaine());
                    //packet1.setQuantite(Integer.parseInt(edttxtQteprixlayoutQtelivrison.getText().toString()));
                    //packet1.setPrixUnitaireHTLie(BigDecimal.valueOf(Double.parseDouble(edttxtQteprixlayoutPrixlivrison.getText().toString())));
                    //PanierClientActivity.getPanierClientAdapter().ajouterPacket(packet1);

                    packets.remove(packet);
                    notifyDataSetChanged();
                    txtCodeQte.setText(packet.getQuantite() - Integer.parseInt(edttxtQteprixlayoutQtelivrison.getText().toString()) + "");
                    OnRejected();
                }

                @Override
                public void OnRejected() {
                    alertDialog.dismiss();
                }
            };

            dialogPrixQuantiteLivrison.show();
        }
    }

}
