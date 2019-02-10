package uF6.ejercicios.practica2.GestionPedidos;

import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

public class InterfazUsuario {
	
	private static Scanner sc = new Scanner(System.in);
	
	//opciones menu principal

	// Opciones en el menu cliente
    final static int CREAR_CLIENTE = 1;
    final static int VER_CLIENTES = 2;
    final static int BUSCAR_CLIENTE = 3;
    final static int ELIMINAR_CLIENTE = 4;
    // Opciones en el menu productos
    final static int CREAR_PRODUCTO = 5;
    final static int VER_PRODUCTOS = 6;
    // Opciones en el menu pedidos
    final static int CREAR_PEDIDO = 7;
    final static int BUSCAR_PEDIDO_ID = 8;
    final static int BUSCAR_PEDIDO_CLIENTE = 9;
    final static int SALIR = 0; 
    

    /**Muestra el menú principal de la aplicación.      */
    public static void mostrarMenuPrincipal() {
        System.out.println("\n===========MENU PRINCIPAL===========");
        System.out.println("Clientes:");  
        System.out.println("1. Dar de alta un cliente");  
        System.out.println("2. Ver todos los clientes");  
        System.out.println("3. Buscar cliente por nombre"); 
        System.out.println("4. Eliminar cliente");  
        System.out.println("\nProductos:");  
        System.out.println("5. Dar de alta un producto");  
        System.out.println("6. Ver productos");  
        System.out.println("\nPedidos:"); 
        System.out.println("7. Crear un pedido");  
        System.out.println("8. Consultar pedido");  
        System.out.println("9. Consultar pedidos por cliente"); 
        System.out.println("\n0. Salir");
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

    
    //--------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------
    // funciones para realizar operaciones con el cliente
    public static Cliente crearCliente() {
    	System.out.print("\nNombre del cliente: ");
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
    	System.out.print("\nNombre del cliente: ");
    	String nombreCliente = sc.nextLine();
    	
    	return nombreCliente;
    }
    
    
    public static String eliminarCliente() {
    	System.out.print("\nId de cliente: ");
    	String idCliente = sc.nextLine();

    	return idCliente;
    }
    
    
    //--------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------
    // funciones para realizar operaciones con el producto
    
    public static Producto ingresarProducto() {
    	System.out.print("\nNombre del producto: ");
    	String nombreProducto = sc.nextLine();
    	
    	System.out.print("Precio: ");
    	double precioProducto = sc.nextDouble();  // generara ademas del dato de entrada otro que es un salto
    	sc.nextLine();  // limpiara el buffer despues de usar el dato de tipo double y asi evitar un error

    	Producto producto = new Producto(nombreProducto, precioProducto);
    	
    	return producto;
    }
    
    
    //--------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------
    // funciones para realizar operaciones con el pedido
    public static Pedido crearPedido() {
    	
    	ConectarBaseDatosCliente cliente = new ConectarBaseDatosCliente();
    	System.out.println("\nBuscar cliente");
    	String clienteEncontrado = buscarCliente();
    	cliente.buscarCliente(clienteEncontrado); //mostrara el cliente buscado para copiar sus datos
        	
    	System.out.print("\nId de cliente: ");
    	String  id_Cliente = sc.nextLine();

    	System.out.print("\nNombre: ");
    	String nombreCliente = sc.nextLine();
    	
    	Pedido pedido =  new Pedido(id_Cliente, nombreCliente);
    	
    	return pedido;
    }
    
    
    public static String buscarNombreProducto() {
    	System.out.print("\nBuscar producto: ");
    	String nombre_producto = sc.nextLine();
    	
    	return nombre_producto;	
    }
    
    
    public static String ingresarIdProducto() {
    	System.out.print("\ningrese el Id: ");
    	String id_producto = sc.nextLine();
    	
    	return id_producto;	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
	

}
