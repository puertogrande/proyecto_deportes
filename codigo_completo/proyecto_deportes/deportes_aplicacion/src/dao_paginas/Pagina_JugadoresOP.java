//contiene las peticiones para filtrar los jugadores y para jugadores equipo
package dao_paginas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connection.DBConnection;
import java.util.ArrayList;

import vo.Jugador;

public class Pagina_JugadoresOP {
	public ArrayList<Jugador> todos_jugadores() {
		//aqui introduciremos todos los jugadores atletas
		ArrayList<Jugador> listado_jugadores = new ArrayList<Jugador>();
		DBConnection conex = new DBConnection();
		//diferenciar por jugadores
		String sql = "SELECT * FROM jugadores ORDER BY id_deporte";
		try {
			Statement st = conex.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			System.out.println("Se han conseguido todas los jugadores atletas");
				
			while (rs.next()) {
				//System.out.println("llega al bucle");
				Integer ID = Integer.parseInt(rs.getString("ID"));
				Integer ID_Deporte = Integer.parseInt(rs.getString("ID_Deporte"));
				String Nombre =rs.getString("Nombre");
				//la descripcion en principio es nula debemos introducirla por cada jugador
				String Descripcion =rs.getString("Descripcion");
				//TO DO
				//Una vez terminado introducir tambien con la imagen
				String Fecha_Nacimiento =rs.getString("Fecha_Nacimiento");
				String Nacionalidad =rs.getString("Nacionalidad");
				String Rol =rs.getString("Rol");
				String Posicion =rs.getString("Posicion");
				String Imagen =rs.getString("Imagen");
				Jugador jugador = new Jugador(ID,ID_Deporte,Nombre,Descripcion,Fecha_Nacimiento,Nacionalidad,Rol,Posicion,Imagen);
				listado_jugadores.add(jugador);
			}
			
			conex.getClose();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conex.getClose();
		}
		return listado_jugadores;	
	}
	
	public ArrayList<Jugador> jugadores_filtro_pais(String pais) {
		//aqui introduciremos todos los deportes
		//aqui introduciremos todos los jugadores atletas
				ArrayList<Jugador> listado_jugadores = new ArrayList<Jugador>();
				DBConnection conex = new DBConnection();
				//diferenciar por jugadores
				String sql = "SELECT * FROM jugadores WHERE Nacionalidad= '"+pais+"' ORDER BY id_deporte";
				try {
					Statement st = conex.getConnection().createStatement();
					ResultSet rs=st.executeQuery(sql);
					System.out.println("Se han conseguido todas los jugadores atletas");
						
					while (rs.next()) {
						Integer ID = Integer.parseInt(rs.getString("ID"));
						Integer ID_Deporte = Integer.parseInt(rs.getString("ID_Deporte"));
						String Nombre =rs.getString("Nombre");
						//la descripcion en principio es nula
						String Descripcion =rs.getString("Descripcion");
						String Fecha_Nacimiento =rs.getString("Fecha_Nacimiento");
						String Nacionalidad =rs.getString("Nacionalidad");
						String Rol =rs.getString("Rol");
						String Posicion =rs.getString("Posicion");
						String Imagen =rs.getString("Imagen");
						Jugador jugador = new Jugador(ID,ID_Deporte,Nombre,Descripcion,Fecha_Nacimiento,Nacionalidad,Rol,Posicion,Imagen);
						listado_jugadores.add(jugador);
					}
					
					conex.getClose();
					}
				
				catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					conex.getClose();
				}
				return listado_jugadores;
	}
	
	public ArrayList<Jugador> jugadores_filtro_posicion(String posicion) {
		//aqui introduciremos todos los deportes
		//aqui introduciremos todos los jugadores atletas
				ArrayList<Jugador> listado_jugadores = new ArrayList<Jugador>();
				DBConnection conex = new DBConnection();
				//diferenciar por deportes
				String sql = "SELECT * FROM jugadores WHERE Posicion= '"+posicion+"' ORDER BY id_deporte";
				try {
					Statement st = conex.getConnection().createStatement();
					ResultSet rs=st.executeQuery(sql);
						
					while (rs.next()) {
						Integer ID = Integer.parseInt(rs.getString("ID"));
						Integer ID_Deporte = Integer.parseInt(rs.getString("ID_Deporte"));
						String Nombre =rs.getString("Nombre");
						//la descripcion en principio es nula
						String Descripcion =rs.getString("Descripcion");
						String Fecha_Nacimiento =rs.getString("Fecha_Nacimiento");
						String Nacionalidad =rs.getString("Nacionalidad");
						String Rol =rs.getString("Rol");
						String Posicion =rs.getString("Posicion");
						String Imagen =rs.getString("Imagen");
						Jugador jugador = new Jugador(ID,ID_Deporte,Nombre,Descripcion,Fecha_Nacimiento,Nacionalidad,Rol,Posicion,Imagen);
						listado_jugadores.add(jugador);
					}
					
					conex.getClose();
					}
				
				catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					conex.getClose();
				}
				return listado_jugadores;
	}
	
	public ArrayList<Jugador> jugadores_filtro_pais_y_posicion(String pais,String posicion) {
		//aqui introduciremos todos los deportes
		//aqui introduciremos todos los jugadores atletas
				ArrayList<Jugador> listado_jugadores = new ArrayList<Jugador>();
				DBConnection conex = new DBConnection();
				//diferenciar por deportes
				String sql = "SELECT * FROM jugadores WHERE Nacionalidad= '"+pais+"' AND Posicion= '"+posicion+"' ORDER BY id_deporte";
				try {
					Statement st = conex.getConnection().createStatement();
					ResultSet rs=st.executeQuery(sql);
						
					while (rs.next()) {
						Integer ID = Integer.parseInt(rs.getString("ID"));
						Integer ID_Deporte = Integer.parseInt(rs.getString("ID_Deporte"));
						String Nombre =rs.getString("Nombre");
						//la descripcion en principio es nula
						String Descripcion =rs.getString("Descripcion");
						String Fecha_Nacimiento =rs.getString("Fecha_Nacimiento");
						String Nacionalidad =rs.getString("Nacionalidad");
						String Rol =rs.getString("Rol");
						String Posicion =rs.getString("Posicion");	
						String Imagen =rs.getString("Imagen");
						Jugador jugador = new Jugador(ID,ID_Deporte,Nombre,Descripcion,Fecha_Nacimiento,Nacionalidad,Rol,Posicion,Imagen);
						listado_jugadores.add(jugador);
					}
					
					conex.getClose();
					}
				
				catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					conex.getClose();
				}
				return listado_jugadores;
	}
	
	public ArrayList<Jugador> jugadores_equipo(String ID_equipo,String ID_deporte) {
		//aqui introduciremos todos los deportes
		//aqui introduciremos todos los jugadores atletas
				ArrayList<Jugador> listado_jugadores = new ArrayList<Jugador>();
				DBConnection conex = new DBConnection();
				//diferenciar por deportes
				String sql = "select jugadores.* from combinados inner join combinados_contratan_jugadores on combinados.ID=ID_Combinado INNER JOIN jugadores ON jugadores.ID=combinados_contratan_jugadores.ID_Jugador and combinados.ID='"+ID_equipo+"' and jugadores.ID_Deporte='"+ID_deporte+"' ";
				try {
					Statement st = conex.getConnection().createStatement();
					ResultSet rs=st.executeQuery(sql);
					System.out.println("Se han conseguido todas los jugadores atletas");
						
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
						Jugador jugador = new Jugador(ID,ID_Deporte,Nombre,Descripcion,Fecha_Nacimiento,Nacionalidad,Rol,Posicion,Imagen);
						listado_jugadores.add(jugador);
					}
					
					conex.getClose();
					}
				
				catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					conex.getClose();
				}
				return listado_jugadores;
	}
	
	
	
	
	
	
	
	

}
