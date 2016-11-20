package ge.mziuri.gll.controller;

import ge.mziuri.gll.dao.StudentDAOImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ge.mziuri.gll.model.User;
import ge.mziuri.gll.view.Runner;

public class LoginFXMLController implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private Label identification;
    @FXML
    private Label password;
    @FXML
    private TextField identificationf;
    @FXML
    private PasswordField passwordf;
    @FXML
    private Button login;
    @FXML
    private Label forgot;
    @FXML
    private Label registration;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void RegistrationSetOnMouseClicked() {

        try {

            Runner r = new Runner();

            Parent root;
            root = FXMLLoader.load(r.getClass().getResource("RegistrationFXML.fxml"));

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();

        } catch (IOException ex) {

        }

    }

    public void LoginSetOnAction() {

        String tidentification = identificationf.getText();
        String tpassword = passwordf.getText();

        StudentDAOImpl sdaoi = new StudentDAOImpl();

        User u = sdaoi.GetStudent(tidentification);

        if (tpassword.equals(u.getPassword())) {

            Login();

        } else {

        }

    }

    public void Login() {

        try {

            Runner r = new Runner();

            Parent root;

            root = FXMLLoader.load(r.getClass().getResource("InterfaceFXML.fxml"));

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setTitle("Chat");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    public void IndentificationFSetOnAction() {

        LoginSetOnAction();

    }

    public void PasswordFSetOnAction() {

        LoginSetOnAction();

    }

}
