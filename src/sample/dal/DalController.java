package sample.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Playlist;
import sample.be.Song;
import sample.bll.util.SongSearcher;
import sample.dal.db.PlaylistDAO;
import sample.dal.db.PlaylistTracksDAO;
import sample.dal.db.SongDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DalController implements IMyTunes {

    private SongDAO songrepo;
    private PlaylistDAO playlistRepo;
    private PlaylistTracksDAO playSongRepo;

    public DalController() throws IOException, SQLServerException {
        songrepo = new SongDAO();
        playlistRepo = new PlaylistDAO();
        playSongRepo = new PlaylistTracksDAO();
    }

    @Override
    public List<Song> getAllSongs() throws SQLException {
        List<Song> allSongs;
        allSongs = songrepo.getAllSongs();
        return allSongs;
    }

    @Override
    public Song createSong(String title, String artist, String category, int duration, String path) throws SQLException, IOException {
        return songrepo.createSong(title, artist, category, duration, path);
    }

    @Override
    public Song updateSong(Song songToUpdate, String title, String artist, String category, int duration, String path) throws SQLException {
        return songrepo.updateSong(songToUpdate, title, artist, category, duration, path);
    }

    @Override
    public void deleteSong(Song song) {
        songrepo.deleteSong(song);
    }

    @Override
    public List<Playlist> getAllPlaylists() throws SQLException {
        List<Playlist> playlistList;
        playlistList = playlistRepo.getAllPlayLists();
        return playlistList;
    }

    public void deletePlaylist(Playlist playlistToDelete) throws SQLException {
        playlistRepo.deletePlaylist(playlistToDelete);
    }

    /**
     * Gets a list of Songs from the chosen playlist from the database.
     *
     * @param IDD
     * @return
     */
    @Override
    public List<Song> getPlaylistSongs(int IDD) throws SQLException {
        return playSongRepo.getPlaylistSongs(IDD);
    }

    @Override
    public int countTotalTime(List<Song> allSongs) {
        return playlistRepo.countTotalTime(allSongs);
    }

    @Override
    public Playlist createPlaylist(String name) throws SQLException{
        return playlistRepo.createPlaylist(name);
    }

    @Override
    public Song getSong(int id) {
        return null;
    }

    /**
     * Searches for all songs that matches the query.
     *
     * @param query
     * @return a list of songs that matches the query
     */
    @Override
    public List<Song> searchSong(String query) throws SQLException {
        List<Song> allSongs = getAllSongs();
        allSongs = SongSearcher.search(allSongs, query);
        return allSongs;
    }
}
