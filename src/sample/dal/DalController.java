package sample.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import sample.be.Playlist;
import sample.be.Song;
import sample.dal.db.PlaylistDAO;
import sample.dal.db.PlaylistTracksDAO;
import sample.dal.db.SongDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DalController implements IMyTunes {

    private SongDAO songrepo;
    private PlaylistDAO playlistRepo;
    private PlaylistTracksDAO playSongRepo;

    public DalController() throws IOException, SQLServerException {
        songrepo = new SongDAO();
        playlistRepo = new PlaylistDAO();
        playSongRepo = new PlaylistTracksDAO();
    }

    /**
     * Gets the list of all songs in the database.
     * @return the list of all songs, with all the columns in the Songs table.
     * @throws SQLException
     */
    @Override
    public List<Song> getAllSongs() throws SQLException {
        List<Song> allSongs;
        allSongs = songrepo.getAllSongs();
        return allSongs;
    }

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
    @Override
    public Song createSong(String title, String artist, String category, int duration, String path) throws SQLException, IOException {
        return songrepo.createSong(title, artist, category, duration, path);
    }

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
    @Override
    public Song updateSong(Song songToUpdate, String title, String artist, String category, int duration, String path) throws SQLException {
        return songrepo.updateSong(songToUpdate, title, artist, category, duration, path);
    }

    /**
     * Deletes a song from the database.
     * @param songToDelete
     */
    @Override
    public void deleteSong(Song songToDelete) {
        songrepo.deleteSong(songToDelete);
    }

    /**
     * Get the list of playlists from the database
     * @return the new playlist with a new name and id.
     * @throws SQLException
     */
    @Override
    public List<Playlist> getAllPlaylists() throws SQLException {
        List<Playlist> playlistList;
        playlistList = playlistRepo.getAllPlayLists();
        return playlistList;
    }

    /**
     * Deleting a playlist from the database with the chosen id.
     * @param playlistToDelete
     * @throws SQLException
     */
    public void deletePlaylist(Playlist playlistToDelete) throws SQLException {
        playlistRepo.deletePlaylist(playlistToDelete);
    }

    /**
     * Gets a list of all the songs of a playlist by using inner join.
     * @param IDD
     * @return a list of songs, where IDSong from the playlistsongs tabel mathces the ID_Song from the songs tabel in the database.
     * @throws SQLException
     */
    @Override
    public List<Song> getPlaylistSongs(int IDD) throws SQLException {
        return playSongRepo.getPlaylistSongs(IDD);
    }

    /**
     * Counts the total time in seconds of the playlists, by adding together the duration of the songs.
     * @param allSongs
     * @return the total time of the playlists.
     */
    @Override
    public int countTotalTime(List<Song> allSongs) {
        return playlistRepo.countTotalTime(allSongs);
    }

    /**
     * Creating a new playlist in the database.
     * @param name
     * @return the new playlist with a chosen and a id, totaltime and songcount wich is both 0 to begin with because
     * there is now songs in the playlist yet.
     * @throws SQLException
     */
    @Override
    public Playlist createPlaylist(String name) throws SQLException {
        return playlistRepo.createPlaylist(name);
    }

    /**
     * Get a specific song using the id.
     * @param id
     * @return the chosen song.
     */
    @Override
    public Song getSong(int id) {
        return null;
    }
}
