package sample.dal;

import sample.be.Category;
import sample.be.Playlist;
import sample.be.Song;

import java.sql.SQLException;
import java.util.List;

public interface IMyTunes {

    Song createSong(int id, String title, String artist, String category, int duration, String path);

    void updateSong(Song song);

    void deleteSong(Song song);

    void createGenre(Category category);

    void deleteGenre(Category category);

    List<Song> getAllSongs() throws SQLException;

    List<Playlist> getAllPlaylists() throws SQLException;

    List<Category> getAllGenres();

    Song getSong(int id);

    List<Song> getGenres(Song song);

    /**
     * Searches for all songs that matches the query.
     * @param query
     * @return a list of songs that matches the query
     */
    List<Song> searchSong(String query) throws SQLException;

    int countTotalTime(List<Song> allSongs);
}
