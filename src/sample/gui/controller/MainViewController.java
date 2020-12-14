package sample.gui.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import sample.be.Playlist;
import sample.be.Song;
import sample.bll.LogicFacade;
import sample.gui.model.PlaylistModel;
import sample.gui.model.SongModel;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

        private ObservableList<Song> songs;
        private LogicFacade logicFacade;
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
        @FXML
        private Button playButton;
        @FXML
        private Label currentSong;
        @FXML
        private Slider volumeSlider;

        private MediaPlayer mediaPlayer;
        private int currentSongPlaying = 0;


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
        private void playSong(ActionEvent event) {
            if (mediaPlayer == null && lstSongsInPlayList.getSelectionModel().getSelectedIndex() != -1) {
                currentSongPlaying = lstSongsInPlayList.getSelectionModel().getSelectedIndex();
                play();
            } else {
                currentSong.setText("(none) is now playing");
                playButton.setText("⏵");
                stopMediaPlayer();
                mediaPlayer = null;
            }
        }

        private void play() {
            playButton.setText("||");
            mediaPlayer = new MediaPlayer(new Media(new File(lstSongsInPlayList.getItems().get(currentSongPlaying).getPath()).toURI().toString()));
            lstSongsInPlayList.getSelectionModel().clearAndSelect(currentSongPlaying);
            currentSong.setText(lstSongsInPlayList.getItems().get(currentSongPlaying).getTitle() + " is now playing");
            mediaPlayer.play();
            makeSound();
            mediaPlayer.setOnEndOfMedia(() -> {
                if (lstSongsInPlayList.getSelectionModel().getSelectedIndex() != -1) {
                    if (lstSongsInPlayList.getItems().size() == currentSongPlaying + 1) {
                    currentSongPlaying = 0;
                } else {
                    currentSongPlaying++;
                }
                play();
            } else {
                stopMediaPlayer();
            }
        });
        }

        private void stopMediaPlayer() {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                currentSong.setText("(none) is playing");
                playButton.setText("⏵");
                mediaPlayer = null;
            }
        }

        private void makeSound() {
            mediaPlayer.setVolume(volumeSlider.getValue());
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

        @FXML
        private void handleDeleteSong(ActionEvent event) {
            Song selectedSong = lstSongs.getSelectionModel().getSelectedItem();
            songModel.deleteSong(selectedSong);
        }


}