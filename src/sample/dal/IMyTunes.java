package sample.dal;

import sample.be.Category;
import sample.be.Playlist;
import sample.be.Song;

import java.util.List;

public interface IMyTunes {

    Song createSong(int id, String title, String artist, String category, String duration);

    void updateSong(Song song);

    void deleleMovie(Song song);

    void createGenre(Category category);

    void deleteGenre(Category category);

    List<Song> getAllSongs();

    List<Playlist> getAllPlaylists();

    List<Category> getAllGenres();

    Song getMovie(int id);

    List<Playlist> getPlaylist(Song song);

    List<Song> getGenres(Song song);

}
