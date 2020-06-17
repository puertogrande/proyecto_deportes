package servlets_paginas;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import vo.Usuario;

/**
 * Servlet implementation class Comprobar_sesion
 */
@WebServlet("/Comprobar_sesion")
public class Comprobar_sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("se ha llamado a editar sesion");
		HttpSession misession= (HttpSession) request.getSession();
		System.out.println("este es el usuario");
		HttpSession session = request.getSession(false);
		if (session == null) {
		    // Not created yet. Now do so yourself.
			System.out.println("la sesión aún no ha sido creada");
		    //session = request.getSession();
		} else {
		    // Already created.
			Usuario usuario= (Usuario)misession.getAttribute("usuario");
			if(usuario==null) {
				 response.getWriter().write("no iniciado");
			}
			else {
				 String json = new Gson().toJson(usuario);
				 response.setContentType("text/plain");  
				 response.setCharacterEncoding("UTF-8");
				 response.getWriter().write(json);
			}
								
		}
	}

}
