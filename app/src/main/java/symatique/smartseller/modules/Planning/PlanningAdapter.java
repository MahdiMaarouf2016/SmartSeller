package symatique.smartseller.modules.Planning;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import symatique.smartseller.R;
import symatique.smartseller.data.Client;


public class PlanningAdapter extends RecyclerView.Adapter<PlanningAdapter.PlanningItem> {


    @BindView(R.id.txt_planningitem_sctname) AppCompatTextView txtPlanningitemSctname;
    @BindView(R.id.txt_planningitem_sctcode) AppCompatTextView txtPlanningitemSctcode;
    @BindView(R.id.txt_planningitem_stcgsm) AppCompatTextView txtPlanningitemStcgsm;
    @BindView(R.id.btn_planningitem_call) AppCompatImageView btnPlanningitemCall;

    private List<Client> clients;

    public PlanningAdapter() {
        this.clients = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
        this.notifyDataSetChanged();
    }

    public PlanningAdapter(List<Client> clients) {
        this.clients = clients;
    }

    @NonNull
    @Override
    public PlanningItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_planninactivity_planning, viewGroup, false);

        return new PlanningItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanningItem planningItem, int i) {
        Client client = clients.get(i);
        planningItem.clone(client);
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    public class PlanningItem extends RecyclerView.ViewHolder {
        private View itemView;
        public PlanningItem(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public PlanningItem(@NonNull View itemView, Client client) {
            this(itemView);
            this.clone(client);
        }

        public PlanningItem clone(final Client client) {

            txtPlanningitemSctcode.setText(client.getCode());
            txtPlanningitemSctname.setText(client.getNom());
            txtPlanningitemStcgsm.setText(client.getGsm());
            btnPlanningitemCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String gsm = (String) txtPlanningitemStcgsm.getText();
                    // MAKE A CALL
                }
            });
            return this;
        }
    }

}
