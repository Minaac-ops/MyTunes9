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
    List<Song> getAllSongs();

    List<Genre> getAllCategories();

    /**
     * Gets all songs on selected playlist
     *
     */
    List<Song> getAllSongsOnSelectedPlaylist();



    /**
     * Gets a list of all songs sorted by their genre.
     */
    List<Song> getSpecificGenre(Genre genre);

    /**
     * Searches for all songs that matches the given query.
     */
    List<Song> searchSongs(String query);

    /**
     * Create and add a new movie to the system storage.
     */
    Song createSong(int id, String title, String artist, String category, String duration);


    /**
     * Update the saved version of the song to the values in the given one.
     */
    void updateSong(Song selectedSong);

    /**
     * Deletes the given movie from storage.
     * @param song The song to delete.
     */
    void deleteSong(Song song);







}
