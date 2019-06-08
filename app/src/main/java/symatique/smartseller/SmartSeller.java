package symatique.smartseller;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import com.j256.ormlite.logger.Logger;

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
        databaseHelper.onCreate(databaseHelper.getWritableDatabase(),databaseHelper.getConnectionSource());
        Logger logger = LoggerFactory.getLogger(QueryBuilder.class);
        //logger.debug(databaseHelper.toString());
        //databaseHelper.onCreate();

    }
}
