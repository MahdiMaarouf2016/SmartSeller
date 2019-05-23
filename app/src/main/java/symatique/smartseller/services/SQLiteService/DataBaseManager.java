package symatique.smartseller.services.SQLiteService;
import android.content.Context;

public class DataBaseManager {

    private DatabaseHelper helper;
    static private DataBaseManager instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new DataBaseManager(ctx);
        }
    }

    static public DataBaseManager getInstance() {
        return instance;
    }

    private DataBaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    public DatabaseHelper getHelper() {
        return helper;
    }

}
