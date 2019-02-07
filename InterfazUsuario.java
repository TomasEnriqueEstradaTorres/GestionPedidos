package uF6.ejercicios.practica2.GestionPedidos;

import java.util.Scanner;

public class InterfazUsuario {
	
	private static Scanner sc = new Scanner(System.in);
	
	 //opciones menu principal
    final static int CREAR_CLIENTE = 1;
    final static int VER_CLIENTES = 2;
    final static int BUSCAR_CLIENTE = 3;
    final static int ELIMINAR_CLIENTE = 4;
    
    final static int ELIMINAR_PREFERITS = 5;
    final static int VEURE_PREFERITS = 6;
    final static int VEURE_HISTORIAL = 7;
    final static int VEURE_VISITADES = 8;
    final static int SALIR = 0;

    /**Muestra el menú principal de la aplicación.      */
    public static void mostrarMenuPrincipal() {
        System.out.println("\n=========MENU PRINCIPAL=========");
        System.out.println("1. Dar de alta un cliente: ");  // ir a
        System.out.println("2. Ver todos los clientes");  // atras
        System.out.println("3. Buscar cliente por nombre"); // adelante
        System.out.println("4. Eliminar cliente");  // Añadir a direcciones de interes
        System.out.println("5. ======");  // Eliminar a direcciones de interes
        System.out.println("6. Veure adreces d'interes");  // Ver direcciones de interes
        System.out.println("7. Veure historial");  //  Ver historial
        System.out.println("8. Veure nombre visites");  // Ver número visitas
        System.out.println("0. Sortir");
        System.out.print("\tOpcion: ");
    }
    
    /**Lee un entero que representa una opción de menos.
     * @return un entero, -1 si la entrada no se numerica      */
    public static int elegirOpcion() {
        //Scanner lector = new Scanner(System.in);
        int opcion = 0;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            opcion = -1;
        }
        return opcion;
    }
    
    
    public static Cliente crearCliente() {
    	//Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Nombre del cliente: ");
    	String nombreCliente = sc.nextLine();
    	
    	System.out.print("Direccion: ");
    	String direccion = sc.nextLine();
    	
    	System.out.print("Codigo postal: ");
    	String cp = sc.nextLine();

    	System.out.print("Correo: ");
    	String correo = sc.nextLine();
    	
    	System.out.print("Telefono: ");
    	String telefono = sc.nextLine();
    
    	Cliente cliente = new Cliente(nombreCliente, direccion, cp, correo, telefono);
    	
    	return cliente;
    }
    
    
    public static String buscarCliente() {
    	//Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Nombre del cliente: ");
    	String nombreCliente = sc.nextLine();
    	
    	return nombreCliente;
    }
    
    
    public static String eliminarCliente() {
    	//Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Id de cliente: ");
    	String idCliente = sc.nextLine();
    	
    	return idCliente;
    }
    
	

}
