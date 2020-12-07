package sample.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Category;
import sample.be.Playlist;
import sample.be.Song;

import java.io.IOException;
import java.util.List;

public class DalController implements IMyTunes {

    private IMyTunes songrepo;

    public DalController() throws IOException, SQLServerException {
        songrepo = new
    }

    @Override
    public Song createSong(int id, String title, String artist, String category, String duration) {
        return null;
    }

    @Override
    public void updateSong(Song song) {

    }

    @Override
    public void deleleMovie(Song song) {

    }

    @Override
    public void createGenre(Category category) {

    }

    @Override
    public void deleteGenre(Category category) {

    }

    @Override
    public List<Song> getAllSongs() {
        return null;
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return null;
    }

    @Override
    public List<Category> getAllGenres() {
        return null;
    }

    @Override
    public Song getMovie(int id) {
        return null;
    }

    @Override
    public List<Playlist> getPlaylist(Song song) {
        return null;
    }

    @Override
    public List<Song> getGenres(Song song) {
        return null;
    }
}
