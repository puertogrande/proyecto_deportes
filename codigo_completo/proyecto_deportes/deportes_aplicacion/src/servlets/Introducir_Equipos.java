package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//importar la clase que quieras introducir y el objeto
import dao.CombinadoOP;
import vo.Combinado;

/**
 * Servlet implementation class Introducir_Equipos
 */
@WebServlet("/Introducir_Equipos")
public class Introducir_Equipos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// crear las operaciones para poder utilizarlas
	CombinadoOP operaciones = new CombinadoOP();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Introducir_Equipos() {
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
		//response.setContentType("text/html;charset=UTF-8");

		int ID = Integer.parseInt(request.getParameter("ID"));
		String Nombre = request.getParameter("name");
		int Ano_Creacion = Integer.parseInt(request.getParameter("Ano_Creacion"));
		String Procedencia = request.getParameter("Procedencia");
		String Estadio = request.getParameter("Estadio");

		//creamos el objeto con los parametros recibidos
		Combinado nuevo_equipo = new Combinado(ID,Nombre,Ano_Creacion,Procedencia,Estadio);
		//comprobar que no existe un combinado con ese id
		boolean existe=operaciones.existeCombinado(nuevo_equipo);
		
		if(existe) {
			operaciones.insertarCombinado(nuevo_equipo);
		}
		else {
			response.getWriter().write("Ese equipo ya existe");	
		}
		
	}

}
