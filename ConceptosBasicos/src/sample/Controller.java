package sample;

import conversiones.Conversion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField edad;
    @FXML Label lblTitulo;

    public void evento1(ActionEvent event){
        Conversion td= new Conversion();

        int numero=Integer.parseInt(edad.getText());
        String res=td.binario(numero);
        lblTitulo.setText(res);
    }
}
