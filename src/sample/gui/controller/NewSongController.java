package sample.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import sample.gui.model.SongModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewSongController implements Initializable {


    @FXML
    private TextField titleField;
    @FXML
    private TextField artistField;
    @FXML
    private TextField categoryField;
    @FXML
    private TextField timeField;
    @FXML
    private Label urlField;

    private SongModel songModel;


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
}
