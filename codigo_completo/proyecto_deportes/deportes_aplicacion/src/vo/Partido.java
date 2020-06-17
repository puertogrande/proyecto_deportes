package vo;

public class Partido {
	public int ID;
	public int ID_Competicion;
	public int ID_Combinado_Local;
	public int ID_Combinado_Visitante;
	public int Numero_Jornada;
	public int Goles_Anotaciones_Local;
	public int Goles_Anotaciones_Visitante;
	public int Jugado;
	public String Fecha;
	
	public Partido(int iD, int iD_Competicion, int iD_Combinado_Local, int iD_Combinado_Visitante, int numero_Jornada,
			int goles_Anotaciones_Local, int goles_Anotaciones_Visitante, int jugado, String fecha) {
		super();
		ID = iD;
		ID_Competicion = iD_Competicion;
		ID_Combinado_Local = iD_Combinado_Local;
		ID_Combinado_Visitante = iD_Combinado_Visitante;
		Numero_Jornada = numero_Jornada;
		Goles_Anotaciones_Local = goles_Anotaciones_Local;
		Goles_Anotaciones_Visitante = goles_Anotaciones_Visitante;
		Jugado = jugado;
		Fecha = fecha;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID_Competicion() {
		return ID_Competicion;
	}

	public void setID_Competicion(int iD_Competicion) {
		ID_Competicion = iD_Competicion;
	}

	public int getID_Combinado_Local() {
		return ID_Combinado_Local;
	}

	public void setID_Combinado_Local(int iD_Combinado_Local) {
		ID_Combinado_Local = iD_Combinado_Local;
	}

	public int getID_Combinado_Visitante() {
		return ID_Combinado_Visitante;
	}

	public void setID_Combinado_Visitante(int iD_Combinado_Visitante) {
		ID_Combinado_Visitante = iD_Combinado_Visitante;
	}

	public int getNumero_Jornada() {
		return Numero_Jornada;
	}

	public void setNumero_Jornada(int numero_Jornada) {
		Numero_Jornada = numero_Jornada;
	}

	public int getGoles_Anotaciones_Local() {
		return Goles_Anotaciones_Local;
	}

	public void setGoles_Anotaciones_Local(int goles_Anotaciones_Local) {
		Goles_Anotaciones_Local = goles_Anotaciones_Local;
	}

	public int getGoles_Anotaciones_Visitante() {
		return Goles_Anotaciones_Visitante;
	}

	public void setGoles_Anotaciones_Visitante(int goles_Anotaciones_Visitante) {
		Goles_Anotaciones_Visitante = goles_Anotaciones_Visitante;
	}

	public int getJugado() {
		return Jugado;
	}

	public void setJugado(int jugado) {
		Jugado = jugado;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	
}
	
	


