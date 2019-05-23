package symatique.smartseller.services.SQLiteService;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import static symatique.smartseller.bases.SQLiteBases.CONFIG_FILE_NAME;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {

    public static void main(String[] args) throws Exception {
        writeConfigFile(CONFIG_FILE_NAME);
    }
}
