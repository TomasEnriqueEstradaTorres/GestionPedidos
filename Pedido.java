package uF6.ejercicios.practica2.GestionPedidos;

import java.io.Serializable;
import java.util.HashMap;

public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idOrder; // id del pedido
	private String customerNameOrder; // nombre del cliente en el pedido
	private String date; // fecha
	private String hour; // hora
	private HashMap<String, Integer> productQuantity = new HashMap<String, Integer>();  // cantidad de producto
	
	
	

}

/*
private void cantidadVisitas() {
	if (visitas.containsKey(URL)) {// buscara la clave
        visitas.put(URL, visitas.get(URL) + 1);// si la contiene aumenta la cantidad de visista
    } else { // si no la agrega a la lista con su valor 1
        visitas.put(URL, 1);
    }
}
*/