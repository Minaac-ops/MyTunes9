package sample.dal;

import sample.be.Song;

import java.util.List;

public interface ISongRepository {


    /**
     * Creates a song.
     *
     * @param title
     * @param artist
     * @param category
     * @param duration
     * @return The object representation of the movie added to the persistance storage.
     */
    Song createSong(String title, String artist, String category, String duration);

    /**
     * Deletes a song from the persistance storage.
     * @param song
     */
    void deleteSong(Song song);

    /**
     * Gets a list of all songs in the persistence storage.
     * @return A List of all songs.
     */
    List<Song> getAllSongs();


    /**
     * Gets the song with the given ID
     * @param id ID of the song.
     * @return A song object
     */
    Song getSong(int id);

    /**
     * Updates the song in the persistence storage
     * to reflect the values in the given song object.
     * @param song
     */
    void updateSong(Song song);
}
