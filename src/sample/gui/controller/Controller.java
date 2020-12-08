package sample.gui.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.be.Song;
import sample.gui.model.SongModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private SongModel songModel;
    private ObservableList<Song> observableListSong;

    @FXML
    private TableView<Song> lstSongs;
    @FXML
    private TableColumn<Song, String> songTitleColumn;
    @FXML
    private TableColumn<Song, String> songArtistColumn;
    @FXML
    private TableColumn<Song, String> categoryColumn;
    @FXML
    private TableColumn<Song, String> songTimeColumn;


    public Controller() throws IOException, SQLException {
            songModel = new SongModel();
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
        try {
            observableListSong = songModel.getAllSongs();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        songTitleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        songArtistColumn.setCellValueFactory(new PropertyValueFactory<>("Artist"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
        songTimeColumn.setCellValueFactory(new PropertyValueFactory<>("Duration"));

        lstSongs.setItems(observableListSong);

    }
}
