package uF6.ejercicios.practica2.GestionPedidos;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//private int idCustomer;  //id de cliente
	private String nameCustomer; // nombre
	private String address; // direccion 
	private String postalCode; // codigo postal
	private String email; // correo
	private String phone; // telefono
	
	//CONSTRUCTORES
	public Cliente() {

	}

	public Cliente(String nameCustomer, String address, String postalCode, String email, String phone) {
		this.nameCustomer = nameCustomer;
		this.address = address;
		this.postalCode = postalCode;
		this.email = email;
		this.phone = phone;
	}

	
	//SETTER Y GETTER
	public String getNameCustomer() {
		return nameCustomer;
	}

	public String getAddress() {
		return address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	//METODOS
	@Override
	public String toString() {
		return "Nombre del cliente: " + nameCustomer + 
				"\nDireccion: " + address + 
				"\nCodigo postal: " + postalCode + 
				"\nCorreo: " + email + 
				"\nTelefono: " + phone;
	}
	
	
	
	




	


	

	

}
