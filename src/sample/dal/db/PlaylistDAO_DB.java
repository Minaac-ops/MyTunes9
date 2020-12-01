package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Playlist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO_DB {

    private MyDatabaseConnector myDatabaseConnector;

    public PlaylistDAO_DB() throws IOException, SQLServerException {
        myDatabaseConnector = new MyDatabaseConnector();
    }

    public List<Playlist> getAllPlayLists() throws SQLException {
        ArrayList<Playlist> allPlayLists = new ArrayList<>();

        try (Connection connection = myDatabaseConnector.getConnection()) {
            String sql = "SELECT * FROM Playlist";

            Statement statement = connection.createStatement();

            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    int songs = resultSet.getInt("Songs");
                    String duration = resultSet.getString("Duration");

                    Playlist playlist = new Playlist(name, songs, duration);
                    allPlayLists.add(playlist);
                }
            }
        } return allPlayLists;
    }
}