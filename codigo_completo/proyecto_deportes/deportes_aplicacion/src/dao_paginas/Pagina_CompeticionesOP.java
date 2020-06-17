package dao_paginas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.DBConnection;
import vo.Competicion;

public class Pagina_CompeticionesOP {
	public ArrayList<Competicion> todas_competiciones() {
		//aqui introduciremos todos los deportes
		ArrayList<Competicion> listado_competiciones = new ArrayList<Competicion>();
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM competiciones ORDER BY ID_deportes, Pais";
		try {
			Statement st = conex.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			System.out.println("Se han conseguido todas las competiciones");
				
			while (rs.next()) {
				System.out.println("llega al bucle");
				Integer Id = Integer.parseInt(rs.getString("ID"));
				Integer ID_deportes =Integer.parseInt(rs.getString("ID_deportes"));
				String Nombre =rs.getString("Nombre");
				String Pais =rs.getString("Pais");
				Integer Terminada =Integer.parseInt(rs.getString("Terminada"));
				String Fecha_comienzo =rs.getString("Fecha_comienzo");
				String Fecha_fin =rs.getString("Fecha_fin");
			
				Competicion competicion = new Competicion(Id,1,Nombre,Pais,Terminada,Fecha_comienzo,Fecha_fin);
				listado_competiciones.add(competicion);
			}
			
			conex.getClose();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conex.getClose();
		}
		return listado_competiciones;	
	}
	
	public ArrayList<Competicion> competiciones_filtro_pais(String pais) {
		//aqui introduciremos todos los deportes
		ArrayList<Competicion> listado_competiciones = new ArrayList<Competicion>();
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM competiciones WHERE PAIS= '"+pais+"' ORDER BY ID_deportes";
		try {
			Statement st = conex.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
				
			while (rs.next()) {
				Integer Id = Integer.parseInt(rs.getString("ID"));
				Integer ID_deportes =Integer.parseInt(rs.getString("ID_deportes"));
				String Nombre =rs.getString("Nombre");
				String Pais =rs.getString("Pais");
				Integer Terminada =Integer.parseInt(rs.getString("Terminada"));
				String Fecha_comienzo =rs.getString("Fecha_comienzo");
				String Fecha_fin =rs.getString("Fecha_fin");
				
				Competicion competicion = new Competicion(Id,1,Nombre,Pais,Terminada,Fecha_comienzo,Fecha_fin);
				listado_competiciones.add(competicion);
			}
			
			conex.getClose();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conex.getClose();
		}
		return listado_competiciones;	
	}
	

}
