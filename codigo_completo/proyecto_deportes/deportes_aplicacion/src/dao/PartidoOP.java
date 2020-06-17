package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.DBConnection;
import vo.Partido;

public class PartidoOP {
	public void insertarPartido(Partido partido) {
		DBConnection conex = new DBConnection();
		String sql = "INSERT INTO partidos VALUES ('" + partido.getID() + " ','" + partido.getID_Competicion() + "', '" + partido.getID_Combinado_Local() + "', '" + partido.getID_Combinado_Visitante() + "' , '" + partido.getNumero_Jornada() + "','" + partido.getGoles_Anotaciones_Local() + "','" + partido.getGoles_Anotaciones_Visitante() + "', '" + partido.getGoles_Anotaciones_Visitante() + "','" + partido.getFecha() + "')";
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
	
	
	public boolean existePartido(Partido partido) {
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM  partidos WHERE id='" + partido.getID() + "'";
		try {
			Statement st = conex.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if (rs.next() == false) { 
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
