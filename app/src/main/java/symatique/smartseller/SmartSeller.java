package symatique.smartseller;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.QueryBuilder;

import java.math.BigDecimal;
import java.sql.SQLException;
import com.j256.ormlite.logger.Logger;

import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.services.SQLiteService.DataBaseManager;
import symatique.smartseller.services.SQLiteService.DatabaseHelper;

public class SmartSeller extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setUpDataBase();
        Log.v("Application ","ON CREATE");
    }

    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.v("Application ","ON CONFIGURE CHANGED");
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.v("Application ","LOW MEMORY");
    }

    private void setUpDataBase() {
        DatabaseHelper databaseHelper = DataBaseManager.getInstance(this).getHelper();
        //databaseHelper.onCreate(databaseHelper.getWritableDatabase(),databaseHelper.getConnectionSource());
        Packet packet = new Packet();
        packet.setLibelle("Packet jadida");
        packet.setLibelleArticle("Jadida Huil 5litre");
        packet.setCodeArticle("123454");
        packet.setCodeBarre("123532");
        packet.setPrixUnitaireHT(BigDecimal.valueOf(23.300));
        packet.setQuantite(56);
        try {
            databaseHelper.getPacketsStock().createOrUpdate(packet);
            Log.v("Packet","HAS BEEN SUCCES ADDED");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Logger logger = LoggerFactory.getLogger(QueryBuilder.class);
        //logger.debug(databaseHelper.toString());
        //databaseHelper.onCreate();

    }
}
