package sample.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.be.Playlist;
import sample.be.Song;
import sample.gui.model.SongModel;

import java.util.List;

public class Controller {

    private SongModel songModel;

    @FXML
    private ListView<Song> lstSong;
    @FXML
    private Button createSong;
    @FXML
    private Button updateSong;
    @FXML
    private Button deleteSong;
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
    private Button close;
    @FXML
    private Button skipBack;
    @FXML
    private Button playPause;
    @FXML
    private Button skipForward;
    @FXML
    private Button moveSong;
    @FXML
    private Slider volume;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private TextField txtCurrentlyPlaying;
    @FXML
    private TextField txtFilter;






}
