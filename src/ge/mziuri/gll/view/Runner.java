package ge.mziuri.gll.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("Login&Registration");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (IOException ex) {

            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
