package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.DBConnection;
import vo.Combinado_Contrata_Jugador;

//tener en cuenta si tiene la fecha o no para insertar los datos si quiere insertar solo la fecha
public class Combinado_Contrata_JugadorOP {
	
	public void insertarCombinado_Contrata_Jugador (Combinado_Contrata_Jugador combinado_contrata_jugador) {
		DBConnection conex = new DBConnection();
		String sql = "INSERT INTO combinados_contratan_jugadores VALUES ('" + combinado_contrata_jugador.getID_Combinado() + " ','" + combinado_contrata_jugador.getID_Jugador() + "', NULL , NULL)";
		try {
			Statement st = conex.getConnection().createStatement();
			st.execute(sql);
			//st.close();
			conex.getClose();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conex.getClose();
		}
	}
	
	
	public boolean existeCombinado_Contrata_Jugador(Combinado_Contrata_Jugador combinado_contrata_jugador) {
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM  combinados_contratan_jugadores WHERE ID_Combinado='" + combinado_contrata_jugador.getID_Combinado() + "' AND ID_Jugador='" + combinado_contrata_jugador.getID_Jugador() + "' ";
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
