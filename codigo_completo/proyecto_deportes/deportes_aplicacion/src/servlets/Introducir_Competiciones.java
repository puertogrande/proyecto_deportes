package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//importar la clase que quieras introducir y el objeto
import dao.CompeticionOP;
import vo.Competicion;


/**
 * Servlet implementation class Introducir_Competiciones
 */
@WebServlet("/Introducir_Competiciones")
public class Introducir_Competiciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CompeticionOP operaciones = new CompeticionOP();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Introducir_Competiciones() {
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
		String Pais = request.getParameter("Pais");
		int Terminada = 0;
		if(Boolean.valueOf(request.getParameter("Terminada"))!=false) {
			Terminada=1;
		}
		String Fecha_comienzo = request.getParameter("Fecha_comienzo");
		String Fecha_fin = request.getParameter("Fecha_fin");
		
		Competicion nueva_competicion = new Competicion(ID,1,Nombre,Pais,Terminada,Fecha_comienzo,Fecha_fin);
		boolean existe=operaciones.existeCompeticion(nueva_competicion);
		
		if(existe) {
			operaciones.insertarCompeticion(nueva_competicion);
		}
		else {
			response.getWriter().write("Ese equipo ya existe");
		}
		
	}
				
}


