package sample.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Song;
import sample.bll.manager.MyTunesManager;
import sample.dal.db.MyDatabaseConnector;

public class SongModel {

    private ObservableList<Song> songs;

    public SongModel()
    {
        songs = FXCollections.observableArrayList();
    }

}
