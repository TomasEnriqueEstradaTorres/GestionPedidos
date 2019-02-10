package uF6.ejercicios.practica2.GestionPedidos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectarBaseDatosCliente {
	
	private String protocolo; // esto es la libreria necesaria para la conexion
	private String EndPoint; // esto es el host o lugar donde esta ubicada la base de datos, sea local o remota
	private String puerto;  // El puerto por defecto de conexion
	private String baseDatos; // es la base de datos a consultar
	private String estadoSSL;  //Es para para que no aparezca la advertencia sobre la conexion SSL
	private String url;
	private String user; // el usuario del gestor de bases de datos
	private String password;  // la clave que tiene el usuario.
	
	private Connection connection;  //Realizara la conexion con la base de datos
	private Statement statement; // Sirve para procesar una sentencia SQL estática
	private ResultSet resultSet; // Sirve para hacer consultas estaticas
	private PreparedStatement preparedStatement; // sirve para hacer consultas creadas
	
	//CONSTRUCTOR
	public ConectarBaseDatosCliente() {
		this.protocolo = "jdbc:mysql://"; 
		this.EndPoint = "localhost:"; 
		this.puerto = "3306/";
		this.baseDatos = "gestion_pedidos";
		this.estadoSSL = "?useSSL=false";
		this.url = protocolo + EndPoint + puerto + baseDatos + estadoSSL;
		this.user = "root"; 
		this.password = "yeialel";
	}
	
	//SETTER Y GETTER
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
	
	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
	
	
	//METODOS

	// guardara un cliente en la base de datos
	public void guardarCliente(Cliente cliente) {
		try {
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword()); // realiza la conexion
			preparedStatement = connection.prepareStatement("INSERT INTO cliente(nombre, direccion, codigo_postal, email, telefono) VALUES(?,?,?,?,?)");
			//recibe los datos del objeto cliente
			preparedStatement.setString(1, cliente.getNameCustomer());
			preparedStatement.setString(2, cliente.getAddress());
			preparedStatement.setString(3, cliente.getPostalCode());
			preparedStatement.setString(4, cliente.getEmail());
			preparedStatement.setString(5, cliente.getPhone());
			//Ejecutara la sentencia.
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			System.out.println("\nDatos guardados correctamente");
			
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}	
	}


	// mostrara toda la lista de los clientes
	public void mostrarClientes() {
		String consulta = "SELECT * FROM cliente";
		try {
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			statement = connection.createStatement();
			resultSet = statement.executeQuery(consulta);
			
			System.out.println("\nLISTA DE CLIENTES");
			while (resultSet.next()) {  
				/** mientras alla un siguente registro mas adelante de donde esta el cursor, esto se ejecutara.
				 * Los nombres de los campos deben de ser iguales a los que estan en la BD   */
				System.out.println(resultSet.getString("id")  + " | " + 
								   resultSet.getString("nombre") + " - " +
								   resultSet.getString("direccion")  + " - " + 
								   resultSet.getString("codigo_postal" ) + " - " + 
								   resultSet.getString("email") + " - " + 
								   resultSet.getString("telefono"));
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}
	}

	
	// buscara un cliente por su nombre completo
	public void buscarCliente(String nombreCliente) {		
		try { 
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			preparedStatement = connection.prepareStatement("SELECT * FROM cliente WHERE nombre = ?;");
			preparedStatement.setString(1, nombreCliente);
			resultSet = preparedStatement.executeQuery();
			System.out.println("\nCLIENTE ENCONTRADO");
			while (resultSet.next()) {  
				System.out.println(resultSet.getString("id")  + ": " + 
								   resultSet.getString("nombre") + " - " +
								   resultSet.getString("direccion")  + " - " + 
								   resultSet.getString("codigo_postal" ) + " - " + 
								   resultSet.getString("email") + " - " + 
								   resultSet.getString("telefono"));
			}
			resultSet.close();
			//statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}
	}


	// eliminara un cliente de la base de datos
	public void eliminarCliente(String idCliente) {
		try { 
			connection = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			statement = connection.createStatement();
			
			String consultaBorrado =  "DELETE FROM cliente WHERE id = " + idCliente;
			
			statement.executeUpdate(consultaBorrado);
			System.out.println("\nCLIENTE BORRADO");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("\nNo se encuentra la base de datos");
			e.printStackTrace();
		}
	}

	
}
