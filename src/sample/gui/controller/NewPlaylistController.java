package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.gui.model.PlaylistModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewPlaylistController implements Initializable {


    private PlaylistModel playlistModel;
    MainViewController mainViewController;

    @FXML
    private TextField nameField;


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            playlistModel = new PlaylistModel();
            mainViewController = new MainViewController();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * After you saves the playlists, you can go back to the main window.
     * @param event
     */
    @FXML
    private void handleGoBack(ActionEvent event) {
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }

    /**
     * Save the playlist to view it in the list of playlists in the mainview.
     * @param event
     * @throws SQLException
     */
    @FXML
    public void handleSavePlaylist(ActionEvent event) throws SQLException {
        String name = nameField.getText().trim();
        if (name != null && name.length() > 0 && name.length() < 50) {
            {
                playlistModel.createPlaylist(name);
            }
        }
        mainViewController.refreshPlaylst();
    }
}
