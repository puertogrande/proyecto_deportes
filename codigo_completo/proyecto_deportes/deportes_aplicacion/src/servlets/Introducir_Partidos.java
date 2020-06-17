package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PartidoOP;
import vo.Partido;

/**
 * Servlet implementation class Introducir_Partidos
 */
@WebServlet("/Introducir_Partidos")
public class Introducir_Partidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// crear las operaciones para poder utilizarlas
	PartidoOP operaciones = new PartidoOP();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Introducir_Partidos() {
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
		int ID_Competicion = Integer.parseInt(request.getParameter("ID_Competicion"));
		int ID_Combinado_Local = Integer.parseInt(request.getParameter("ID_Combinado_Local"));
		int ID_Combinado_Visitante = Integer.parseInt(request.getParameter("ID_Combinado_Visitante"));	
		int Numero_Jornada = Integer.parseInt(request.getParameter("Numero_Jornada"));
		int Goles_Anotaciones_Local = Integer.parseInt(request.getParameter("Goles_Anotaciones_Local"));
		int Goles_Anotaciones_Visitante = Integer.parseInt(request.getParameter("Goles_Anotaciones_Visitante"));
		int Jugado = Integer.parseInt(request.getParameter("Jugado"));
		String Fecha = request.getParameter("Fecha");
		
		//creamos el objeto con los parametros recibido
		Partido nuevo_partido = new Partido(ID,ID_Competicion,ID_Combinado_Local,ID_Combinado_Visitante,Numero_Jornada,Goles_Anotaciones_Local,Goles_Anotaciones_Visitante,Jugado,Fecha);
		boolean existe=operaciones.existePartido(nuevo_partido);
		
		if(existe) {
			operaciones.insertarPartido(nuevo_partido);
		}
		else {
			response.getWriter().write("Ese jugPartidoador ya existe");	
		}		
	}
		
}


