package sample.dal;

import sample.be.Playlist;
import sample.be.Song;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IMyTunes {

    /**
     * Gets the list of all songs in the database.
     * @return the list of all songs, with all the columns in the Songs table.
     * @throws SQLException
     */
    List<Song> getAllSongs() throws SQLException;

    /**
     * creates a new song to the database.
     * @param title
     * @param artist
     * @param category
     * @param duration
     * @param path
     * @return the new song object with all the given parameters.
     * @throws SQLException
     * @throws IOException
     */
    Song createSong(String title, String artist, String category, int duration, String path) throws SQLException, IOException;

    /**
     * updates the values you'd like to update.
     * @param songToUpdate
     * @param title
     * @param artist
     * @param category
     * @param duration
     * @param path
     * @return the updated song object.
     * @throws SQLException
     */
    Song updateSong(Song songToUpdate, String title, String artist, String category, int duration, String path) throws SQLException;

    /**
     * Deletes a song from the database.
     * @param songToDelete
     */
    void deleteSong(Song songToDelete);

    /**
     * Get the list of playlists from the database
     * @return the new playlist with a new name and id.
     * @throws SQLException
     */
    List<Playlist> getAllPlaylists() throws SQLException;

    /**
     * Deleting a playlist from the database with the chosen id.
     * @param playlistToDelete
     * @throws SQLException
     */
    void deletePlaylist(Playlist playlistToDelete) throws SQLException;

    /**
     * Gets a list of all the songs of a playlist by using inner join.
     * @param IDD
     * @return a list of songs, where IDSong from the playlistsongs tabel mathces the ID_Song from the songs tabel in the database.
     * @throws SQLException
     */
    List<Song> getPlaylistSongs(int IDD) throws SQLException;

    /**
     * Counts the total time in seconds of the playlists, by adding together the duration of the songs.
     * @param allSongs
     * @return the total time of the playlists.
     */
    int countTotalTime(List<Song> allSongs);

    /**
     * Creating a new playlist in the database.
     * @param name
     * @return the new playlist with a chosen and a id, totaltime and songcount wich is both 0 to begin with because
     * there is now songs in the playlist yet.
     * @throws SQLException
     */
    Playlist createPlaylist(String name) throws SQLException;

    /**
     * Get a specific song using the id.
     * @param id
     * @return the chosen song.
     */
    Song getSong(int id);

    /**
     * Adds the chosen song to the playlist.
     * @param playlist
     * @param song
     * @return
     */
    Song addToPlaylist(Playlist playlist, Song song);

}
