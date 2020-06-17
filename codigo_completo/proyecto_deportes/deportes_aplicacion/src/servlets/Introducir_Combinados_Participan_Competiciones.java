package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Combinado_Participa_CompeticionOP;
import vo.Combinado_Participa_Competicion;

/**
 * Servlet implementation class Introducir_Combinados_Participan_Competiciones
 */
@WebServlet("/Introducir_Combinados_Participan_Competiciones")
public class Introducir_Combinados_Participan_Competiciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Combinado_Participa_CompeticionOP operaciones = new Combinado_Participa_CompeticionOP();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Introducir_Combinados_Participan_Competiciones() {
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
		
		
		Combinado_Participa_Competicion nueva_participacion = new Combinado_Participa_Competicion(ID_Combinado,ID_Jugador);
		
		boolean existe=operaciones.existeCombinado_Participa_Competicion(nueva_participacion);
		
		if(existe) {
			System.out.println("La participacion de este equipo no existe por ello la introduzco");
			operaciones.insertarCombinado_Participa_Competicion(nueva_participacion);
		}
		else {
			System.out.println("LA PARTICIPACION YA EXISTE");	
		}
	}

}
