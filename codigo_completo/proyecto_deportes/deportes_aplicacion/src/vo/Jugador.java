package vo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class Jugador {
	public int ID;
	public int ID_Deporte;
	public String Nombre;
	public String Descripcion;
	public String Fecha_Nacimiento;
	public String Nacionalidad;
	public String Rol;
	public String Posicion;
	public String Imagen;
	
	public Jugador(int iD, int iD_Deporte, String nombre, String fecha_Nacimiento, String nacionalidad, String rol,
			String posicion) {
		super();
		ID = iD;
		ID_Deporte = iD_Deporte;
		Nombre = nombre;
		Fecha_Nacimiento = fecha_Nacimiento;
		Nacionalidad = nacionalidad;
		Rol = rol;
		Posicion = posicion;
			
	}
	
	public Jugador(int iD, int iD_Deporte, String nombre, String descripcion, String fecha_Nacimiento,
			String nacionalidad, String rol, String posicion, String imagen) {
		super();
		ID = iD;
		ID_Deporte = iD_Deporte;
		Nombre = nombre;
		Descripcion = descripcion;
		Fecha_Nacimiento = fecha_Nacimiento;
		Nacionalidad = nacionalidad;
		Rol = rol;
		Posicion = posicion;
		Imagen = imagen;
	}


	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getID_Deporte() {
		return ID_Deporte;
	}
	public void setID_Deporte(int iD_Deporte) {
		ID_Deporte = iD_Deporte;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getFecha_Nacimiento() {
		return Fecha_Nacimiento;
	}
	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		Fecha_Nacimiento = fecha_Nacimiento;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public String getRol() {
		return Rol;
	}
	public void setRol(String rol) {
		Rol = rol;
	}
	public String getPosicion() {
		return Posicion;
	}
	public void setPosicion(String posicion) {
		Posicion = posicion;
	}
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		Imagen = imagen;
	}


	@Override
	public String toString() {
		return "Jugador [Nombre=" + Nombre + "]";
	}
	
	
}
	
	