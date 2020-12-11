package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.scene.chart.ScatterChart;
import sample.be.Playlist;
import sample.be.Song;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaylistTracksDAO{

    private MyDatabaseConnector myDatabaseConnector;

    public PlaylistTracksDAO() throws IOException, SQLServerException {

        myDatabaseConnector = new MyDatabaseConnector();
    }

    public List<Song> getPlaylistSongs() throws SQLException {
    ArrayList<Song> NewSongList = new ArrayList();

        try (Connection connection = myDatabaseConnector.getConnection()) {
            String sql = "SELECT * FROM Playlist INNER JOIN ON Playlist_track.Song_ID=Song.Song_ID WHERE Playlist_track.Playlist_ID=?";
            Statement statement = connection.createStatement();

            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {

                    Integer id = resultSet.getInt("Song_ID");
                    String Title = resultSet.getString("Title");
                    Song son = new Song(id,Title);
                    NewSongList.add(son);
                }
                return NewSongList;

            }
        } return null;

    }
}
