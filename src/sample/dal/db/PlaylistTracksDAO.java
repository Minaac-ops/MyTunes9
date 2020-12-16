package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerException;
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

    /**
     * Gets a list of all the songs of a playlist by using inner join.
     * @param IDD
     * @return a list of songs, where IDSong from the playlistsongs tabel mathces the ID_Song from the songs tabel in the database.
     * @throws SQLException
     */
    public List<Song> getPlaylistSongs(int IDD) throws SQLException {
        List<Song> newSongList = new ArrayList();
        try (Connection con = connectionPool.checkOut()) {
        String query = "SELECT * FROM playListSongs INNER JOIN Songs ON playListSongs.IDSong = Songs.ID_Song WHERE playListSongs.IDPlaylist = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, IDD);
        ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Song son = new Song(rs.getInt("id"), rs.getString("Title"), rs.getString("Artist"), rs.getString("Category"), rs.getInt("Time"), rs.getString("url"));
                son.setIDD(rs.getInt("id"));
                newSongList.add(son);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newSongList;
    }
}