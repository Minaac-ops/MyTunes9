package sample.gui.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.be.Playlist;
import sample.be.Song;
import sample.gui.model.PlaylistModel;
import sample.gui.model.SongModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {



    private SongModel songModel;
    private ObservableList<Song> observableListSong;

    private PlaylistModel playlistModel;
    private ObservableList<Playlist> observableListPlaylist;
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
    @FXML
    private TableView lstPlaylist;
    @FXML
    private TableColumn<Playlist, Integer> PlaylistTitleColumn;
    @FXML
    private TableColumn<Playlist, String> PlaylistSongColumn;
    //@FXML
    //private TableColumn<Playlist, String> PlaylistTimeColumn;


    public MainViewController() throws IOException, SQLException {
            songModel = new SongModel();
            playlistModel = new PlaylistModel();
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
            observableListPlaylist = playlistModel.getPlaylists();
            observableListSong = songModel.getAllSongs();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        songTitleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        songArtistColumn.setCellValueFactory(new PropertyValueFactory<>("Artist"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
        songTimeColumn.setCellValueFactory(new PropertyValueFactory<>("Duration"));


        lstSongs.setItems(observableListSong);

        try {
            observableListPlaylist = playlistModel.getPlaylists();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PlaylistTitleColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        PlaylistSongColumn.setCellValueFactory(new PropertyValueFactory<>("songs"));
       // PlaylistTimeColumn.setCellValueFactory(new PropertyValueFactory<>("Time"));
        lstPlaylist.setItems(observableListPlaylist);
    }

    @FXML
    public void newSongbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/gui/view/NewSong.fxml"));
        Scene scene = new Scene(root);

        Stage window = new Stage();

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void editSongbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/gui/view/NewSong.fxml"));
        Scene scene = new Scene(root);

        Stage window = new Stage();

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void newPlaylistbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/gui/view/NewPlaylist.fxml"));
        Scene scene = new Scene(root);

        Stage window = new Stage();

        window.setScene(scene);
        window.show();
    }

    @FXML
    public void editPlaylistbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/gui/view/NewPlaylist.fxml"));
        Scene scene = new Scene(root);

        Stage window = new Stage();

        window.setScene(scene);
        window.show();
    }
}