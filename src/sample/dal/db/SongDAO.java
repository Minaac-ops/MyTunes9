package sample.dal.db;

import java.sql.Connection;
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
import java.sql.Statement;

public class SongDAO {

    private MyDatabaseConnector databaseConnector;

    public SongDAO() throws IOException {
        databaseConnector = new MyDatabaseConnector();
    }

    public List<Song> getAllSongs() throws SQLException
    {
        ArrayList<Song> getAllSongs = new ArrayList<>();
        try (Connection connection = databaseConnector.getConnection())
        {
            String sql = "SELECT * FROM Song;";

            Statement statement = databaseConnector.getConnection().createStatement();

            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("Song_ID");
                    String title = resultSet.getString("Title");
                    String artist = resultSet.getString("Artist");
                    String category = resultSet.getString("Category");
                    String duration = resultSet.getString("Duration");
                    Song song = new Song(id, title, artist, category, duration);
                    getAllSongs.add(song);
                }
            }
        }
        return getAllSongs;
    }


    }
