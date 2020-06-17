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
import dao_paginas.Pagina_DeportesOP;
import vo.Deporte;

/**
 * Servlet implementation class Pagina_deportes
 */
@WebServlet("/Pagina_deportes")
public class Pagina_deportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// crear las operaciones para poder utilizarlas
	Pagina_DeportesOP operaciones = new Pagina_DeportesOP();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pagina_deportes() {
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
		ArrayList<Deporte> todos_deportes=operaciones.todos_deportes();
		String json = new Gson().toJson(todos_deportes); 
		 response.getWriter().write(json);
	}

}
