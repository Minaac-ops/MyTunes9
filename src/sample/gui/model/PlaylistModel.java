package sample.gui.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Playlist;
import sample.be.Song;
import sample.bll.LogicFacade;
import sample.bll.MyTunesManager;

import java.io.IOException;
import java.sql.SQLException;

public class PlaylistModel {
    private ObservableList<Playlist> playlists;
    private LogicFacade logiclayer;

    public PlaylistModel() throws SQLException, IOException{
        logiclayer = new MyTunesManager();
        playlists = FXCollections.observableArrayList();
        playlists.addAll(logiclayer.getAllPlaylists());
    }

    /**
     * Gets a list of all the playlists.
     * @return
     * @throws SQLException
     */
    public ObservableList<Playlist> getPlaylists()throws SQLException {
        return playlists;
    }

    /**
     * creates a new playlists with a name.
     * @param name
     * @throws SQLException
     */
    public void createPlaylist(String name) throws SQLException {
        Playlist playlist = logiclayer.createPlaylist(name);
        playlists.add(playlist);
    }


    public void  editPlaylist(Playlist play, String name)
    {
        logiclayer.editPlaylist(play, name);
    }

    /**
     * Lets you delete a playlist.
     * @param playlistToDelete
     * @throws SQLException
     */
    public void deletePlaylist(Playlist playlistToDelete) throws SQLException {
        logiclayer.deletePlaylist(playlistToDelete);
        playlists.remove(playlistToDelete);
    }

    /**
     * Add a song from the songlist to the chosen playlist.
     * @param playlist
     * @param song
     * @return
     */
    public Song addToPlaylist(Playlist playlist, Song song) {
        return logiclayer.addToPlaylist(playlist, song);
    }
}






