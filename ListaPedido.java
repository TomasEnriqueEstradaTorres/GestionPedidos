package uF6.ejercicios.practica2.GestionPedidos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ListaPedido {

	private String idPedido;
	private String idProducto;
	// este dato guardara sera el idProducto y la cantidaProducto
	private HashMap<String, Integer> productNameQuantity = new HashMap<String, Integer>(); // cantidad de producto clave=nombre:valor=cantidad
	private HashMap<Double, Integer> precios = new HashMap<Double, Integer>(); // para el precio de los productos
	
	// CONSTRUCTOR
	public ListaPedido() {
	}
	
	/*
	public ListaPedido(String idPedido, String idProducto) {
		this.idPedido = idPedido;
		this.idProducto = idProducto;
	} */

	// SETTER Y GETTER
	public String getIdPedido() {
		return idPedido;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public HashMap<String, Integer> getProductNameQuantity() {
		return productNameQuantity;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public void setProductNameQuantity(HashMap<String, Integer> productNameQuantity) {
		this.productNameQuantity = productNameQuantity;
	}

	public HashMap<Double, Integer> getPrecios() {
		return precios;
	}

	public void setPrecios(HashMap<Double, Integer> precios) {
		this.precios = precios;
	}
	
	// METODOS
	
	public void borrarLista() { 
		// borrara la lista cada vez que se haga una consulta y asi no se acumule los datos de otros pedidos
		productNameQuantity.clear();
	}
	
	// Contara la cantidad de un determinado producto ingresado
	public void contandoProductos(String idProducto) {
		if (productNameQuantity.containsKey(idProducto)) {// buscara la clave
			// si existe el nombre de producto este aumentara la cantidad que hay de el
			productNameQuantity.put(idProducto, productNameQuantity.get(idProducto) + 1);			
		} else { // si no la agrega a la lista con su valor 1, indicando que solo hay 1
			productNameQuantity.put(idProducto, 1);
		}
	}

	// mostrara la lista de productos
	public void mostrarConteoProductos() {
		productNameQuantity.forEach((producto, cantidad) -> System.out.println("Producto: " + producto + ": Cantidad: " + cantidad));
		//productNameQuantity.forEach((producto, cantidad) -> System.out.println(producto + " " + cantidad));
	}

	// contara los precios para obtener el monto del pedido
	public void contandoPreciosProductos(Double precio) {
		if (precios.containsKey(precio)) {// buscara la clave
			// si existe el precio de producto este aumentara la cantidad que hay de el
			precios.put(precio, precios.get(precio) + 1);			
		} else { // si no la agrega a la lista con su valor 1, indicando que solo hay 1
			precios.put(precio, 1);
		}
	}
	
	
	
	
	
	
	
	
	
	

	// Para verificar este metodo
	public void mostrarConteoIdProducto() { // aqui se alla los datos usando un iterador		
		Iterator<Entry<String,Integer>> it = productNameQuantity.entrySet().iterator();
		while (it.hasNext()) {
		 Entry<String, Integer> e = it.next();
		 System.out.println(e.getKey() + " " + e.getValue());
		}
	}
	
	


	

	
	

}
