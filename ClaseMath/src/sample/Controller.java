package sample;

import Calculos.Calculos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField txtArreglo1, txtArreglo2;
    @FXML ListView lista1, lista2;
    double[] arreglo1=new double[5];
    double[][] arreglo2=new double[2][4];
    int cont=0;
    int cont2=0;
    int cont3=0;
    public void insertar1(ActionEvent event){
        if(cont<5){
        double dato=Double.parseDouble(txtArreglo1.getText());
        arreglo1[cont]=dato;
        cont++;
        txtArreglo1.setText("");
        imprimirArreglo(arreglo1);
        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Arreglo lleno compa");
            alert.show();
        }
    }

    public void insertar2(ActionEvent event){
        if(cont2<2){
            double dato=Double.parseDouble(txtArreglo2.getText());
            arreglo2[cont2][cont3]=dato;
            cont3++;
            if(cont3==4){
                cont3=0;
                cont2++;
            }
            txtArreglo2.setText("");
            imprimirArregloBidi(arreglo2);
        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Arreglo lleno compa");
            alert.show();
        }
    }

    public void procesar1(ActionEvent event){
        Calculos calculos=new Calculos(arreglo1, arreglo2);
        double[] res=calculos.procesarCoseno();
        for(double dato:res){
            lista1.getItems().add(dato+"");
        }
    }
    public void procesar2(ActionEvent event){
        Calculos calculos=new Calculos(arreglo1, arreglo2);
        double[][] res=calculos.procesarSeno();
        for(int x=0;x<res.length;x++){
            String columna="";
            for(int y=0;y<res[x].length;y++){
              columna=columna+ res[x][y]+", ";
            }//for y
            lista2.getItems().add(columna);
        }// for x
    }

    public void imprimirArreglo(double[] arr){
        for(int x=0;x<arr.length;x++){
            System.out.print("");
        }
        System.out.println("");
    }
    public void imprimirArregloBidi(double[][] arr){
        for(int x=0;x<arr.length;x++){
            for(int y=0;y<arr[x].length;y++){
                System.out.print(arr[x][y]+",");
            }//for y
            System.out.println("");
        }// for x
        System.out.println("___________________________");
    }
}
