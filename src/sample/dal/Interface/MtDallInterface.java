package sample.dal.Interface;

import sample.be.Genre;
import sample.be.Playlist;
import sample.be.Song;

import java.util.List;

public interface MtDallInterface {

    Song createSong(int id, String title, String artist, String category, String duration);

    void updateSong(Song song);

    void deleleMovie(Song song);

    void createGenre(Genre genre);

    void deleteGenre(Genre genre);

    List<Song> getAllSongs();

    List<Playlist> getAllPlaylists();

    List<Genre> getAllGenres();

    Song getMovie(int id);

    List<Playlist> getPlaylist(Song song);

    List<Song> getGenres(Song song);

}
