package sample.gui.controller;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.be.Playlist;
import sample.be.Song;
import sample.bll.BllException;
import sample.dal.DalException;
import sample.gui.model.PlaylistModel;
import sample.gui.model.SongModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private SongModel songModel;
    private PlaylistModel playlistModel;

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


    public Controller() throws IOException, SQLException, BllException, DalException {
        try {
            songModel = new SongModel();
        } catch (BllException ex) {
            displayError(ex);
            System.exit(0);
        }
    }


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param url  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param rb The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstSong.setItems(songModel.getAllSongs());

    }
}
