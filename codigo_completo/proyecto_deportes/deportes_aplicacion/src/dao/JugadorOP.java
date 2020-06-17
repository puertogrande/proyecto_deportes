package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.DBConnection;
import vo.Jugador;

public class JugadorOP {
	public void insertarJugador(Jugador jugador) {
		DBConnection conex = new DBConnection();
		String sql = "INSERT INTO jugadores VALUES ('" + jugador.getID() + " ','" + jugador.getID_Deporte() + "', '" + jugador.getNombre() + "', NULL , '" + jugador.getFecha_Nacimiento() + "', '" + jugador.getNacionalidad() + "','" + jugador.getRol() + "','" + jugador.getPosicion() + "',NULL)";
		try {
			Statement st = conex.getConnection().createStatement();
			st.execute(sql);
			conex.getClose();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conex.getClose();
		}
	}
	
	public boolean existeJugador(Jugador jugador) {
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM  jugadores WHERE id='" + jugador.getID() + "'";
		try {
			Statement st = conex.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if (rs.next() == false) { 
				System.out.println("ResultSet in empty in Java");
				conex.getClose();
				return true;
			}
			else {
				conex.getClose();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
	
		}
		finally {
			conex.getClose();
		}
		return false;
	}

}
