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
        ArrayList<Song> allSongs = new ArrayList<>();
        Connection con = connectionPool.checkOut();
        try (Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Songs;");
            while (rs.next()) {
                int id = rs.getInt("ID_Song");
                String title = rs.getString("Title");
                String artist = rs.getString("Artist");
                String category = rs.getString("Category");
                int duration = rs.getInt("Time");
                String path = rs.getString("url");
                Song song = new Song(id, title, artist, category, duration, path);
                allSongs.add(song);
            }
            return allSongs;
        }
    }
}
