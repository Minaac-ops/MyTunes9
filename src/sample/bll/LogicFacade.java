package sample.bll;

import sample.be.Playlist;
import sample.be.Song;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface LogicFacade {

    /**
     * Gets a list of all songs from the database.
     * @return a list of songs.
     */
    List<Song> getAllSongs() throws SQLException;

    /**
     * Creates a new song to the database.
     * @param songTitle
     * @param artist
     * @param category
     * @param duration
     * @return The new song.
     */
    Song createSong(String songTitle, String artist, String category, int duration, String path) throws SQLException, IOException;

    /**
     * Deletes a song from the database.
     *
     * @param songToDelete
     */
    void deleteSong(Song songToDelete);

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
    Song updateSong(Song songToUpdate, String songTitle, String artist, String category, int duration, String path) throws IOException, SQLException;

    /**
     * Creates a new playlist to the database.
     *
     * @param name
     * @return A new empty playlist with the given name.
     */
    Playlist createPlaylist(String name) throws SQLException;

    /**
     * Gets a list of all the playlists from the database.
     * @return List of all playlists from the database.
     */
    List<Playlist> getAllPlaylists() throws SQLException;

    /**
     * Deletes the chosen playlist from the database.
     * @param playToDelete
     */
    void deletePlaylist(Playlist playToDelete) throws SQLException;

    /**
     * updates the name of a playlist to the database.
     * @param name
     * @param text
     * @return The playlist with the new name.
     */
    Playlist editPlaylist(Playlist name, String text);

    /**
     * Adds a new song to the playlist to be saved in the database.
     *
     * @param playlist
     * @param song
     * @return
     */
    Song addToPlaylist(Playlist playlist, Song song);

    /**
     * Search for all Songs that matches the search.
     * @param query
     * @return
     */
    List<Song> searchSong(String query) throws SQLException;


}

