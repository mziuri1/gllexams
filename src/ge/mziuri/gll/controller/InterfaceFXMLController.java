package ge.mziuri.gll.controller;

import ge.mziuri.gll.net.Client;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class InterfaceFXMLController implements Initializable {

    @FXML
    Label number, test;

    @FXML
    RadioButton rb1, rb2, rb3, rb4;

    @FXML
    Button next;

    private Client c;

    //https://www.facebook.com/notes/aleko-kvakhadze/%E1%83%A5%E1%83%A3%E1%83%A0%E1%83%93%E1%83%A3%E1%83%9A%E1%83%98-%E1%83%A2%E1%83%A0%E1%83%90%E1%83%93%E1%83%98%E1%83%AA%E1%83%98%E1%83%94%E1%83%91%E1%83%98-%E1%83%98%E1%83%A1%E1%83%A2%E1%83%9D%E1%83%A0%E1%83%98%E1%83%98%E1%83%A1-%E1%83%9C%E1%83%90%E1%83%AC%E1%83%98%E1%83%9A%E1%83%98-%E1%83%97%E1%83%A3-%E1%83%9C%E1%83%94%E1%83%9A%E1%83%98-%E1%83%9B%E1%83%9D%E1%83%A5%E1%83%9B%E1%83%94%E1%83%93%E1%83%94%E1%83%91%E1%83%98%E1%83%A1-%E1%83%9C%E1%83%90%E1%83%A6%E1%83%9B%E1%83%98/3468785017176/
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        c = new Client();

        c.start();

    }

}
