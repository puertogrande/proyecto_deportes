package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Combinado_Contrata_JugadorOP;
import vo.Combinado_Contrata_Jugador;

/**
 * Servlet implementation class Introducir_Combinados_Contratan_Jugadores
 */
@WebServlet("/Introducir_Combinados_Contratan_Jugadores")
public class Introducir_Combinados_Contratan_Jugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Combinado_Contrata_JugadorOP operaciones = new Combinado_Contrata_JugadorOP();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Introducir_Combinados_Contratan_Jugadores() {
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
		System.out.println("hemos llegado al servlets de contratacion");	
		int ID_Combinado = Integer.parseInt(request.getParameter("ID_Combinado"));
		int ID_Jugador = Integer.parseInt(request.getParameter("ID_Jugador"));
		
		
		Combinado_Contrata_Jugador nueva_contratacion = new Combinado_Contrata_Jugador(ID_Combinado,ID_Jugador);
		
		boolean existe=operaciones.existeCombinado_Contrata_Jugador(nueva_contratacion);
		
		if(existe) {
			System.out.println("el equipo no existe por ello lo introduzco");
			//response.getWriter().write("correcto");
			operaciones.insertarCombinado_Contrata_Jugador(nueva_contratacion);
		}
		else {
			//response.getWriter().write("Ese equipo ya existe");
			System.out.println("LA CONTRATACION YA EXISTE");	
		}
		
	}
	
}


