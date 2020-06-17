package servlets_paginas;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import dao_paginas.Pagina_JugadoresOP;
import vo.Jugador;

/**
 * Servlet implementation class Pagina_jugadores
 */
@WebServlet("/Pagina_jugadores")
public class Pagina_jugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Pagina_JugadoresOP operaciones = new Pagina_JugadoresOP();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String pais="";
		pais = request.getParameter("pais");
		String posicion="";
		posicion = request.getParameter("posicion");
		//para conseguir los jugadores de un equipo
		String ID_equipo="";
		ID_equipo = request.getParameter("ID_equipo");
		String ID_deporte="";
		ID_deporte = request.getParameter("ID_deporte");
		
		ArrayList<Jugador> todos_jugadores=new ArrayList<Jugador>();
		//para conseguir un equipo
		if((ID_equipo!=null & ID_equipo!="")&(ID_deporte !=null & ID_deporte !="")) {
			todos_jugadores=operaciones.jugadores_equipo(ID_equipo,ID_deporte);
		}
		else {
			//filtramos por pais y por posicion
			if((pais!=null & pais!="")&(posicion !=null & posicion !="")) {
				todos_jugadores=operaciones.jugadores_filtro_pais_y_posicion(pais,posicion);
				
			}
			//solo para posicion
			else if(posicion!=null & posicion!="") {
				todos_jugadores=operaciones.jugadores_filtro_posicion(posicion);
			}
			
			//solo para pais
			else if(pais!=null & pais!="") {
				todos_jugadores=operaciones.jugadores_filtro_pais(pais);
				
			}
			//si no hay ni paises ni posiciones
			
			else {
				todos_jugadores=operaciones.todos_jugadores();
			}
			//vemos como se imprimen los jugadores
			 //System.out.println(todos_jugadores);
		}
		 String json = new Gson().toJson(todos_jugadores);
		 //System.out.println(json);
		 response.setContentType("text/plain");  
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);
	}
	

}
