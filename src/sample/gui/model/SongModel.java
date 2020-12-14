package sample.gui.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;
import sample.be.Song;
import sample.bll.LogicFacade;
import sample.bll.MyTunesManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SongModel {


    private ObservableList<Song> allSongs = FXCollections.observableArrayList();
    private LogicFacade logiclayer;

    public SongModel() throws SQLException, IOException {
        allSongs = FXCollections.observableArrayList();
        logiclayer = (LogicFacade) new MyTunesManager();
    }

    public ObservableList<Song> getAllSongs() throws SQLException {
        allSongs = FXCollections.observableArrayList();
        allSongs.addAll(logiclayer.getAllSongs());
        return allSongs;
    }

    public void serchSongs(String query) throws SQLException {
        if (query != null)
        {
            List<Song> searchedSongs = logiclayer.searchSong(query);
            allSongs.clear();
            allSongs.addAll(searchedSongs);
        }
    }

    public void deleteSong(Song song) {
        logiclayer.deleteSong(song);
        allSongs.remove(song);
    }
}
