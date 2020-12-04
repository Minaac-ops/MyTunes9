package sample.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.be.Playlist;
import sample.be.Song;
import sample.gui.model.SongModel;

import java.util.List;

public class Controller {

    private SongModel songModel;

    @FXML
    private ListView<Song> lstSong;
    @FXML
    private ListView<Playlist> lstPlaylist;
    @FXML
    private Button newPlaylist;
    @FXML
    private Button editPlaylist;
    @FXML
    private Button deletePlaylist;
    @FXML
    private Button buttonUp;
    @FXML
    private Button buttonDown;
    @FXML
    private Button newSong;
    @FXML
    private Button editSong;
    @FXML
    private Button deleteSong;
    @FXML
    private Button close;
    @FXML
    private Button skipBack;
    @FXML
    private Button playPause;
    @FXML
    private Button skipForward;
    @FXML
    private Button moveSong;

    




}
