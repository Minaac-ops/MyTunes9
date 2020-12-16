package sample.bll;


import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Playlist;
import sample.be.Song;
import sample.bll.util.SongSearcher;
import sample.dal.DalController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MyTunesManager implements LogicFacade {


    private final DalController dalController;

    public MyTunesManager() throws IOException, SQLServerException {
            dalController = new DalController();
    }

    /**
     * Gets a list of all songs from the database.
     * @return a list of songs.
     */
    @Override
    public List<Song> getAllSongs() throws SQLException {
        return dalController.getAllSongs();
    }

    /**
     * Creates a new song to the database.
     * @param songTitle
     * @param artist
     * @param category
     * @param duration
     * @return The new song.
     */
    @Override
    public Song createSong(String songTitle, String artist, String category, int duration, String path) throws SQLException, IOException {
        return dalController.createSong(songTitle, artist, category, duration, path);
    }

    /**
     * Deletes a song from the database.
     *
     * @param songToDelete
     */
    @Override
    public void deleteSong(Song songToDelete) {
        if (songToDelete != null) {
            dalController.deleteSong(songToDelete);
        }
    }

    /**
     * Updates a song in the database.
     * @param songToUpdate
     * @param songTitle
     * @param artist
     * @param category
     * @param duration
     * @param path
     * @return The updated song.
     */
    @Override
    public Song updateSong(Song songToUpdate, String songTitle, String artist, String category, int duration, String path) throws SQLException {
        return dalController.updateSong(songToUpdate, songTitle, artist, category, duration, path);
    }

    /**
     * Creates a new playlist to the database.
     *
     * @param name
     * @return A new empty playlist with the given name.
     */
    @Override
    public Playlist createPlaylist(String name) throws SQLException {
        return dalController.createPlaylist(name);
    }

    /**
     * Gets a list of all the playlists from the database.
     * @return List of all playlists from the database.
     */
    @Override
    public List<Playlist> getAllPlaylists() throws SQLException {
       return dalController.getAllPlaylists();
    }

    /**
     * Deletes the chosen playlist from the database.
     * @param playToDelete
     */
    @Override
    public void deletePlaylist(Playlist playToDelete) throws SQLException {
        if (playToDelete != null) {
            dalController.deletePlaylist(playToDelete);
        }
    }

    /**
     * updates the name of a playlist to the database.
     * @param name
     * @param text
     * @return The playlist with the new name.
     */
    @Override
    public Playlist editPlaylist(Playlist name, String text) {
        return null;
    }

    /**
     * Adds a new song to the playlist to be saved in the database.
     *
     * @param playlist
     * @param song
     * @return
     */
    @Override
    public Song addToPlaylist(Playlist playlist, Song song) {
        return null;
    }


    /**
     * Search for all Songs that matches the search.
     *
     * @param query
     * @return
     */
    @Override
    public List<Song> searchSong(String query) throws SQLException {
        List<Song> allSongs = getAllSongs();
        allSongs = SongSearcher.search(allSongs, query);
        return allSongs;
    }
}