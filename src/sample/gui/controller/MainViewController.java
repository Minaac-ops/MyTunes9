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
import sample.gui.model.PlaylistModel;
import sample.gui.model.SongModel;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private final SongModel songModel;
    private ObservableList<Song> observableListSong;

    private final PlaylistModel playlistModel;
    private ObservableList<Playlist> observableListPlaylist;
    private MediaPlayer mediaPlayer;
    private int currentSongPlaying = 0;

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
    private Label currentSong;
    @FXML
    private Slider volumeSlider;


    public MainViewController() throws IOException, SQLException {
        songModel = new SongModel();
        playlistModel = new PlaylistModel();
    }


    /**
     * * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param url The location used to resolve relative paths for the root object, or
     *            {@code null} if the location is not known.
     * @param rb  The resources used to localize the root object, or {@code null} if
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

        nameOnSongPlay.setCellValueFactory(new PropertyValueFactory<>("title"));
        idOnSongPlay.setCellValueFactory(new PropertyValueFactory<>("IDD"));
    }

    /**
     * The button to make the media start and plays the selected song.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handlePlaySong(ActionEvent event) throws IOException {
        if (mediaPlayer == null && lstSongsInPlayList.getSelectionModel().getSelectedIndex() != -1) {
            currentSongPlaying = lstSongsInPlayList.getSelectionModel().getSelectedIndex();
            play();
        } else {
            currentSong.setText("(none) is now playing");
            stopMediaPlayer();
            mediaPlayer = null;
        }
    }

    /**
     * Plays the media by getting the location of the media file of the selected song.
     *
     * @throws IOException
     */
    private void play() throws IOException {
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
                try {
                    play();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                stopMediaPlayer();
            }
        });
    }

    /**
     * Stops the mediaplayer.
     */
    private void stopMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            currentSong.setText("(none) is playing");
            mediaPlayer = null;
        }
    }

    /**
     * Before you play a song make sure to turn the volume up.
     */
    private void makeSound() {
        mediaPlayer.setVolume(volumeSlider.getValue());
    }


    /**
     * Opens up the new/edit playlist window so you can add a new playlist to the list of playlists.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void newPlaylistbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/gui/view/NewPlaylist.fxml"));
        Scene scene = new Scene(root);
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }

    /**
     * Opens the new/edit song window so you can add a new song to the list of songs.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void newSongbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/gui/view/NewSong.fxml"));
        Scene scene = new Scene(root);

        Stage window = new Stage();

        window.setScene(scene);
        window.show();
    }

    /**
     * Opens up the edit/new song window so you can edit the chosen song.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void editSongbtn(ActionEvent event) throws IOException {
        if (lstSongs.getSelectionModel().getSelectedIndex() != -1) {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/gui/view/NewSong.fxml"));
            Scene scene = new Scene(root);

            Stage window = new Stage();

            window.setScene(scene);
            window.show();
        }
    }

    /**
     * Opens up the window so you can edit the name of the chosen playlist.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void editPlaylistbtn(ActionEvent event) throws IOException {
        if (lstPlaylist.getSelectionModel().getSelectedIndex() != -1) {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/gui/view/NewPlaylist.fxml"));
        }
    }

    /**
     * Searches for a song title or the artist of the song.
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    private void handleSearchSongs(ActionEvent event) throws SQLException {
        String query = txtSongSearch.getText().trim();
        songModel.serchSongs(query);
    }

    /**
     * Deletes the chosen song from the list of songs..
     *
     * @param event
     */
    @FXML
    private void handleDeleteSong(ActionEvent event) {
        Song selectedSong = lstSongs.getSelectionModel().getSelectedItem();
        songModel.deleteSong(selectedSong);
    }

    /**
     * If you are tired of the current song you can skip forward and listen to the next song in the playlisy.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleSkipSongForward(ActionEvent event) throws IOException {
        if (lstSongsInPlayList.getSelectionModel().getSelectedIndex() != -1) {
            stopMediaPlayer();
            if (currentSongPlaying + 1 == lstSongsInPlayList.getItems().size()) {
                currentSongPlaying = 0;
            } else {
                currentSongPlaying++;
            }
            play();
        }
    }

    /**
     * If you get want to listen to the song again you can skip backward and listen to it again.
     *
     * @param event
     */
    @FXML
    private void handleSkipSongBackward(ActionEvent event) {
        if (lstSongsInPlayList.getSelectionModel().getSelectedIndex() != -1) {
            stopMediaPlayer();
            if (currentSongPlaying - 1 == -1) {
                currentSongPlaying = 0;
            } else {
                currentSongPlaying--;
            }
        }
    }

    /**
     * When you click a playlist you get a list of all the songs in
     * that playlist in the table of songs in playlist.
     *
     * @param event
     */
    @FXML
    private void handleGetSongsInPlaylist(MouseEvent event) {
        stopMediaPlayer();
        lstSongsInPlayList.getItems().clear();
        List<Song> toBeAddedSongList = lstPlaylist.getSelectionModel().getSelectedItem().getSongList();
        for (int x = toBeAddedSongList.size() - 1; x >= 0; x--) {
            toBeAddedSongList.get(x).setIDD(toBeAddedSongList.size() - x);
            lstSongsInPlayList.getItems().add(toBeAddedSongList.get(x));
        }
    }

    /**
     * Refresh the list of playlists when you add a new playlist.
     *
     * @throws SQLException
     */
    public void refreshPlaylst() throws SQLException {
        lstPlaylist.getItems().clear();
        lstPlaylist.setItems(playlistModel.getPlaylists());
    }

    @FXML
    /**
     * Deletes the chosen playlist.
     */
    public void handleDeletePlaylist(ActionEvent event) throws SQLException {
        Playlist selectedPlaylist = lstPlaylist.getSelectionModel().getSelectedItem();
        playlistModel.deletePlaylist(selectedPlaylist);
    }

    /**
     * Supposed to add a song to the playlist.
     * @param event
     */
    @FXML
    private void handleAddSongToPlay(ActionEvent event) {
        if (lstPlaylist.getSelectionModel().getSelectedIndex() != -1 && lstSongs.getSelectionModel().getSelectedIndex() != -1) {
            playlistModel.addToPlaylist(lstPlaylist.getSelectionModel().getSelectedItem(), lstSongs.getSelectionModel().getSelectedItem());
            lstSongsInPlayList.getItems().clear();
            lstSongsInPlayList.getItems().addAll();
        }
    }
}