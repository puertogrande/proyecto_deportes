package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.DBConnection;
import vo.Competicion;
//comprobar que no da errores porque la imagen es nula

public class CompeticionOP {
	public void insertarCompeticion (Competicion competicion) {
		DBConnection conex = new DBConnection();
		String sql = "INSERT INTO competiciones VALUES ('" + competicion.getID() + " ','" + competicion.getID_deporte() + "', '" + competicion.getNombre() + "', '" + competicion.getPais() + "','" + competicion.getTerminada() + "','" + competicion.getFecha_comienzo() + "','" + competicion.getFecha_fin() + "', NULL)";
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
	
	public boolean existeCompeticion(Competicion competicion) {
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM  competiciones WHERE id='" + competicion.getID() + "'";
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
	
	


