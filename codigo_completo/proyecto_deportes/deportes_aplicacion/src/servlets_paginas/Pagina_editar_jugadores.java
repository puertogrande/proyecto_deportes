package servlets_paginas;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import dao_paginas.Pagina_Editar_JugadorOP;
import vo.Jugador;


/**
 * Servlet implementation class Pagina_editar_jugadores
 */
@WebServlet("/Pagina_editar_jugadores")
@MultipartConfig

public class Pagina_editar_jugadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//cambiar por la pagina editar jugadores OP 
	Pagina_Editar_JugadorOP operaciones = new Pagina_Editar_JugadorOP();
	 private ServletFileUpload uploader = null;
		@Override
		public void init() throws ServletException{
			DiskFileItemFactory fileFactory = new DiskFileItemFactory();
			File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
			//carpeta donde asociar las cosas
			fileFactory.setRepository(filesDir);
			this.uploader = new ServletFileUpload(fileFactory);
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		boolean cambio=false;
		System.out.println("Hemos llegado al Servnet de editar jugadores");
		String ID=request.getParameter("ID");
		String ID_Deporte=request.getParameter("ID_Deporte");	
		String Descripcion="";
		String Imagen="";
		Descripcion=request.getParameter("Descripcion");
		//tambien debemos comprobar si ha cambiado la imagen comprobarla con la que se tiene de forma anterior tambien
		Imagen = request.getParameter("Imagen");
		
		//hacer lo mismo con imagen 
		if(Descripcion!=null & Descripcion!=""){
			System.out.println("Vamos a cambiar la Descripcion");
			//todos_jugadores=operaciones.jugadores_filtro_pais_y_posicion(pais,posicion);
			operaciones.cambiar_descripcion(ID,ID_Deporte,Descripcion);
			cambio=true;
		}
		
		if(Imagen!=null & Imagen!=""){
			operaciones.cambiar_imagen(ID,ID_Deporte,Imagen);
			cambio=true;
		}	
		
		if(cambio) {
			response.sendRedirect("index.html");
		}
		else {
			Jugador jugador=operaciones.jugador_seleccionado(ID,ID_Deporte);
			String json = new Gson().toJson(jugador);
			response.setContentType("text/plain");  
			response.setCharacterEncoding("UTF-8");
			if(json !=null) {
				response.getWriter().write(json);
			}
		}
	}
}
