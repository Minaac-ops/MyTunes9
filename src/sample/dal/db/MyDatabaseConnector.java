package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Playlist;
import sample.be.Song;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MyDatabaseConnector {

    private SQLServerDataSource dataSource;

    public MyDatabaseConnector() throws IOException, SQLServerException {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setDatabaseName("MyTunes4");
        dataSource.setUser("CSe20A_26");
        dataSource.setPassword("CSe20A_26");

    }
    public Connection getConnection() throws SQLServerException
    {
        return dataSource.getConnection();
    }

    public static void main(String[] args) throws SQLException, IOException {
        MyDatabaseConnector databaseConnector = new MyDatabaseConnector();
        Connection connection = databaseConnector.getConnection();

        System.out.println("it is open? " + !connection.isClosed());
        connection.close();

        SongDAO_DB songDAO_db = new SongDAO_DB();

        List<Song> allSongs = songDAO_db.getAllSongs();

        System.out.println(allSongs);
        connection.close();

        PlaylistDAO_DB playlistDAO_db = new PlaylistDAO_DB();

        List<Playlist> allPlaylist = playlistDAO_db.getAllPlayLists();
        System.out.println(allPlaylist);
        connection.close();
    }
}
