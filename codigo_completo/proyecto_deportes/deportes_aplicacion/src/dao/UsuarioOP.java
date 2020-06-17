package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.DBConnection;
import vo.Usuario;

public class UsuarioOP {
	public void insertarUsuario(Usuario usuario) {
		DBConnection conex = new DBConnection();
		String sql = "INSERT INTO usuarios VALUES ('" + usuario.getNick() + " ','" + usuario.getPassword() + "', '" + usuario.getPermiso() + "')";
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
	
	public boolean existeUsuario(Usuario usuario) {
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM  usuarios WHERE Nick='" + usuario.getNick() + "' ";
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
	
	public boolean loginUsuario(String Nick,String Password) {
		System.out.println("SE LLAMA A LA FUNCION de loguear usuario");
		DBConnection conex = new DBConnection();
		String sql = "SELECT * FROM  usuarios WHERE Nick='" + Nick + "' AND  Password='" + Password + "'";
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
	
	public Usuario conseguir_usuario(String Nick_seleccionado) {
		DBConnection conex = new DBConnection();
		//diferenciar por jugadores
		String sql = "SELECT * FROM usuarios WHERE Nick= '"+Nick_seleccionado+"'";
		try {
			Statement st = conex.getConnection().createStatement();
			ResultSet rs=st.executeQuery(sql);
			System.out.println("Se han conseguido al usuario seleccionado");
				
			while (rs.next()) {
				String Nick =rs.getString("Nick");
				String Permiso = rs.getString("Permiso");
				Usuario usuario = new Usuario(Nick,Permiso);
				conex.getClose();
				return usuario;
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
}
