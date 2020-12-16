package sample.dal;

import sample.be.Playlist;
import sample.be.Song;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IMyTunes {

    Song createSong(String title, String artist, String category, int duration, String path) throws SQLException, IOException;


    /**
     * @param songToUpdate
     * @param title
     * @param artist
     * @param category
     * @param duration
     * @param path
     * @return
     * @throws SQLException
     */
    Song updateSong(Song songToUpdate, String title, String artist, String category, int duration, String path) throws SQLException;

    void deleteSong(Song song);

    List<Song> getAllSongs() throws SQLException;

    List<Playlist> getAllPlaylists() throws SQLException;

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
