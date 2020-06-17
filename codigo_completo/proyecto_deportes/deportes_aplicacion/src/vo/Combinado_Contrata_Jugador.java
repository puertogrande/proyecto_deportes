package vo;

public class Combinado_Contrata_Jugador {
	public int ID_Combinado;
	public int ID_Jugador;
	public String Fecha_Inicio_Contrato;
	public String Fecha_Final_Servicio;
	
	public Combinado_Contrata_Jugador(int iD_Combinado, int iD_Jugador) {
		super();
		ID_Combinado = iD_Combinado;
		ID_Jugador = iD_Jugador;
	}
	
	public int getID_Combinado() {
		return ID_Combinado;
	}

	public void setID_Combinado(int iD_Combinado) {
		ID_Combinado = iD_Combinado;
	}

	public int getID_Jugador() {
		return ID_Jugador;
	}

	public void setID_Jugador(int iD_Jugador) {
		ID_Jugador = iD_Jugador;
	}

	public String getFecha_Inicio_Contrato() {
		return Fecha_Inicio_Contrato;
	}

	public void setFecha_Inicio_Contrato(String fecha_Inicio_Contrato) {
		Fecha_Inicio_Contrato = fecha_Inicio_Contrato;
	}

	public String getFecha_Final_Servicio() {
		return Fecha_Final_Servicio;
	}

	public void setFecha_Final_Servicio(String fecha_Final_Servicio) {
		Fecha_Final_Servicio = fecha_Final_Servicio;
	}

}
