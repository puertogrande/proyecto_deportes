package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.JugadorOP;
import vo.Jugador;
/**
 * Servlet implementation class Introducir_Jugadores
 */
@WebServlet("/Introducir_Jugadores")
public class Introducir_Jugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// crear las operaciones para poder utilizarlas
	JugadorOP operaciones = new JugadorOP();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Introducir_Jugadores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int ID = Integer.parseInt(request.getParameter("ID"));
		String Nombre = request.getParameter("Nombre");
		String Fecha_Nacimiento = request.getParameter("Fecha_Nacimiento");
		String Nacionalidad = request.getParameter("Nacionalidad");
		String Rol = request.getParameter("Rol");
		String Posicion = request.getParameter("Posicion");
		
		//creamos el objeto con los parametros recibidos
		Jugador nuevo_jugador = new Jugador(ID,1,Nombre,Fecha_Nacimiento,Nacionalidad,Rol,Posicion);
		boolean existe=operaciones.existeJugador(nuevo_jugador);
		
		if(existe) {
			operaciones.insertarJugador(nuevo_jugador);
		}
		else {
			response.getWriter().write("Ese jugador ya existe");	
		}
		
	}

}
