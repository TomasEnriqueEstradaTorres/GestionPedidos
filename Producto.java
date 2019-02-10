package uF6.ejercicios.practica2.GestionPedidos;

import java.io.Serializable;

public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nameProduct;// nombre del producto
	private double price; // precio del producto
	
	//CONSTRUCTORES
	public Producto() {
	
	}

	public Producto(String nameProduct, double price) {
		this.nameProduct = nameProduct;
		this.price = price;
	}

	
	//SETTER Y GETTER
	public String getNameProduct() {
		return nameProduct;
	}

	public double getPrice() {
		return price;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	//METODOS
	@Override
	public String toString() {
		return "Nombre del producto: " + nameProduct + 
				"\nPrecio: " + price;
	}

}
