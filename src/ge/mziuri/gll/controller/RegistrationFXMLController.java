package ge.mziuri.gll.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ge.mziuri.gll.model.User;

public class RegistrationFXMLController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmpassword;
    @FXML
    private TextField email;
    @FXML
    private TextField year;
    @FXML
    private TextField month;
    @FXML
    private TextField date;
    @FXML
    private Label namel;
    @FXML
    private Label surnamel;
    @FXML
    private Label usernamel;
    @FXML
    private Label passwordl;
    @FXML
    private Label confirmpasswordl;

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

        username.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (newValue.length() < 4) {

                    usernamel.setText("მინიმუმ 4 სიმბოლო !");

                } else if (newValue.length() > 12) {

                    usernamel.setText("მაქსიმუმ 12 სიმბოლო !");

                } else {

                    usernamel.setText("");

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

        year.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                try {

                    if (newValue.charAt(newValue.length() - 1) < '0' || newValue.charAt(newValue.length() - 1) > '9') {

                        year.setText(oldValue);

                    }
                } catch (Exception ex) {

                }

            }

        });

        month.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                try {

                    if (newValue.charAt(newValue.length() - 1) < '0' || newValue.charAt(newValue.length() - 1) > '9') {

                        month.setText(oldValue);

                    }
                } catch (Exception ex) {

                }

            }

        });

        date.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                try {

                    if (newValue.charAt(newValue.length() - 1) < '0' || newValue.charAt(newValue.length() - 1) > '9') {

                        date.setText(oldValue);

                    }
                } catch (Exception ex) {

                }

            }

        });
    }

    public void RegistrationSetOnAction() {

        User u = new User();

        u.setName(name.getText());
        u.setSurname(surname.getText());
        u.setUsername(username.getText());
        u.setPassword(password.getText());
        u.setEmail(email.getText());
        u.setCurrentUsername(name.getText());

        try {

            u.setYear(Integer.parseInt(year.getText()));
            u.setMonth(Integer.parseInt(month.getText()));
            u.setDate(Integer.parseInt(date.getText()));

        } catch (Exception ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("Incorrect Date !");
            alert.setContentText("Try Again !");
            alert.showAndWait();

        }

        int ryear = Calendar.getInstance().get(Calendar.YEAR);
        int rmonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int rdate = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        if (!(u.getMonth() > 12 || u.getDate() > 31 || u.getYear() > ryear || (u.getYear() == ryear && (u.getMonth() > rmonth || u.getDate() > rdate)))) {

            if ("".equals(namel.getText()) && "".equals(surnamel.getText()) && "".equals(usernamel.getText()) && "".equals(passwordl.getText()) && "".equals(confirmpasswordl.getText()) && !"".equals(name.getText()) && !"".equals(surname.getText()) && !"".equals(username.getText()) && !"".equals(password.getText()) && !"".equals(confirmpassword.getText()) && !"".equals(email.getText())) {

                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("src\\users\\" + username.getText())))) {

                    out.writeObject(u);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("Registration");
                    alert.setHeaderText("Registration Successfull !");
                    alert.setContentText("Thanks !");
                    alert.showAndWait();

                } catch (IOException ex) {

                    Logger.getLogger(RegistrationFXMLController.class.getName()).log(Level.SEVERE, null, ex);

                }

            } else {

                Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Warning");
                alert.setContentText("Fix Above Errors !");
                alert.setContentText("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                alert.showAndWait();

            }

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("Incorrect Date !");
            alert.setContentText("Try Again !");
            alert.showAndWait();

        }

    }
}
