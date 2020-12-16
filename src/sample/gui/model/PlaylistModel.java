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

    public ObservableList<Playlist> getPlaylists()throws SQLException {
        return playlists;
    }

    public void createPlaylist(String name) throws SQLException {
        Playlist playlist = logiclayer.createPlaylist(name);
        playlists.add(playlist);
    }


    public void  editPlaylist(Playlist play, String name)
    {
        logiclayer.editPlaylist(play, name);
    }


    public void deletePlaylist(Playlist playlistToDelete) throws SQLException {
        logiclayer.deletePlaylist(playlistToDelete);
        playlists.remove(playlistToDelete);
    }
}






