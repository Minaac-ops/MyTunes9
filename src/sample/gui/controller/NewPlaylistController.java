package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.gui.model.PlaylistModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewPlaylistController implements Initializable {

        @FXML
        private TextField nameField;

        private PlaylistModel playlistModel;
        MainViewController mainViewController;


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle)
        {
            try {
                playlistModel = new PlaylistModel();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private void GoBack(MouseEvent event) {

            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.close();
        }


        @FXML
        public void handleSavePlaylist(ActionEvent event) throws SQLException {
            String name = nameField.getText().trim();
            if (name != null && name.length() > 0 && name.length() < 50) {
                {
                    playlistModel.createPlaylist(name);

                    Stage stage = (Stage) nameField.getScene().getWindow();
                    stage.close();
                }
                mainViewController.refreshPlaylst();
            }
        }
}
