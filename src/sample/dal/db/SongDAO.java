package sample.dal.db;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Song;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongDAO {

    private MyDatabaseConnector databaseConnector;

    private final JDBCConnectionPool connectionPool;

    public SongDAO() throws IOException, SQLServerException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

    public List<Song> getAllSongs() throws SQLException
    {
        ArrayList<Song> getAllSongs = new ArrayList<>();
        Connection con = connectionPool.checkOut();
        try (Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Songs;");
            while (rs.next()) {
                int id = rs.getInt("Song_ID");
                String title = rs.getString("Title");
                String artist = rs.getString("Artist");
                String category = rs.getString("Category");
                String duration = rs.getString("Duration");
                Song song = new Song(id, title, artist, category, duration);
                getAllSongs.add(song);
            }
            return getAllSongs;
        }
    }
}
