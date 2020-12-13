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
        logiclayer = (LogicFacade) new MyTunesManager();
    }

    public ObservableList<Playlist> getPlaylists()throws SQLException {
        playlists = FXCollections.observableArrayList();
        playlists.addAll(logiclayer.getAllPlayLists());
        return playlists;
    }
}






