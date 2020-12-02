package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Song;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongDAO_DB {

    private MyDatabaseConnector myDatabaseConnector;

    public SongDAO_DB() throws IOException, SQLServerException {
        myDatabaseConnector = new MyDatabaseConnector();
    }

    public List<Song> getAllSongs() throws IOException, SQLException {
        ArrayList<Song> allSongs = new ArrayList<>();

        //Creating a connection
        try (Connection connection = myDatabaseConnector.getConnection()) {
            String sql = "SELECT * FROM Song";

            Statement statement = connection.createStatement();

            if (statement.execute(sql))
            {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()){
                    int id = resultSet.getInt("ID");
                    String title = resultSet.getString("Title");
                    String artist = resultSet.getString("Artist");
                    String category = resultSet.getString("Category");
                    String duration = resultSet.getString("Duration");

                    Song song = new Song(id, title, artist, category, duration);
                    allSongs.add(song);
                }

            }
        } return allSongs;
    }
}
