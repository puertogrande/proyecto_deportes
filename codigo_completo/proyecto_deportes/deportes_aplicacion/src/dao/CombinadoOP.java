package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.DBConnection;
import vo.Combinado;
//comprobar que no da errores porque la imagen es nula

public class CombinadoOP{
	public void insertarCombinado (Combinado combinado) {
		DBConnection conex = new DBConnection();
		String sql = "INSERT INTO combinados VALUES ('" + combinado.getID() + " ','" + combinado.getNombre() + "', '" + combinado.getAno_Creacion() + "', '" + combinado.getProcedencia() + "','" + combinado.getEstadio() + "', NULL)";
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
	
	public boolean existeCombinado(Combinado combinado) {
		System.out.println("SE LLAMA A LA FUNCION CONSEGUIR Equipo");
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM  combinados WHERE id='" + combinado.getID() + "'";
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


