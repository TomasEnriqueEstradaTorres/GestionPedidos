package uF6.ejercicios.practica2.GestionPedidos;

import java.io.Serializable;
import java.util.HashMap;

public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idOrder; // id del pedido
	private String customerNameOrder; // nombre del cliente en el pedido
	private String date; // fecha
	private String hour; // hora
	private HashMap<String, Integer> productQuantity;  // cantidad de producto clave=nombre:valor=cantidad
	
	//CONSTRUCTOR
	public Pedido(int idOrder, String customerNameOrder, String date, String hour) {
		this.idOrder = idOrder;
		this.customerNameOrder = customerNameOrder;
		this.date = date;
		this.hour = hour;
		this.productQuantity = new HashMap<String, Integer>();
	}

	public int getIdOrder() {
		return idOrder;
	}

	public String getCustomerNameOrder() {
		return customerNameOrder;
	}

	public String getDate() {
		return date;
	}

	public String getHour() {
		return hour;
	}

	public HashMap<String, Integer> getProductQuantity() {
		return productQuantity;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public void setCustomerNameOrder(String customerNameOrder) {
		this.customerNameOrder = customerNameOrder;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public void setProductQuantity(HashMap<String, Integer> productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	
	
	
	
	
	

}

/*
public void veureVisitades() {
	System.out.println(visitas);
	//System.out.println("Pagina: " + visitas.keySet() + "=" + visitas.values()); 
}



private void cantidadVisitas() {
	if (visitas.containsKey(URL)) {// buscara la clave
        //si existe la URL este aumentara la cantidad de visitas que el el valor
        visitas.put(URL, visitas.get(URL) + 1);// si la contiene aumenta la cantidad de visista
    } else { // si no la agrega a la lista con su valor 1
        visitas.put(URL, 1);
    }
}
*/