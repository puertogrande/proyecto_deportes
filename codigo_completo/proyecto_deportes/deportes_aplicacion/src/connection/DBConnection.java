package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class DBConnection {
	
	/**Parametros de conexion*/
	 /** para conectarse a localhost**/
	   //static String bd = "proyecto_deportes";
	   //static String login = "root";
	   //static String password = "pestillo";
	   String url="jdbc:mysql://dockerizacion_db_1:3306/proyecto_deportes?useTimezone=true&serverTimezone=UTC";
	   String username="root";
	   String password="pestillo";
	   
	   //static String url = "jdbc:mysql://localhost/"+bd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	   //static String url = "jdbc:mysql://localhost/"+bd;
	   
	   
	   
	 
	   Connection connection = null;
	 
	   /** Constructor de DbConnection */
	   public DBConnection() {
	      try{
	         //obtenemos el driver de para mysql
	         Class.forName("com.mysql.jdbc.Driver");
	         //obtenemos la conexion
	         //connection = DriverManager.getConnection(url,login,password);
	         connection = DriverManager.getConnection(url,username,password);
	 
	         if (connection!=null){
	            System.out.println("Conexion a base de datos "+" OK\n");
	         }
	         else {
		        System.out.println("Conexion a base de datos "+" no realizada\n");
	         }
	      }
	      catch(SQLException e){
	         System.out.println(e);
	      }catch(ClassNotFoundException e){
	         System.out.println(e);
	      }catch(Exception e){
	         System.out.println(e);
	      }
	   }
	   /**Permite retornar la conexion*/
	   public Connection getConnection(){
	      return connection;
	   }
	 
	   public void desconectar(){
	      connection = null;
	   }
	   public void getClose() {
		    try{
		    	connection.close();
		    }catch(SQLException ex){

		    }
		}

}