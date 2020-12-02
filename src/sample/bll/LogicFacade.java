package sample.bll;

import sample.be.Genre;
import sample.be.Song;

import java.util.List;

public interface LogicFacade {


    /**
     * Gets a list of the songs with the given genre.
     *
     * @param
     * @return
     */
    List<Song> getAllSongs(Genre genre);

    List<Genre> getAllCategories();

    /**
     * Gets a list of all songs sorted by their genre.
     */
    List<Song> getSpecificGenre(Genre genre);

    /**
     * Searches for all songs that matches the given query.
     */
    List<Song> searchSongs(String query);

    /**
     * Create and add a new mocie to the system storage.
     */
    Song createSong(String title, String artist, String category, String duration);


    /**
     * Update the saved version of the song to the values in the given one.
     */
    void updateSong(Song song);

    /**
     * Deletes the given movie from storage.
     * @param song The song to delete.
     */
    void deleteSong(Song song);







}
