package vo;

public class Combinado_Participa_Competicion {
	public int ID_Combinado;
	public int ID_Competicion;
	public int Puntos;
	public int Anotaciones_Favor;
	public int Anotaciones_Contra;	
	
	public Combinado_Participa_Competicion(int iD_Combinado, int iD_Competicion, int puntos, int anotaciones_Favor,
			int anotaciones_Contra) {
		super();
		ID_Combinado = iD_Combinado;
		ID_Competicion = iD_Competicion;
		Puntos = puntos;
		Anotaciones_Favor = anotaciones_Favor;
		Anotaciones_Contra = anotaciones_Contra;
	}
	
	public Combinado_Participa_Competicion(int iD_Combinado, int iD_Competicion, int puntos) {
		super();
		ID_Combinado = iD_Combinado;
		ID_Competicion = iD_Competicion;
		Puntos = puntos;
	}

	public Combinado_Participa_Competicion(int iD_Combinado, int iD_Competicion) {
		super();
		ID_Combinado = iD_Combinado;
		ID_Competicion = iD_Competicion;
	}

	public int getID_Combinado() {
		return ID_Combinado;
	}

	public void setID_Combinado(int iD_Combinado) {
		ID_Combinado = iD_Combinado;
	}

	public int getID_Competicion() {
		return ID_Competicion;
	}

	public void setID_Competicion(int iD_Competicion) {
		ID_Competicion = iD_Competicion;
	}

	public int getPuntos() {
		return Puntos;
	}

	public void setPuntos(int puntos) {
		Puntos = puntos;
	}

	public int getAnotaciones_Favor() {
		return Anotaciones_Favor;
	}

	public void setAnotaciones_Favor(int anotaciones_Favor) {
		Anotaciones_Favor = anotaciones_Favor;
	}

	public int getAnotaciones_Contra() {
		return Anotaciones_Contra;
	}

	public void setAnotaciones_Contra(int anotaciones_Contra) {
		Anotaciones_Contra = anotaciones_Contra;
	}
}
