package uF6.ejercicios.practica2.GestionPedidos;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idCustomer;  //ide de cliente
	private String nameCustomer; // nombre
	private String addressPostalCode; // direccion postal
	private String email; // correo
	private String phone; // telefono
	
	//CONSTRUCTOR
	public Cliente(int idCustomer, String name, String addressPostalCode, String email, String phone) {
		super();
		this.idCustomer = idCustomer;
		this.nameCustomer = name;
		this.addressPostalCode = addressPostalCode;
		this.email = email;
		this.phone = phone;
	}

	//SETTER Y GETTER
	public int getIdCustomer() {
		return idCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public String getAddressPostalCode() {
		return addressPostalCode;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
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
		return "Id Customer: " + idCustomer + 
				"\nName: " + nameCustomer + 
				"\nDireccion postal: " + addressPostalCode + 
				"\nEmail: " + email + 
				"\nPhone=" + phone;
	}
	
	
	
	

}
