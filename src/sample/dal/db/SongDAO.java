package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Song;
import sample.dal.DalException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongDAO {

    private MyDatabaseConnector myDatabaseConnector;

    private final JDBCConnectionPool connectionPool;

    public SongDAO() throws IOException, SQLServerException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

    public List<Song> getAllSongs() throws DalException, SQLException {
        List<Song> songs = new ArrayList<>();
        Connection con = connectionPool.checkOut();

        //Creating a connection
        try (Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Song;");
            while (rs.next()) {
                int id = rs.getInt("Song_ID");
                String title = rs.getString("Title");
                String artist = rs.getString("Artist");
                String category = rs.getString("Category");
                String duration = rs.getString("Duration");
                Song song = new Song(id, title, artist, category, duration);
                songs.add(song);
            }
            return songs;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new DalException("Could not get all songs from database", ex);
        } finally {
            connectionPool.checkIn(con);
        }
    }
}
