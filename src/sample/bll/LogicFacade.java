package sample.bll;

import javafx.collections.ObservableList;
import sample.be.Playlist;
import sample.be.Song;

import java.sql.SQLException;
import java.util.List;

public interface LogicFacade {

    /**
     * Gets a list of all songs.
     * @return a list of songs.
     */
    public List<Song> getAllSongs() throws SQLException;

    /**
     * Creates a new song.
     * @param id
     * @param songTitle
     * @param artist
     * @param category
     * @param duration
     * @return The new song.
     */
    public Song createSong(int id, String songTitle, String artist, String category, String duration);

    /**
     * Deletes a song.
     * @param songToDelete
     */
    public void deleteSong(Song songToDelete);

    /**
     * Updates a song.
     * @param songToDelete
     * @param id
     * @param songTitle
     * @param artist
     * @param category
     * @param duration
     * @return The updated song.
     */
    public Song updateSong(Song songToDelete, int id, String songTitle, String artist, String category, String duration);

    /**
     * Search for all songs that matches the search.
     * @param items
     * @param text
     * @return A list of the songs that matches the search.
     */
    public ObservableList<Song> search(ObservableList<Song> items, String text);

    /**
     * Gets a list og all songs.
     * @return a list of all songs.
     */
    public List<Playlist> getAllPlayLists() throws SQLException;

    /**
     * Creates a new playlist.
     * @param name
     * @return A new empty playlist with the given name.
     */
    public Playlist createPlaylist(String name);

    /**
     *
     * @return List of all playlists.
     */
    public List<Playlist> getAllPlaylists();

    /**
     * Deletes the chosen playlist.
     * @param name
     */
    public void deletePlaylist(Playlist name);

    /**
     * Edit the name of a playlist
     * @param name
     * @param text
     * @return The playlist with the new name.
     */
    public Playlist editPlaylist(Playlist name, String text);

    /**
     * Adds a new song to the playlist.
     * @param playlist
     * @param song
     * @return
     */
    public Song addToPlaylist(Playlist playlist, Song song);

    /**
     * Gets a list of all categories.
     * @return
     */
    public List<String> getAllCategories();


}

