package sample.bll;


import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.ObservableList;
import sample.be.Playlist;
import sample.be.Song;
import sample.dal.DalController;
import sample.dal.IMyTunes;
import sample.dal.db.PlaylistDAO;
import sample.dal.db.SongDAO;
import sample.gui.model.SongModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MyTunesManager implements LogicFacade {

    private final SongDAO songDAO;
    private PlaylistDAO playlistDAO;

    public MyTunesManager() throws IOException, SQLServerException {
            songDAO = new SongDAO();
            playlistDAO = new PlaylistDAO();
    }

    /**
     * Gets a list of all songs.
     *
     * @return a list of songs.
     */
    @Override
    public List<Song> getAllSongs() throws SQLException {
        return songDAO.getAllSongs();
    }

    /**
     * Creates a new song.
     *
     * @param id
     * @param songTitle
     * @param artist
     * @param category
     * @param duration
     * @return The new song.
     */
    @Override
    public Song createSong(int id, String songTitle, String artist, String category, String duration) {
        return null;
    }

    /**
     * Deletes a song.
     *
     * @param songToDelete
     */
    @Override
    public void deleteSong(Song songToDelete) {

    }

    /**
     * Updates a song.
     *
     * @param songToDelete
     * @param id
     * @param songTitle
     * @param artist
     * @param category
     * @param duration
     * @return The updated song.
     */
    @Override
    public Song updateSong(Song songToDelete, int id, String songTitle, String artist, String category, String duration) {
        return null;
    }

    /**
     * Search for all songs that matches the search.
     *
     * @param items
     * @param text
     * @return A list of the songs that matches the search.
     */
    @Override
    public ObservableList<Song> search(ObservableList<Song> items, String text) {
        return null;
    }

    /**
     * Gets a list og all songs.
     *
     * @return a list of all songs.
     */
    @Override
    public List<Playlist> getAllPlayLists() throws SQLException {

        return playlistDAO.getAllPlayLists();
    }

    /**
     * Creates a new playlist.
     *
     * @param name
     * @return A new empty playlist with the given name.
     */
    @Override
    public Playlist createPlaylist(String name) {
        return null;
    }

    /**
     * @return List of all playlists.
     */
    @Override
    public List<Playlist> getAllPlaylists() {
        return null;
    }

    /**
     * Deletes the chosen playlist.
     *
     * @param name
     */
    @Override
    public void deletePlaylist(Playlist name) {

    }

    /**
     * Edit the name of a playlist
     *
     * @param name
     * @param text
     * @return The playlist with the new name.
     */
    @Override
    public Playlist editPlaylist(Playlist name, String text) {
        return null;
    }

    /**
     * Adds a new song to the playlist.
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
     * Gets a list of all categories.
     *
     * @return
     */
    @Override
    public List<String> getAllCategories() {
        return null;
    }
}