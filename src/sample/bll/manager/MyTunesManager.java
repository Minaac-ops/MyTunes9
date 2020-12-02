package sample.bll.manager;


import sample.be.Genre;
import sample.be.Song;
import sample.bll.LogicFacade;
import sample.dal.Interface.MtDallInterface;

import java.util.List;

public class MyTunesManager implements LogicFacade {

    /**
     * Gets a list of the songs with the given genre.
     *
     * @param genre@return
     */
    @Override
    public List<Song> getAllSongs(Genre genre) {
        return null;
    }

    @Override
    public List<Genre> getAllCategories() {
        return null;
    }

    /**
     * Gets a list of all songs sorted by their genre.
     *
     * @param genre
     */
    @Override
    public List<Song> getSpecificGenre(Genre genre) {
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
    @Override
    public Song createSong(String title, String artist, String category, String duration) {
        try {
            retu
        }
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
