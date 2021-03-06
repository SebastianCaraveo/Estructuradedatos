package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Estructura.Busqueda;
import sample.Estructura.ItemPedidos;
import sample.Estructura.Ordenamiento;
import sample.Estructura.Pedido;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ControllerCobro {
    @FXML ComboBox cmbPlatillos, cmbBebidas, cmbOpc;
    @FXML TableView tabla;
    @FXML TextField  txtNombre, txtVenta,txtbuscar;
    @FXML Label nombrePedido, lblVentas;
    @FXML Spinner<Integer> cantP, cantB;
    @FXML Label txtNombreUser;
    final int initialvalue=1;
    SpinnerValueFactory<Integer> num=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,99,initialvalue);
    final int initialvalue2=1;
    SpinnerValueFactory<Integer> num2=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,99,initialvalue2);
    Stack<ItemPedidos> pila=new Stack<>();

    int[] ventas=new int[5];

    LinkedList<String> listaBebidas=new LinkedList<>();
    LinkedList<String> listaPlatillos=new LinkedList<>();
    LinkedList<String> listaOpciones=new LinkedList<>();
    TableColumn columnaBebida=new TableColumn("Bebida");
    TableColumn columnaCantBebida=new TableColumn("Cantidad");
    TableColumn columnaPlatillos=new TableColumn("Tacos");
    TableColumn columnaCantPlatillos=new TableColumn("Cantidad");
    ObservableList<Pedido> listaPedidos= FXCollections.observableArrayList();
    Queue<ItemPedidos> cola=new LinkedList<>();


    String[][] platillo={
            {"Papa","10"},
            {"Asada","15"},
            {"Al pastor", "12"},
            {"Cubanita","15"},
            {"Camarón","18"},
            {"Carnitas Michoacanas", "15"},
            {"Pescado","12"}

    };

    String[] personapedido=new String[1];

    @FXML protected void initialize(){
        txtNombreUser.setText(Main.nombreUsuario);
        columnaBebida.setCellValueFactory(new PropertyValueFactory<Pedido, String>("bebida"));
        columnaCantBebida.setCellValueFactory(new PropertyValueFactory<Pedido, String>("cantbebida"));
        columnaPlatillos.setCellValueFactory(new PropertyValueFactory<Pedido, String>("platillo"));
        columnaCantPlatillos.setCellValueFactory(new PropertyValueFactory<Pedido, String>("cantplatillo"));
        tabla.getColumns().addAll(columnaBebida, columnaCantBebida,columnaPlatillos,columnaCantPlatillos);
        tabla.setItems(listaPedidos);
       listaBebidas.add("Coca cola");
        listaBebidas.add("Agua");
        listaBebidas.add("Sprite");
        listaBebidas.add("Limonada");
        listaBebidas.add("Manzanita");
        listaBebidas.add("Fanta Naranja");
       /* listaPlatillos.add("Al Pastor");
        listaPlatillos.add("Asada");
        listaPlatillos.add("Papa");
        listaPlatillos.add("Cubanita");
        listaPlatillos.add("Pescado");
        listaPlatillos.add("Camarón");
        listaPlatillos.add("Carntias Michoanas");*/

       for(int x=0;x<platillo.length;x++){
           listaPlatillos.add(platillo[x][0]);
       }

        ////////lista de opciones/////
        listaOpciones.add("Información");
        listaOpciones.add("Cerrar Sesión");
        listaOpciones.add("Salir");
        for(int x=0;x<listaPlatillos.size();x++) cmbPlatillos.getItems().add(listaPlatillos.get(x));
        for(int x=0;x<listaBebidas.size();x++) cmbBebidas.getItems().add(listaBebidas.get(x));
        for(int x=0;x<listaOpciones.size();x++) cmbOpc.getItems().add(listaOpciones.get(x));
        cantP.setValueFactory(num);
        cantB.setValueFactory(num2);

    }

    public void insertarPedido(){
        String p=cmbPlatillos.getSelectionModel().getSelectedItem().toString();
        String b=cmbBebidas.getSelectionModel().getSelectedItem().toString();
        String cp=cantP.getValue().toString();
        String cb=cantB.getValue().toString();
        listaPedidos.add(new Pedido(b, cb, p, cp));
    }
    public void guardarPedido(){

        String[][] items=new String[listaPedidos.size()][4];
        for(int x=0;x<items.length;x++){
            items[x][0]=listaPedidos.get(x).getBebida();
            items[x][1]=listaPedidos.get(x).getCantbebida();
            items[x][2]=listaPedidos.get(x).getPlatillo();
            items[x][3]=listaPedidos.get(x).getCantplatillo();
        }
        ItemPedidos pedido=new ItemPedidos(items, txtNombre.getText());
        cola.add(pedido);
        pila.add(pedido);
        listaPedidos.clear();
        txtNombre.setText("");


    }
    public void finalizar(){
        ItemPedidos pedido=cola.poll();
        nombrePedido.setText(pedido.getNombre());
        String [][] datos=pedido.getDatos();
        for(int x=0;x<datos.length;x++){
            System.out.print(datos[x][0]+" ");
            System.out.print(datos[x][1]+ ",");
            System.out.print(datos[x][2]+ " ");
            System.out.print(datos[x][3]+ " ");
            System.out.println();
        }
    }
    public void Status(){
        ItemPedidos pedido=pila.pop();
        nombrePedido.setText(pedido.getNombre());
        String [][] datos=pedido.getDatos();
        for(int x=0;x<datos.length;x++){
            System.out.print(datos[x][0]+" ");
            System.out.print(datos[x][1]+ ",");
            System.out.print(datos[x][2]+ " ");
            System.out.print(datos[x][3]+ " ");
            System.out.println();
        };

    }

    public void menu(){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("PantallaMenu.fxml"));
            Scene scene=new Scene(root);
            Main.stage.setScene(scene);
            Main.stage.setMaximized(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    int cont=0;
    public void insertarVenta(){
        ventas[cont]=Integer.parseInt(txtVenta.getText().toString());
        System.out.println(txtVenta.getText());
        cont++;
    }

    public void ordenarVenta(){
        Ordenamiento ordenar=new Ordenamiento();
        int[] ordenado=ordenar.burbuja(ventas);
        String todo="";
        for(int x=0;x<ordenado.length;x++) todo += " "+ ordenado[x]+", ";
        lblVentas.setText(todo);
    }

    public void ordenarPlatillos(){
        Ordenamiento ordenar=new Ordenamiento();
        cmbPlatillos.getItems().clear();
        listaPlatillos.clear();
        String[][] ordenado=ordenar.burbujaArray(platillo);
        for(int x=0;x<ordenado.length;x++){
            listaPlatillos.add(ordenado[x][0]);
            cmbPlatillos.getItems().add(ordenado[x][0]);
        }
    }

  /*  public void buscarcliente(){
        String busqueda;
        Busqueda busqueda1=new Busqueda();
        tabla.getItems().clear();
        String[] ordenado=busqueda1.binario(personapedido);
        {
            for (int x = 0; x < ordenado; x++)
                tabla.setItems((ObservableList) txtbuscar);
        }
        }

*/
}

