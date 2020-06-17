
//TO DO en la base de datos los combinados deben pertenecer solo a un solo deporte por lo que hay que incluir el campo id de deporte en combinados
//hacerlo en la revision una vez que la aplicacion este terminada
//la tabla combinados_participan_en_competiciones por extension tambien debe tener un id de deporte pues es clave primaria


package servlets_paginas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import dao_paginas.Pagina_Mostrar_Combinado_OP;
import vo.Combinado;




/**
 * Servlet implementation class Pagina_mostrar_equipos
 */
@WebServlet("/Pagina_mostrar_equipos")
public class Pagina_mostrar_equipos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Pagina_Mostrar_Combinado_OP operaciones = new Pagina_Mostrar_Combinado_OP();
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String ID=request.getParameter("ID");
		//TO DO en la siguiente revision utilizaremos tambien id de deporte
		String ID_Deporte=request.getParameter("ID_Deporte");
		ArrayList<Combinado> todos_combinados=new ArrayList<Combinado>();
		//TO DO cambiar 
		todos_combinados=operaciones.combinados_competicion(ID);
		
		 String json = new Gson().toJson(todos_combinados);
		 response.setContentType("text/plain");  
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);
	}

}
