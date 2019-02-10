package uF6.ejercicios.practica2.GestionPedidos;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;




public class MainPrincipal {

	public static void main(String[] args) {
		ConectarBaseDatosCliente conectarCliente = new ConectarBaseDatosCliente();
		Cliente cliente = new Cliente();
		
		ConectarBaseDatosProducto conectarProducto = new ConectarBaseDatosProducto();
		Producto producto = new Producto();
		
		ConectarBaseDatosPedido conectarPedidoProducto = new ConectarBaseDatosPedido();
		Pedido pedido = new Pedido();
		
		
		int opcion;

        do {
        	InterfazUsuario.mostrarMenuPrincipal();     	
        	opcion = InterfazUsuario.elegirOpcion();
            switch (opcion) {
                case InterfazUsuario.CREAR_CLIENTE:  // 1
                	//Aqui se agregara un cliente en la base de datos
                	cliente = InterfazUsuario.crearCliente();
                	conectarCliente.guardarCliente(cliente);
                    break;
                    
                case InterfazUsuario.VER_CLIENTES:  // 2
                	//Mostrara la lista de clientes de la base de datos
                	conectarCliente.mostrarClientes();
                    break;
                
                case InterfazUsuario.BUSCAR_CLIENTE:  // 3
                	//Buscara un cliente por nombre
                	boolean siExiste = false; // sirve para verificar si existe el cliente
                	do {// seguira preguntando mientras sea falso
                		String nombreCliente = InterfazUsuario.buscarCliente();
                		siExiste = conectarCliente.buscarCliente(nombreCliente);
                	}while(siExiste == false);
                    break;
                    
                case InterfazUsuario.ELIMINAR_CLIENTE:  // 4
                	//Elimina un cliente de la base de datos
                	String idCliente = InterfazUsuario.eliminarCliente();
                	conectarCliente.eliminarCliente(idCliente);
                    break;
                    
                case InterfazUsuario.CREAR_PRODUCTO:  // 5
                	//Aqui se ingresara un producto a la base de datos
                	producto = InterfazUsuario.ingresarProducto();
                	conectarProducto.guardarProducto(producto);
                    break;
   
                case InterfazUsuario.VER_PRODUCTOS:  // 6
                	//Aqui se mostrara los productos de la base de datos
                	conectarProducto.mostrarProductos();
                    break;
                
                case InterfazUsuario.CREAR_PEDIDO:  // 7
                	boolean existe = false; // servira para saber si existe el producto
                	String continuar = "s"; // para decir si queremos agregar mas prodcutos
                	
                	pedido = InterfazUsuario.crearPedido(); // pide los datos del cliente
                	conectarPedidoProducto.crearPedido(pedido); // crea el pedido
                	//obtiene el id del pedido creado
                	String id_pedido = conectarPedidoProducto.ultimoIdPedidoIngresado();
                	do {
                		do { // seguira pidiendo el producto hasta encontrarlo
                    		String nombre_product = InterfazUsuario.buscarNombreProducto();
                    		existe = conectarPedidoProducto.buscarProducto(nombre_product); // devolvera el datos del producto
    					} while (existe == false);
                		String id_producto = InterfazUsuario.ingresarIdProducto();
                    	conectarPedidoProducto.cargarListaPedido(id_pedido, id_producto); // carga el producto en la lista del pedido
                    	continuar = InterfazUsuario.continuarComprando(); // verifica si quieres contuniar agregando
					} while (continuar.equals("s"));
                    break;
                    
                case InterfazUsuario.BUSCAR_PEDIDO_ID:  // 8
              
                	
                	
                    break;
                    
                case InterfazUsuario.BUSCAR_PEDIDO_CLIENTE:  // 9
                	
                	
                	
                    break;
                
                case InterfazUsuario.SALIR:
                	
    	
                    break;    
                default:
                    System.out.println("Opcio incorrecta");
                    break;
            }
        } while (opcion != InterfazUsuario.SALIR);
		
		


		

	}

}


/*
//sirve para poner la fecha con hora definida por el sistema
LocalDateTime localDateTime = LocalDateTime.now();
DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/LL/yyyy");
String datoFecha = localDateTime.format(fecha);
	
DateTimeFormatter hora = DateTimeFormatter.ofPattern("hh:mm:ss");
String datoHora = localDateTime.format(hora);
	
System.out.println("formato standar: " + localDateTime);
System.out.println("\n----------------------------------");
System.out.println("formato fecha: " + datoFecha);
System.out.println("\n----------------------------------");
System.out.println("formato hora: " + datoHora);
 
 
 
//pasar de LocalDate a String
LocalDate localDate = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LL/yyyy");
String formattedString = localDate.format(formatter);
System.out.println(formattedString);
*/

/*
//pasa de String a LocalDate
LocalDate fechaCaducidad;
String ddmmAA = "13/11/2018";
fechaCaducidad = LocalDate.parse(ddmmAA, DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT));
System.out.println(fechaCaducidad);
*/

/* 
//Contar dias de caducidad
LocalDate fechaActual = LocalDate.now();
System.out.println("Fecha actual: " + fechaActual);
LocalDate fechaCaducidad;
String ddmmAA = "13/11/2018";
fechaCaducidad = LocalDate.parse(ddmmAA, DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT));
long diasRestantes = ChronoUnit.DAYS.between(fechaActual, fechaCaducidad);
System.out.println("Fecha caducidad: " + fechaCaducidad);
System.out.println(diasRestantes);
*/


