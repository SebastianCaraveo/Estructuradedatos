package sample.Estructura;

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;

public class Busqueda {

    public int secuencial(String [][] array, String d1, String d2){
        int i=-1;
        for (int x=0;x<array.length;x++) {
            if (array[x][1].equals(d1) && array[x][2].equals(d2)) {
                i = x;
                return i;
            }
        }
        return i;
    }

    public int binario(Pedido[] array, String cantP){
        String numeroBuscado=cantP;
        int posicion=0, inferior = 0, centro;
        int superior=array.length - 1;
        while (inferior<=superior){
            centro = (superior + inferior)/2;
            if (array[centro].getClass().toString() == cantP) {
                posicion = centro+1;
                System.out.println("La persona tiene :" + posicion + "tacos en la tabla tabla");
                break;
            }else if(numeroBuscado != array[centro].getClass().toString()){
                superior = centro -1;
            }else {
                inferior = centro + 1;
            }
        }
        return posicion;
    }

}
