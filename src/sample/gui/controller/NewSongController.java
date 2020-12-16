package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.be.Song;
import sample.gui.model.SongModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewSongController implements Initializable {


    @FXML
    private TextField txtSongTitle;
    @FXML
    private TextField txtArtistField;
    @FXML
    private TextField categoryField;
    @FXML
    private TextField timeField;
    @FXML
    private TextField urlField;

    private SongModel songModel;
    MainViewController mainViewController;


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
            songModel = new SongModel();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleSaveSong(ActionEvent event) throws SQLException, IOException {
            String title = txtSongTitle.getText().trim();
            String artist = txtArtistField.getText().trim();
            String category = categoryField.getText().trim();
            int duration = Integer.parseInt(timeField.getText().trim());
            String path = urlField.getText().trim();

            songModel.createSong(title, artist, category, duration, path);
            mainViewController.refreshSongLst();
            Stage stage = (Stage) urlField.getScene().getWindow();
            stage.close();
    }
}