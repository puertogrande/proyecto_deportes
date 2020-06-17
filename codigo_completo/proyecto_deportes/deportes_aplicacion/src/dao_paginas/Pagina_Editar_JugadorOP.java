package dao_paginas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.DBConnection;
import vo.Jugador;

public class Pagina_Editar_JugadorOP {
	//no hace falta pasar los valores a numeros enteros aunque en la base de datos asi lo indique 
	public Jugador jugador_seleccionado(String ID_seleccionado, String ID_Deporte_seleccionado) {
		DBConnection conex = new DBConnection();
		//diferenciar por jugadores
		String sql = "SELECT * FROM jugadores WHERE ID= '"+ID_seleccionado+"' AND ID_Deporte= '"+ID_Deporte_seleccionado+"' ORDER BY id_deporte";
		try {
			Statement st = conex.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while (rs.next()) {
			Integer ID = Integer.parseInt(rs.getString("ID"));
			Integer ID_Deporte = Integer.parseInt(rs.getString("ID_Deporte"));
			String Nombre =rs.getString("Nombre");
			//la descripcion en principio es nula
			String Descripcion =rs.getString("Descripcion");
			//TO DO
			//Una vez terminado introducir tambien con la imagen
			String Fecha_Nacimiento =rs.getString("Fecha_Nacimiento");
			String Nacionalidad =rs.getString("Nacionalidad");
			String Rol =rs.getString("Rol");
			String Posicion =rs.getString("Posicion");
			String Imagen =rs.getString("Imagen");
			
			Jugador jugador_seleccionado = new Jugador(ID,ID_Deporte,Nombre,Descripcion,Fecha_Nacimiento,Nacionalidad,Rol,Posicion,Imagen);
			conex.getClose();
			return jugador_seleccionado;
			}	
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conex.getClose();
		}
		return null;	
	}
	
	//cambiar la descripcion
	//hacer igual para cambiar imagen
	public void cambiar_descripcion(String ID_seleccionado,String ID_Deporte_seleccionado,String Descripcion_introducida) {
		DBConnection conex = new DBConnection();
		String sql = "UPDATE jugadores SET Descripcion = '"+Descripcion_introducida+"' WHERE ID= '"+ID_seleccionado+"' AND ID_Deporte= '"+ID_Deporte_seleccionado+"' ";
		try {
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
			conex.getClose();
			
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conex.getClose();
		}
		
	}
	public void cambiar_imagen(String ID_seleccionado,String ID_Deporte_seleccionado,String Imagen_introducida) {
		
		DBConnection conex = new DBConnection();
		String sql = "UPDATE jugadores SET Imagen = '"+Imagen_introducida+"' WHERE ID= '"+ID_seleccionado+"' AND ID_Deporte= '"+ID_Deporte_seleccionado+"' ";
		try {
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
			conex.getClose();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conex.getClose();
		}
		
	}
	
}
