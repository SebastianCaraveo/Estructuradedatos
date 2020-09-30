package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField edad;
    @FXML Label lblTitulo;

    public void evento1(ActionEvent event){
        int dias=Integer.parseInt(edad.getText())*365;
        lblTitulo.setText("Has vivido"+dias+"días");
    }
}
