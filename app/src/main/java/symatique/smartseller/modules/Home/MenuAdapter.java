package symatique.smartseller.modules.Home;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import symatique.smartseller.R;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuOptionItem> {

    private final MenuItem[] tableOptions = {
            new MenuItem("PLANINIG", R.drawable.ic_assignment)
            , new MenuItem("COMMANDER", R.drawable.ic_commandes)
            , new MenuItem("MES COMMNADES", R.drawable.ic_cardcommands)
            , new MenuItem("VENTE", R.drawable.ic_sale)
            , new MenuItem("MES FACTURES", R.drawable.ic_receipt)
            , new MenuItem("ETAT DE STOCK", R.drawable.ic_stock)
            , new MenuItem("CLIENTS", R.drawable.ic_clients)
            , new MenuItem("ETAT DE CAISSE", R.drawable.ic_safe)
            , new MenuItem("SYNCHRONISATION", R.drawable.ic_synchronisation)
            , new MenuItem("PARAMETRES", R.drawable.ic_settings)
    };

    public MenuAdapter() {

    }

    @NonNull
    @Override
    public MenuOptionItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_menuactivty_menu, viewGroup, false);
        return new MenuOptionItem(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuOptionItem menuOptionItem, int position) {

        MenuItem MenuOption = tableOptions[position];
        menuOptionItem.setTitle(MenuOption.getPlaninig());
        menuOptionItem.setIcon(MenuOption.getIc_assignment());
    }

    @Override
    public int getItemCount() {
        return tableOptions.length;
    }

    public class MenuItem {

        private String planinig;
        private int ic_assignment;

        public MenuItem(String planinig, int ic_assignment) {
            this.planinig = planinig;
            this.ic_assignment = ic_assignment;
        }

        public String getPlaninig() {
            return planinig;
        }

        public int getIc_assignment() {
            return ic_assignment;
        }

        public void setPlaninig(String planinig) {
            this.planinig = planinig;
        }

        public void setIc_assignment(int ic_assignment) {
            this.ic_assignment = ic_assignment;
        }
    }


    public class MenuOptionItem extends RecyclerView.ViewHolder {
        View holderView;
        public MenuOptionItem(@NonNull View itemView) {
            super(itemView);
            this.holderView = itemView;
            AppCompatImageView imageView = itemView.findViewById(R.id.list_item_icon);
            AppCompatTextView textView = itemView.findViewById(R.id.list_item_text);
            imageView.setImageDrawable(itemView.getContext().getDrawable(R.drawable.ic_exit));
        }

        public MenuOptionItem(@NonNull View itemView, String title, int icon) {
            this(itemView);
            AppCompatImageView imageView = itemView.findViewById(R.id.list_item_icon);
            imageView.setImageDrawable(itemView.getContext().getDrawable(icon));
            AppCompatTextView textView = itemView.findViewById(R.id.list_item_text);
            textView.setText(title);
        }

        public void setTitle(String title) {
            AppCompatTextView textView = this.holderView.findViewById(R.id.list_item_text);
            textView.setText(title);
        }

        public void setIcon(int icon) {
            AppCompatImageView imageView = this.holderView.findViewById(R.id.list_item_icon);
            imageView.setImageDrawable(itemView.getContext().getDrawable(icon));
        }

        public String getTitle() {
            return  ((AppCompatTextView)this.holderView.findViewById(R.id.list_item_text)).getText().toString();
        }
    }
}


