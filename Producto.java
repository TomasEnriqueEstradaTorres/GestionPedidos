package uF6.ejercicios.practica2.GestionPedidos;

import java.io.Serializable;

public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idProduct; //id del producto
	private String nameProduct;// nombre del producto
	private double price; // precio del producto
	
	//CONSTRUCTOR
	public Producto(int idProduct, String nameProduct, double price) {
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.price = price;
	}

	//SETTER Y GETTER
	public int getIdProduct() {
		return idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public double getPrice() {
		return price;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
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
		return "Id Product: " + idProduct + 
				"\nProduct Name: " + nameProduct + 
				"\nPrice: " + price;
	}
	
	
	
	

}
