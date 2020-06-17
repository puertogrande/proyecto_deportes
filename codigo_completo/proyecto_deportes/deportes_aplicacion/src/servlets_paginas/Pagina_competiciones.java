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
import dao_paginas.Pagina_CompeticionesOP;
import vo.Competicion;
import vo.Deporte;

/**
 * Servlet implementation class Pagina_competiciones
 */
@WebServlet("/Pagina_competiciones")
public class Pagina_competiciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Pagina_CompeticionesOP operaciones = new Pagina_CompeticionesOP();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pagina_competiciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String pais="";
		pais = request.getParameter("pais");
		
		ArrayList<Competicion> todas_competiciones=new ArrayList<Competicion>();
		if(pais==null || pais=="") {
			todas_competiciones=operaciones.todas_competiciones();
		}
		else {
			 todas_competiciones=operaciones.competiciones_filtro_pais(pais);
		}
			
		 String json = new Gson().toJson(todas_competiciones);
	
		 //debemos pasar una lista con el nombre del deporte perteneciente e la competicion la de 
		 response.getWriter().write(json);
	}

}
