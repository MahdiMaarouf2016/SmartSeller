package symatique.smartseller.services.SQLiteService;
import android.content.Context;

public class DataBaseManager {

    private DatabaseHelper helper;
    static private DataBaseManager instance;

    static public DataBaseManager getInstance(Context context) {
        if (null == instance) {
            instance = new DataBaseManager(context);
        }
        return instance;
    }

    private DataBaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    public DatabaseHelper getHelper() {
        return helper;
    }

}
