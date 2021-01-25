package sample.Estructura;

public class Ordenamiento {
    public static int[] burbuja(int[] arreglo){
        int auxiliar;
        int[] arregloOrdenado;
        for(int i=1;i<arreglo.length;i++){
            for(int j=0;j<arreglo.length-i; j++){
                if(arreglo[j]>arreglo[j+1]){
                    auxiliar=arreglo[j];
                    arreglo[j]= arreglo[j+1];
                    arreglo[j+1]=auxiliar;
                }
            }
        }
        arregloOrdenado=arreglo;
        return arregloOrdenado;
    }

    public String[][] burbujaArray(String[][] arreglo){
        String auxiliar;
        String auxiliar2;
        String[][] arregloOrdenado;
        for(int i=0;i<arreglo.length-1;i++){
            for(int j=0;j<arreglo.length-i-1; j++){
                if(Integer.parseInt(arreglo[j][1]) > Integer.parseInt(arreglo[j+1][1])){
                    auxiliar=arreglo[j][0];
                    auxiliar2=arreglo[j][1];
                    arreglo[j][0]= arreglo[j+1][0];
                    arreglo[j][1]= arreglo[j+1][1];
                    arreglo[j+1][0]=auxiliar;
                    arreglo[j+1][1]=auxiliar2;
                }
            }
        }
        arregloOrdenado=arreglo;
        return arregloOrdenado;
    }



   /*public int[] mezclaDirecta(int[] arreglo){
        int i,j,k;
        if(arreglo.length>1){
            int nElementosIzq=arreglo.length/2;
            int nElementosDer=arreglo.length-nElementosIzq;
            int arregloIzq[]=new int[nElementosIzq];
            int arregloDer[]=new int[nElementosDer];
            //copiando los elementos de la parte primera al arregloIzq
            for(i=0;i<nElementosIzq;i++){
                arregloIzq[i]=arreglo[i];
            }
            //copiando los elementos de la parte segunda al arregloIzq
            for(i=nElementosIzq;i<nElementosIzq+nElementosDer;i++){
                arregloDer[i-nElementosIzq]=arreglo[i];
            }
            //Recursividad
            arregloIzq=mezclaDirecta(arregloIzq);
            arregloDer=mezclaDirecta(arregloDer);
            i=0;j=0;k=0;
            while (arregloIzq.length!=j && arregloDer.length!=k){
                if(arregloIzq[j]<arregloDer[k]){
                    arreglo[i]=arregloIzq[j];
                    i++;
                    j++;
                }else{
                    arreglo[i]=arregloDer[k];
                    i++;
                    k++;
                }
            }
            //Arreglo final
            while(arregloIzq.length!=j){
                arreglo[i]=arregloIzq[j];
                i++;
                j++;
            }
            while (arregloDer.length!=k){
                arreglo[i]=arregloDer[k];
                i++;
                k++;
            }
        }// Fin If
        return arreglo;
    }*/

}
