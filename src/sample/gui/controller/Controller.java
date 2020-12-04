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
    private Button createSong;

    




}
