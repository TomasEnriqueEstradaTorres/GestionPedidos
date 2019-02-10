package uF6.ejercicios.practica2.GestionPedidos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectarBaseDatosProducto {

	private String protocolo; // esto es la libreria necesaria para la conexion
	private String EndPoint; // esto es el host o lugar donde esta ubicada la base de datos, sea local o remota
	private String puerto; // El puerto por defecto de conexion
	private String baseDatos; // es la base de datos a consultar
	private String estadoSSL; // Es para para que no aparezca la advertencia sobre la conexion SSL
	private String url;
	private String user; // el usuario del gestor de bases de datos
	private String password; // la clave que tiene el usuario.

	private Connection connection; // Realizara la conexion con la base de datos
	private Statement statement; // Sirve para procesar una sentencia SQL est�tica
	private ResultSet resultSet; // Sirve para hacer consultas estaticas
	private PreparedStatement preparedStatement; // sirve para hacer consultas creadas

	// CONSTRUCTOR
	public ConectarBaseDatosProducto() {
		this.protocolo = "jdbc:mysql://";
		this.EndPoint = "localhost:";
		this.puerto = "3306/";
		this.baseDatos = "gestion_pedidos";
		this.estadoSSL = "?useSSL=false";
		this.url = protocolo + EndPoint + puerto + baseDatos + estadoSSL;
		this.user = "root";
		this.password = "yeialel";
	}

	// SETTER Y GETTER
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

	// METODOS

	// Creara un producto en la base de datos
	public void guardarProducto(Producto producto) {
		try {
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword()); // realiza la conexion
			preparedStatement = connection.prepareStatement("INSERT INTO producto(nombre, precio) VALUES(?,?)");
			// recibe los datos del objeto producto
			preparedStatement.setString(1, producto.getNameProduct());
			preparedStatement.setDouble(2, producto.getPrice());
			// Ejecutara la sentencia.
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			System.out.println("\nDatos guardados correctamente");
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}

	}

	// mostrada toda la lista de los productos
	public void mostrarProductos() {
		String consulta = "SELECT * FROM producto";
		try {
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			statement = connection.createStatement();
			resultSet = statement.executeQuery(consulta);

			System.out.println("\nLISTA DE PRODUCTOS");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + " | " + 
								   resultSet.getString("nombre") + "  ==>  " + 
								   resultSet.getString("precio"));
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}
	}

}