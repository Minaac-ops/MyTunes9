package sample.dal;

import sample.be.Playlist;
import sample.be.Song;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IMyTunes {

    /**
     * Create a new song to the database.
     * @param title
     * @param artist
     * @param category
     * @param duration
     * @param path
     * @return the new song in to the list.
     * @throws SQLException
     * @throws IOException
     */
    Song createSong(String title, String artist, String category, int duration, String path) throws SQLException, IOException;

    /**
     * Creates a new playlist to the database.
     * @param name
     * @return the new playlist.
     * @throws SQLException
     */
    Playlist createPlaylist(String name) throws SQLException;


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

    /**
     * Delete the chosen song from the database.
     * @param song the chosen song.
     */
    void deleteSong(Song song);

    /**
     * Gets a list of all the songs in the database.
     * @return The list of songs.
     * @throws SQLException
     */
    List<Song> getAllSongs() throws SQLException;

    /**
     * Gets a list of all the playlists in the database.
     * @return the list with playlists.
     * @throws SQLException
     */
    List<Playlist> getAllPlaylists() throws SQLException;

    /**
     * Gets a song from the database.
     * @param id
     * @return the song with the given id.
     */
    Song getSong(int id);

    /**
     * Count the total time of a playlists.
     * @param allSongs
     * @return the total time of a playlisy.
     */
    int countTotalTime(List<Song> allSongs);

    /**
     * Deletes a playlists from the database.
     * @param playlistToDelete
     * @throws SQLException
     */
    void deletePlaylist(Playlist playlistToDelete) throws SQLException;


    /**
     * Gets a list of Songs from the chosen playlist from the database.
     * @param IDD
     * @return
     */
    List<Song> getPlaylistSongs(int IDD) throws SQLException;

}
