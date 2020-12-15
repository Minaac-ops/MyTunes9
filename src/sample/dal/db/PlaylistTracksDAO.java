package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Playlist;
import sample.be.Song;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistTracksDAO {

    private MyDatabaseConnector databaseConnector;

    private final JDBCConnectionPool connectionPool;

    public PlaylistTracksDAO() throws IOException, SQLServerException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

    public List<Song> getPlaylistSongs(int id) throws SQLException {
        List<Song> newSongList = new ArrayList();
        try (Connection con = connectionPool.checkOut()) {
        String query = "SELECT * FROM playListSongs INNER JOIN Songs ON playListSongs.IDSong = Songs.ID_Song WHERE playListSongs.IDPlaylist = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Song son = new Song(rs.getInt("IDSong"), rs.getString("Title"), rs.getString("Artist"), rs.getString("Category"), rs.getInt("Time"), rs.getString("url"));
                newSongList.add(son);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newSongList;
    }
}