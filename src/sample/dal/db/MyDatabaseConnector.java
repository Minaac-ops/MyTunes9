package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Playlist;
import sample.be.Song;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class MyDatabaseConnector {



    private SQLServerDataSource dataSource;

    private static final String PROP_FILE = "db_properties";
    private SQLServerDataSource ds;

    public MyDatabaseConnector() throws IOException {
        Properties databaseProperties = new Properties();
        databaseProperties.load(new FileInputStream(new File(PROP_FILE)));

        String server = databaseProperties.getProperty("10.176.111.31");
        String database = databaseProperties.getProperty("MyTunes4");
        String user = databaseProperties.getProperty("CSe20A_26");
        String password = databaseProperties.getProperty("CSe20A_26");

        ds = new SQLServerDataSource();
        ds.setServerName(server);
        ds.setDatabaseName(database);
        ds.setUser(user);
        ds.setPassword(password);
    }
    public Connection getConnection() throws SQLException
    {
        return ds.getConnection();
    }

    public static void main(String[] args) throws IOException, SQLException {

        MyDatabaseConnector ds = new MyDatabaseConnector();

        try (Connection connection = ds.getConnection()) {
            System.out.println("Is it open? " + !connection.isClosed());
        }
    }
}
