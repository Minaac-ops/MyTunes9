package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Playlist;
import sample.be.Song;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {

    PlaylistTracksDAO playlistTracksDAO = new PlaylistTracksDAO();

    private final JDBCConnectionPool connectionPool;


    public PlaylistDAO() throws IOException, SQLServerException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

    /**
     * Get the list of playlists from the database
     * @return the new playlist with a new name and id.
     * @throws SQLException
     */
    public List<Playlist> getAllPlayLists() throws SQLException {
        List<Playlist> allPlayLists = new ArrayList<>();
        Connection con = connectionPool.checkOut();

        try (Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Playlist");

                while (rs.next()) {

                    String name = rs.getString("Name");
                    int id = rs.getInt("ID_Playlist");
                    List<Song> allSongs = playlistTracksDAO.getPlaylistSongs(id);
                    Playlist playlist = new Playlist(name, id, allSongs.size(), countTotalTime(allSongs));
                    playlist.setSongList(allSongs);
                    allPlayLists.add(playlist);
                }
        }return allPlayLists;
    }

    /**
     * Counts the total time in seconds of the playlists, by adding together the duration of the songs.
     * @param allSongs
     * @return the total time of the playlists.
     */
    public int countTotalTime(List<Song> allSongs)
    {
        int totalTime = 0;
        for (Song allSong : allSongs) {
            totalTime += allSong.getDuration();
        }
        return totalTime;
    }

    /**
     * Creating a new playlist in the database.
     * @param name
     * @return the new playlist with a chosen and a id, totaltime and songcount wich is both 0 to begin with because
     * there is now songs in the playlist yet.
     * @throws SQLException
     */
    public Playlist createPlaylist(String name) throws SQLException {
        String sql = "INSERT INTO Playlist(Name) VALUES (?);";
        try (Connection con = connectionPool.checkOut();
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, name);
            st.addBatch();
            st.executeBatch();
        }
        Playlist playlist = new Playlist(name, 0, 0, 0);
        return playlist;
    }

    /**
     * Deleting a playlist from the database with the chosen id.
     * @param playToDelete
     * @throws SQLException
     */
    public void deletePlaylist(Playlist playToDelete) throws SQLException {
        try (Connection con = connectionPool.checkOut()) {
        String query = "DELETE FROM Playlist WHERE ID_Playlist = ?;";
        PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, playToDelete.getId());
            preparedStatement.execute();
        }
    }
}
