package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DbConnectionProvider {

    private SQLServerDataSource dataSource;

    public DbConnectionProvider() throws IOException
    {

    }
}
