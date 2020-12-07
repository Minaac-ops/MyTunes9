package sample.gui.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.be.Song;
import sample.bll.BllException;
import sample.bll.LogicFacade;
import sample.bll.MyTunesManager;
import sample.dal.DalException;

import java.io.IOException;
import java.sql.SQLException;

public class SongModel {

    private ObservableList<Song> songs;
    private LogicFacade logiclayer;

    public SongModel() throws BllException, SQLException, DalException {
        songs = FXCollections.observableArrayList();
        logiclayer = new MyTunesManager();
        songs.addAll(logiclayer.getAllSongs());
    }

    public ObservableList<Song> getAllSongs() throws DalException, SQLException, BllException {
        return songs;
    }

    }
