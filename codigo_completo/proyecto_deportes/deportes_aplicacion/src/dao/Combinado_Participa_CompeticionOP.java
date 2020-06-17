package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.DBConnection;
import vo.Combinado_Participa_Competicion;

public class Combinado_Participa_CompeticionOP {
	public void insertarCombinado_Participa_Competicion (Combinado_Participa_Competicion combinado_participa_competicion) {
		DBConnection conex = new DBConnection();
		String sql = "INSERT INTO combinados_participan_en_competiciones VALUES ('" + combinado_participa_competicion.getID_Combinado() + " ','" + combinado_participa_competicion.getID_Competicion() + "', NULL , NULL , NULL)";
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
	
	
	public boolean existeCombinado_Participa_Competicion(Combinado_Participa_Competicion combinado_participa_competicion) {
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM  combinados_participan_en_competiciones WHERE ID_Combinado='" + combinado_participa_competicion.getID_Combinado() + "' AND ID_Competicion='" + combinado_participa_competicion.getID_Competicion() + "' ";
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
