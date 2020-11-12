package sample;


import Pez.Pez;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML ComboBox cb1;
    @FXML TextField txt1;
    @FXML ListView lv1;
    @FXML Button btn1, btn2;
    @FXML public void initialize(){
        ObservableList<String> lista= FXCollections.observableArrayList("Trucha", "Carpa");
        cb1.setItems(lista);
    }

    Pez[] arreglo=new Pez[10];
    int cont=0;

    public void procesar(ActionEvent event){
        for (int x=0;x<cont;x++){
            lv1.getItems().add("Pescado " + arreglo[x].getTipo_pez() + " nacen " + arreglo[x].getPor_nacimiento() + " por crias y " + arreglo[x].peces_al_anio() +" por año");
        }
        //lv1.setPlaceholder(new Label(""));

    }

    public void insertar(ActionEvent event){
        if(cont<5) {
            try {
                String dato1 = cb1.getValue().toString();
                int dato2 = Integer.parseInt(txt1.getText());
                if(dato2>0 || dato1== null){
                    arreglo[cont] = new Pez(dato1,dato2);
                    cont++;
                    txt1.setText("");
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Este valor no es valido");
                    alert.show();
                }

            }catch (Exception error){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Inserte un valor valido");
                alert.show();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setContentText("El arreglo esta lleno");
            alert.show();
        }
    }
}
