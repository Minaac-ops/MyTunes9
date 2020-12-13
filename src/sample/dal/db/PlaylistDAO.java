package sample.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Playlist;
import sample.be.Song;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {

    PlaylistTracksDAO playlistTracksDAO = new PlaylistTracksDAO();

    private final JDBCConnectionPool connectionPool;

    public PlaylistDAO() throws IOException, SQLServerException {
        connectionPool = JDBCConnectionPool.getInstance();
    }

    public List<Playlist> getAllPlayLists() throws SQLException {
        List<Playlist> allPlayLists = new ArrayList<>();
        Connection con = connectionPool.checkOut();

        try (Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Playlist");

                while (rs.next()) {

                    String name = rs.getString("Name");
                    Integer id = rs.getInt("ID_Playlist");
                    List<Song> allSongs = playlistTracksDAO.getPlaylistSongs(id);
                    Playlist playlist = new Playlist(name, id, allSongs.size(), countTotalTime(allSongs));
                    playlist.setSongList(allSongs);
                    allPlayLists.add(playlist);
                }
            } return allPlayLists;
        }

    public int countTotalTime(List<Song> allSongs)
    {
        int totalTime = 0;
        for (Song allSong : allSongs) {
            totalTime += allSong.getDuration();
        }
        return totalTime;
    }
}
