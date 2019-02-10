package uF6.ejercicios.practica2.GestionPedidos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	LocalDateTime localDateTime;
	
	private String idCustomer;  // id del cliente ingresado por busqueda
	private String customerOrder; // nombre del cliente en el pedido ingresado por busqueda
	private String date; // fecha
	private String hour; // hora
	private HashMap<String, Integer> productQuantity;  // cantidad de producto clave=nombre:valor=cantidad
	
	
	//CONSTRUCTORES
	public Pedido() {

	}

	public Pedido(String idCustomer, String customerOrder) {
		this.idCustomer = idCustomer;
		this.customerOrder = customerOrder;
		this.date = datoFecha();
		this.hour = datoHora();
	}
	
	//SETTER Y GETTER
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getIdCustomer() {
		return idCustomer;
	}

	public String getCustomerOrder() {
		return customerOrder;
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

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public void setCustomerOrder(String customerOrder) {
		this.customerOrder = customerOrder;
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
	
	
	//METODOS
	private String datoFecha() {
		//sirve para poner la fecha definida por el sistema
		localDateTime = LocalDateTime.now();
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
		String datoFecha = localDateTime.format(fecha);
		
		return datoFecha;
	}
	
	private String datoHora() {
		//sirve para poner la hora definida por el sistema
		localDateTime = LocalDateTime.now();
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("hh:mm:ss");
		String datoHora = localDateTime.format(hora);
		
		return datoHora;
	}
	
	
	// esto es para cuando se saque de la tabla los datos devolviendo un dato con la lista de productos
	public HashMap<String, Integer>  obtenerProductosPedido(String nombreProducto) {
		if (productQuantity.containsKey(nombreProducto)) {// buscara la clave
	        //si existe la URL este aumentara la cantidad de visitas que el el valor
			productQuantity.put(nombreProducto, productQuantity.get(nombreProducto) + 1);// si la contiene aumenta la cantidad de visista
	    } else { // si no la agrega a la lista con su valor 1
	    	productQuantity.put(nombreProducto, 1);
	    }
		return productQuantity;
	}
	
	public void  mostrar(HashMap<String, Integer> productos) {
		productos.forEach((producto,cantidad) -> System.out.println("Producto: " + producto + ": Cantidad: " + cantidad));
	}


	

	
	
	
	
	
	
	
	
	
	
}

/*
//iterar un hashMap
datos.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
visitas.forEach((k,v) -> System.out.println("Clave: " + k + ": Valor: " + v));


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