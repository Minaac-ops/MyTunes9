package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Song;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongDAO_DB {
    private MyDatabaseConnector myDatabaseConnector;

    public SongDAO_DB() throws IOException, SQLServerException {
        myDatabaseConnector = new MyDatabaseConnector();
    }

    public List<Song> getAllSong() throws IOException {
        ArrayList<Song> songs = new ArrayList<>();
        try (Connection connection = myDatabaseConnector.getConnection()) {
            String sql = "SELECT * FROM songs";

            Statement statement = connection.createStatement();

            if (statement.execute(sql))
            {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()){
                    String Title = resultSet.getString("Title");
                    String Artist = resultSet.getString("Artist");
                    String Category = resultSet.getString("Category");
                    String Duration = resultSet.getString("Duration");

                    Song song = new Song(Title, Artist, Category, Duration);
                    Song.add(song);
                }

            }
        }
        
    }

}
