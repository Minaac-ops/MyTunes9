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
import javafx.scene.control.TextField;
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


        private final SongModel songModel;
        private ObservableList<Song> observableListSong;

        private final PlaylistModel playlistModel;
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
        private TableColumn<Song, Integer> songTimeColumn;
        @FXML
        private TextField txtSongSearch;
        @FXML
        private TableView<Playlist> lstPlaylist;
        @FXML
        private TableColumn<Playlist, String> playlistNameColumn;
        @FXML
        private TableColumn<Playlist, Integer> playlistCount;
        @FXML
        private TableColumn<Playlist, Integer> playlistTimeColumn;
        @FXML
        private TableView<Song> lstSongsInPlayList;
        @FXML
        private TableColumn<Song, String> nameOnSongPlay;
        @FXML
        private TableColumn<Song, Integer> idOnSongPlay;


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

            lstSongs.setItems(observableListSong);
            songTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            songArtistColumn.setCellValueFactory(new PropertyValueFactory<>("Artist"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
            songTimeColumn.setCellValueFactory(new PropertyValueFactory<>("Duration"));

            lstPlaylist.setItems(observableListPlaylist);
            playlistNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
            playlistTimeColumn.setCellValueFactory(new PropertyValueFactory<>("totalTime"));
            playlistCount.setCellValueFactory(new PropertyValueFactory<>("songCount"));

            lstSongsInPlayList.setItems(observableListSong);
            nameOnSongPlay.setCellValueFactory(new PropertyValueFactory<>("title"));
            idOnSongPlay.setCellValueFactory(new PropertyValueFactory<>("id"));
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
        private void handleSearchSongs(ActionEvent event) throws SQLException {
            String query = txtSongSearch.getText().trim();
            songModel.serchSongs(query);
            }
        }
