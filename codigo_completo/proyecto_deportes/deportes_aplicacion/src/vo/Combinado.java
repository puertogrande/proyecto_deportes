package vo;

public class Combinado {
	public int ID;
	public String Nombre;
	public int Ano_Creacion;
	public String Procedencia;
	public String Estadio;
	public String Imagen;
	
	public Combinado(int iD, String nombre, int ano_Creacion, String procedencia, String estadio) {
		super();
		ID = iD;
		Nombre = nombre;
		Ano_Creacion = ano_Creacion;
		Procedencia = procedencia;
		Estadio = estadio;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getAno_Creacion() {
		return Ano_Creacion;
	}
	public void setAno_Creacion(int ano_Creacion) {
		Ano_Creacion = ano_Creacion;
	}
	public String getProcedencia() {
		return Procedencia;
	}
	public void setProcedencia(String procedencia) {
		Procedencia = procedencia;
	}
	public String getEstadio() {
		return Estadio;
	}
	public void setEstadio(String estadio) {
		Estadio = estadio;
	}
	public String getImagen() {
		return Imagen;
	}
	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	@Override
	public String toString() {
		return "Combinado [ID=" + ID + ", Nombre=" + Nombre + ", Ano_Creacion=" + Ano_Creacion + ", Procedencia="
				+ Procedencia + ", Estadio=" + Estadio + "]";
	}
	
	
}
