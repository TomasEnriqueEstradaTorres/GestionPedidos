package uF6.ejercicios.practica2.GestionPedidos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectarBaseDatosPedido {
	
	private String protocolo; // esto es la libreria necesaria para la conexion
	private String EndPoint; // esto es el host o lugar donde esta ubicada la base de datos, sea local o remota
	private String puerto; // El puerto por defecto de conexion
	private String baseDatos; // es la base de datos a consultar
	private String estadoSSL; // Es para para que no aparezca la advertencia sobre la conexion SSL
	private String url;
	private String user; // el usuario del gestor de bases de datos
	private String password; // la clave que tiene el usuario.

	private Connection connection; // Realizara la conexion con la base de datos
	private Statement statement; // Sirve para procesar una sentencia SQL estática
	private ResultSet resultSet; // Sirve para hacer consultas estaticas
	private PreparedStatement preparedStatement; // sirve para hacer consultas creadas
		
	protected String[] datosProducto = new String[2]; // sirve para los valores devueltos en la funcion buscarCliente	
	
	//CONSTRUCTOR
	public ConectarBaseDatosPedido() {
		this.protocolo = "jdbc:mysql://";
		this.EndPoint = "localhost:";
		this.puerto = "3306/";
		this.baseDatos = "gestion_pedidos";
		this.estadoSSL = "?useSSL=false";
		this.url = protocolo + EndPoint + puerto + baseDatos + estadoSSL;
		this.user = "root";
		this.password = "yeialel";
	}


	//GETTER Y SETTER
	public String getProtocolo() {
		return protocolo;
	}


	public String getEndPoint() {
		return EndPoint;
	}


	public String getPuerto() {
		return puerto;
	}


	public String getBaseDatos() {
		return baseDatos;
	}


	public String getEstadoSSL() {
		return estadoSSL;
	}


	public String getUrl() {
		return url;
	}


	public String getUser() {
		return user;
	}


	public String getPassword() {
		return password;
	}


	public Connection getConnection() {
		return connection;
	}


	public Statement getStatement() {
		return statement;
	}


	public ResultSet getResultSet() {
		return resultSet;
	}


	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}


	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}


	public void setEndPoint(String endPoint) {
		EndPoint = endPoint;
	}


	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}


	public void setBaseDatos(String baseDatos) {
		this.baseDatos = baseDatos;
	}


	public void setEstadoSSL(String estadoSSL) {
		this.estadoSSL = estadoSSL;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	public void setStatement(Statement statement) {
		this.statement = statement;
	}


	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}


	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
		

	public String[] getDatosProducto() {
		return datosProducto;
	}


	public void setDatosProducto(String[] datosProducto) {
		this.datosProducto = datosProducto;
	}
	
	
	
	
	//METODOS
	
	// creara un pedido con los datos del cliente
	public void crearPedido(Pedido pedido) {
		try {
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword()); // realiza la conexion con la tabla pedido
			preparedStatement = connection.prepareStatement("INSERT INTO pedido(id_cliente, nombre_cliente, fecha, hora) VALUES(?,?,?,?)");
			// recibe los datos del objeto pedido
			preparedStatement.setString(1,pedido.getIdCustomer());
			preparedStatement.setString(2, pedido.getCustomerOrder());
			preparedStatement.setString(3, pedido.getDate());
			preparedStatement.setString(4, pedido.getHour());
			// Ejecutara la sentencia.
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			System.out.println("\nRealizando compra...");
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}
	}
	
	// esta funcion devolvera el ultimo id de pedido ingresado en la tabla "pedido"
	public String ultimoIdPedidoIngresado() {	
		String id = null; // almacenara el ultimo id de la tabla
		String consulta = "select max(id) from pedido"; // encontrara el ultimo id de pedido
		try { 
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			statement = connection.createStatement();
			resultSet = statement.executeQuery(consulta);
			if (resultSet.next()) {  
				id = resultSet.getString(1); // el 1 representa la columna 'id' de la tabla pedidos
			}
			resultSet.close();
			//statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}
		return id; // devuelve el ultimo id de la tabla
	}
	
	
	// esta funcion se encarga de cargar los pedidos en una tabla
	public void cargarListaPedido(String id_pedidoLista, String id_productoLista) {
		try {
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword()); // realiza la conexion con la tabla pedido
			preparedStatement = connection.prepareStatement("INSERT INTO lista_pedido_producto(id_pedido, id_producto) VALUES(?,?)");
			// recibe los datos del objeto pedido
			preparedStatement.setString(1, id_pedidoLista);
			preparedStatement.setString(2, id_productoLista);
			// Ejecutara la sentencia.
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			System.out.println("\nEl producto se ha agregado en:");
			System.out.println("Id Pedido: " + id_pedidoLista + "\tId Porducto: " + id_productoLista);
			//System.out.println("\nDatos guardados correctamente");
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}
	}
	
	
	//Buscara un producto por su nombre
	public String[] buscarProducto(String nombreProducto) {		
		boolean existe = true; // servira para saber si existe el producto
		String idRecibido = null, nombreRecibido = null, precioRecibido = null;
		
		try { 
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			preparedStatement = connection.prepareStatement("SELECT * FROM producto WHERE nombre = ?;");
			preparedStatement.setString(1, nombreProducto);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.first()) { // verifica si existe el cliente
				resultSet.beforeFirst();// volviendo a la fila anterior
				while (resultSet.next()) {  // si lo hay imprime el resultado
					System.out.println("\n\tPRODUCTO ENCONTRADO");
					idRecibido = resultSet.getString("id"); 
					nombreRecibido = resultSet.getString("nombre");
					precioRecibido = resultSet.getString("precio");
					System.out.println(idRecibido + ": " + nombreRecibido + " - " + precioRecibido);			
				}
			} else { // si no lo hay aparece este aviso
				System.out.println("\n\tNO SE ENCUENTA EL PRODUCTO");
				existe = false;
			}	
			// esto seran los datos devueltos necesarios para agregar el produnto a la lista del pedido.
			datosProducto[0] = String.valueOf(existe);
			datosProducto[1] = idRecibido;
	
			resultSet.close();
			//statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}
		return datosProducto;
	}
	
	
	//Busca los datos del cliente por medio del id del pedido
	public void obtenerDatosClientePedido(String idPedido) {
		String identCliente = null, nombreCliente = null, direccionCliente = null; // datos cliente
		try {
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			preparedStatement = connection.prepareStatement("select a.id as Id_cliente, a.nombre as Cliente, a.direccion as Direccion\n" + 
															"from cliente a\n" + 
															" join pedido b\n" + 
															" on b.id_cliente = a.id\n" + 
															" where b.id = ?"); 
			preparedStatement.setString(1, idPedido);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.first()) { // verifica si existe el cliente
				resultSet.beforeFirst();// volviendo a la fila anterior
				System.out.println("\n\tDATO ENCONTRADO");
				while (resultSet.next()) {  // si lo hay imprime el resultado
					identCliente = resultSet.getString("Id_cliente");
					nombreCliente = resultSet.getString("Cliente");
					direccionCliente = resultSet.getString("Direccion");
					System.out.println("Id del Cliente: " + identCliente + "\nNombre: " + nombreCliente + "\nDireccion: " + direccionCliente);	
				}
			} else { // si no lo hay aparece este aviso
				System.out.println("\n\tDATO NO ENCUENTRADO");
			}	
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}	
	}
	

	public void obtenerListaProductos(String idPedido) { // busca los productos por medio del id del pedido
		String idProdcuto = null, nombreProducto = null;
		int cantidadProducto = 0; // la cantidad de productos
		double precioProducto = 0.0; // precio individual de un producto
		double total = 0.0; // Es el precio total de la cantidad de un tipo de producto
		double iva = 0.0;
		double precioTotalParcial = 0.0; // Es el total de la suma de todos los productos
		double precioTotal = 0.0; // Es el precio total mas iva de todo
		
		try {
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			preparedStatement = connection.prepareStatement("select producto.id as Id_Producto, producto.nombre as Producto, count(producto.id) as Cantidad, producto.precio as Precio,count(producto.id)* producto.precio  as Total\n" + 
															"from pedido\n" + 
															" join lista_pedido_producto\n" + 
															" on pedido.id = lista_pedido_producto.id_pedido\n" + 
															" join producto\n" + 
															" on producto.id = lista_pedido_producto.id_producto\n" + 
															" where pedido.id = ?\n" + 
															" group by producto.id"); 
			preparedStatement.setString(1, idPedido);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.first()) { // verifica si existe el cliente
				resultSet.beforeFirst();// volviendo a la fila anterior
				System.out.println("\n\t\t\tPEDIDO Nº " + idPedido);
				System.out.println("-------------------------------------------------------------");
				System.out.format("%5s %15s %15s %10s %11s %n","Id", "Producto", "Cantidad", "Precio", "Total");// formato para el titulo
				while (resultSet.next()) {  // si lo hay imprime el resultado
					idProdcuto = resultSet.getString("Id_producto");
					nombreProducto = resultSet.getString("Producto");
					cantidadProducto = resultSet.getInt("Cantidad");
					precioProducto = resultSet.getDouble("Precio");
					total = resultSet.getDouble("Total");	
					
					precioTotalParcial += total;
					System.out.format("%5s %18s %8d %14.2f  %10.2f %n",idProdcuto, nombreProducto, cantidadProducto, precioProducto, total); // formato para poner los datos
				}
				System.out.println("-------------------------------------------------------------");
				iva = precioTotalParcial * 0.21; // obtiene el iva
				precioTotal = precioTotalParcial + iva; // obtiene el precio total a pagar
				System.out.format("%50s %9.2f %n","TOTAL PARCIAL: ", precioTotalParcial); // esto es el valor total parcial
				System.out.format("%50s %9.2f %n","IVA: ", iva); // es el impuesto
				System.out.format("%50s %9.2f %n","PRECIO TOTAL A PAGAR: ", precioTotal); // el precio total a pagar
				System.out.println("-------------------------------------------------------------");
			} else { // si no lo hay aparece este aviso
				System.out.println("\n\tNO TIENE PEDIDO");
			}	
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}	
	}
	/*NOTAS : FORMATO PARA IMPRIMIR
	 System.out.format("%20s %8d %10.2f  %10.2f %n", nombreProducto, cantidadProducto, precioProducto, total);
	 %20s ==> significa que se deja 20 espacios de tipo caracter abcd
	 %8d  ==> significa que se deja 8 espacios de tipo entero 12345
	 %10.2f  ==> significa que deja 10 espacios de tipo decimal 0.00
	 %n  ==> esto es el salto de linea
	 */

	
	
	



	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
