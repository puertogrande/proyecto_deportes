package dao_paginas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connection.DBConnection;
import vo.Deporte;

public class Pagina_DeportesOP {
	public ArrayList<Deporte> todos_deportes() {
		//aqui introduciremos todos los deportes
		ArrayList<Deporte> listado_deportes = new ArrayList<Deporte>();
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM deportes";
		try {
			Statement st = conex.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
				
			while (rs.next()) {
				Integer Id = Integer.parseInt(rs.getString("ID"));
				String Nombre =rs.getString("Nombre");
				String Descripcion =rs.getString("Descripcion");
				Deporte deporte = new Deporte(Id,Nombre,Descripcion);
				listado_deportes.add(deporte);
			}
			
			conex.getClose();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conex.getClose();
		}
		return listado_deportes;	
	}

}
