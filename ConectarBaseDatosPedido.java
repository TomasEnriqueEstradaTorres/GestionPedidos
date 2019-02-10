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

	private Connection connection, connection2; // Realizara la conexion con la base de datos
	private Statement statement; // Sirve para procesar una sentencia SQL estática
	private ResultSet resultSet; // Sirve para hacer consultas estaticas
	private PreparedStatement preparedStatement; // sirve para hacer consultas creadas
	
	
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
	
	
	//METODOS
	

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
			System.out.println("\nContinuando...");
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
			System.out.println("\nId Pedido: " + id_pedidoLista + "\tId Porducto: " + id_productoLista);
			
			System.out.println("\nDatos guardados correctamente");
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}
	}
	
	
	public boolean buscarProducto(String nombreProducto) {		
		boolean existe = true; // servira para saber si existe el producto
		try { 
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			preparedStatement = connection.prepareStatement("SELECT * FROM producto WHERE nombre = ?;");
			preparedStatement.setString(1, nombreProducto);
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.first()) { // verifica si existe el cliente
				resultSet.beforeFirst();// volviendo a la fila anterior
				while (resultSet.next()) {  // si lo hay imprime el resultado
					System.out.println("\n\tPRODUCTO ENCONTRADO");
					System.out.println(resultSet.getString("id")  + ": " + 
							   resultSet.getString("nombre") + " - " +
							   resultSet.getString("precio"));
				}
			} else { // si no lo hay aparece este aviso
				System.out.println("\n\tNO SE ENCUENTA EL PRODUCTO");
				existe = false;
			}			
			resultSet.close();
			//statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}
		return existe;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
