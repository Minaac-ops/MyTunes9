package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DbConnectionProvider {

    private SQLServerDataSource dataSource;

    public DbConnectionProvider() throws IOException
    {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setDatabaseName("MyTunes3");
        dataSource.setUser("CSe20A_26");
        dataSource.setPassword("CSe20A_26");

    }
    public Connection getConnection() throws SQLServerException;
    {
        return dataSource.getConnection();
    }
}
