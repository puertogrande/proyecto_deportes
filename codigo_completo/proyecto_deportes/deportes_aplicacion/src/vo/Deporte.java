package vo;

public class Deporte {
	public int ID;
	public String Nombre;
	public String Descripcion;
	public String Imagen;
	
	public Deporte(int iD, String nombre, String descripcion) {
		super();
		ID = iD;
		Nombre = nombre;
		Descripcion = descripcion;
	}

	public Deporte(int iD, String nombre, String descripcion, String imagen) {
		super();
		ID = iD;
		Nombre = nombre;
		Descripcion = descripcion;
		Imagen = imagen;
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

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	@Override
	public String toString() {
		return "Deporte [ID=" + ID + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Imagen=" + Imagen + "]";
	}
	
}
