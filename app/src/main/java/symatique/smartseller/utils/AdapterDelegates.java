package symatique.smartseller.utils;

import android.support.v7.widget.RecyclerView;
import symatique.smartseller.modules.Panier.PanierAdapter.PanierPacket;

import java.util.List;
// 9ELLO WINI WETHNEK , 9ELLO AHAYKA MEN HOOOOOOOONI
public interface AdapterDelegates {
    public void OnPanierPacketInserted(Object object);
    public void OnPanierPacketDeleted(Object object);
    public void OnPanierPacketUpdated(Object object);
    public void OnInitializedAdapter(List objects);
}
