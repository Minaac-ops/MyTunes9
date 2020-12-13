package sample.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Category;
import sample.be.Playlist;
import sample.be.Song;
import sample.bll.util.SongSearcher;
import sample.dal.db.PlaylistDAO;
import sample.dal.db.SongDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DalController implements IMyTunes {

    private SongDAO songrepo;
    private PlaylistDAO playlistRepo;

    public DalController() throws IOException, SQLServerException {
        songrepo = new SongDAO();
        playlistRepo = new PlaylistDAO();
    }

    @Override
    public Song createSong(int id, String title, String artist, String category, int duration, String path) {
        return null;
    }

    @Override
    public void updateSong(Song song) {

    }

    @Override
    public void deleteSong(Song song) {

    }

    @Override
    public void createGenre(Category category) {

    }

    @Override
    public void deleteGenre(Category category) {

    }

    @Override
    public List<Song> getAllSongs() throws SQLException {
        List<Song> allSongs;
        allSongs = songrepo.getAllSongs();
        return allSongs;
    }

    @Override
    public List<Playlist> getAllPlaylists() throws SQLException {
        List<Playlist> playlistList;
        playlistList = playlistRepo.getAllPlayLists();
        return playlistList;
    }

    @Override
    public List<Category> getAllGenres() {
        return null;
    }

    @Override
    public Song getSong(int id) {
        return null;
    }


    @Override
    public List<Song> getGenres(Song song) {
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

    @Override
    public int countTotalTime(List<Song> allSongs) {
        return playlistRepo.countTotalTime(allSongs);
    }
}
