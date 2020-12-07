package sample;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.dal.db.MyDatabaseConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("gui/view/sample.fxml"));
        primaryStage.setTitle("Hello world");
        primaryStage.setScene(new Scene(root, 796, 487));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
