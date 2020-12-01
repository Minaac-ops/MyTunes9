package sample.dal.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DbConnectionProvider {

    public DbConnectionProvider() throws IOException
    {

        databaseProperties.load(new FileInputStream(new File(PROP_FILE)));

        String server = databaseProperties.getProperty("10.176.111.31");
        String database = databaseProperties.getProperty("NRS_20");
        String user = databaseProperties.getProperty("CSe20A_26");
        String password = databaseProperties.getProperty("CSe20A_26");
    }
}
