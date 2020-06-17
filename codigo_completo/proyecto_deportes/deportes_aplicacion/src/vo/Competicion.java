package vo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Competicion {
	public int ID;
	public int ID_deporte;
	public String Nombre;
	public String Pais;
	public int Terminada;
	public String Fecha_comienzo;
	public String Fecha_fin;
	public String Imagen;
	
	
	public Competicion(int iD, int iD_deporte, String nombre, String pais, int terminada, String fecha_comienzo,
			String fecha_fin) {
		super();
		ID = iD;
		ID_deporte = iD_deporte;
		Nombre = nombre;
		Pais = pais;
		Terminada = terminada;
		Fecha_comienzo = fecha_comienzo;
		Fecha_fin = fecha_fin;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public int getID_deporte() {
		return ID_deporte;
	}


	public void setID_deporte(int iD_deporte) {
		ID_deporte = iD_deporte;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getPais() {
		return Pais;
	}


	public void setPais(String pais) {
		Pais = pais;
	}


	public int getTerminada() {
		return Terminada;
	}


	public void setTerminada(int terminada) {
		Terminada = terminada;
	}


	public String getFecha_comienzo() {
		return Fecha_comienzo;
	}


	public void setFecha_comienzo(String fecha_comienzo) {
		Fecha_comienzo = fecha_comienzo;
	}


	public String getFecha_fin() {
		return Fecha_fin;
	}


	public void setFecha_fin(String fecha_fin) {
		Fecha_fin = fecha_fin;
	}


	public String getImagen() {
		return Imagen;
	}


	public void setImagen(String imagen) {
		Imagen = imagen;
	}
	
}
