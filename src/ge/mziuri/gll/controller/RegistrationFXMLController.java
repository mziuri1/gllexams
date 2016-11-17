package ge.mziuri.gll.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ge.mziuri.gll.model.User;

public class RegistrationFXMLController implements Initializable {

    @FXML
    private TextField name, surname, identification;

    @FXML
    private PasswordField password, confirmpassword;

    @FXML
    private Label namel, surnamel, identificationl, passwordl, confirmpasswordl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        name.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (newValue.length() < 2) {

                    namel.setText("მინიმუმ 2 სიმბოლო !");

                } else {

                    namel.setText("");

                }
            }
        });

        surname.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (newValue.length() < 2) {

                    surnamel.setText("მინიმუმ 2 სიმბოლო !");

                } else {

                    surnamel.setText("");

                }

            }

        });

        password.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (newValue.length() < 4) {

                    passwordl.setText("მინიმუმ 4 სიმბოლო !");

                } else if (newValue.length() > 16) {

                    passwordl.setText("მაქსიმუმ 16 სიმბოლო !");

                } else {

                    passwordl.setText("");

                }

            }

        });

        confirmpassword.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (!newValue.equals(password.getText())) {

                    confirmpasswordl.setText("პაროლები უნდა ემთხვეოდეს !");

                } else {

                    confirmpasswordl.setText("");

                }

            }

        });

    }

    public void RegistrationSetOnAction() {

        User u = new User();

        u.setName(name.getText());
        u.setSurname(surname.getText());
        u.setPassword(password.getText());

    }
}
