package sample.bll.manager;


import sample.be.Category;
import sample.be.Song;
import sample.bll.LogicFacade;

import java.util.List;

public class MyTunesManager implements LogicFacade {

    /**
     * Gets a list of the songs.
     *
     * @param
     */
    @Override
    public List<Song> getAllSongs() {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    /**
     * Gets all songs on selected playlist
     */
    @Override
    public List<Song> getAllSongsOnSelectedPlaylist() {
        return null;
    }

    /**
     * Gets a list of all songs sorted by their genre.
     *
     * @param category
     */
    @Override
    public List<Song> getSpecificGenre(Category category) {
        return null;
    }

    /**
     * Searches for all songs that matches the given query.
     *
     * @param query
     */
    @Override
    public List<Song> searchSongs(String query) {
        return null;
    }

    /**
     * Create and add a new mocie to the system storage.
     *
     * @param title
     * @param artist
     * @param category
     * @param duration
     */


    public Song createSong(int id, String title, String artist, String category, String duration) {
        return null;
    }

    /**
     * Update the saved version of the song to the values in the given one.
     *
     * @param song
     */
    @Override
    public void updateSong(Song song) {

    }

    /**
     * Deletes the given movie from storage.
     *
     * @param song The song to delete.
     */
    @Override
    public void deleteSong(Song song) {

    }
}
