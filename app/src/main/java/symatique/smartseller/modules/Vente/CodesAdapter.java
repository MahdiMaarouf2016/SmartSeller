package symatique.smartseller.modules.Vente;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import symatique.smartseller.R;

public class CodesAdapter extends RecyclerView.Adapter<CodesAdapter.CodeItem> {
   // ArrayList<Packet> codes;

    public CodesAdapter() {

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
        //Packet code = codes.get(i);

        //codeItem.clone(code);
    }

    @Override
    public int getItemCount() {
        return  0;
    }

    public class CodeItem extends RecyclerView.ViewHolder {
        public CodeItem(@NonNull View itemView) {
            super(itemView);
        }

    /*public void clone(Packet code) {

        AppCompatTextView textView = itemView.findViewById(R.id.txt_code_code);
        AppCompatTextView textView1 = itemView.findViewById(R.id.txt_code_produit);
        AppCompatTextView textView2 = itemView.findViewById(R.id.txt_code_qte);

        textView.setText(code.getCodeArticle());
        textView1.setText(code.getLibelleArticle());
        textView2.setText(String.valueOf(code.getQuantite()));
    }*/
    }

}
