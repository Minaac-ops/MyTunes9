package sample.gui.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Song;
import sample.bll.LogicFacade;
import sample.bll.MyTunesManager;

import java.io.IOException;
import java.sql.SQLException;

public class SongModel {

    private ObservableList<Song> allSongs = FXCollections.observableArrayList();
    private LogicFacade logiclayer;

    public SongModel() throws SQLException, IOException {
        logiclayer = new MyTunesManager();
    }

    public ObservableList<Song> getAllSongs() throws SQLException {
        allSongs = FXCollections.observableArrayList();
        allSongs.addAll(logiclayer.getAllSongs());
        return allSongs;
    }
}
