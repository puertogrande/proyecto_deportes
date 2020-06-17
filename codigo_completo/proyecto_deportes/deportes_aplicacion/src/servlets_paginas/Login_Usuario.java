package servlets_paginas;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioOP;
import vo.Usuario;

/**
 * Servlet implementation class Login_Usuario
 */
@WebServlet("/Login_Usuario")
public class Login_Usuario extends HttpServlet {
		private static final long serialVersionUID = 1L;
		// Creamos una instancia del objeto UsuarioOP sobre el que realizaremos las operaciones
		UsuarioOP operaciones = new UsuarioOP();
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("Se ha llamado al JAVA");
		String Nick = request.getParameter("Nick");
		String Password = request.getParameter("Password");
		
		//crear el hash de la contraseña
	    String generatedPassword = null;
        
	    try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(Password.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
		
		boolean Usuario_Correcto=operaciones.loginUsuario(Nick,generatedPassword);
		if(Usuario_Correcto) {
			response.getWriter().write("Los datos son erroneos");
		}
		else {
			HttpSession misession= request.getSession(true);
			Usuario usuario=operaciones.conseguir_usuario(Nick);
			misession.setAttribute("usuario",usuario);
			response.getWriter().write("El registro es correcto");		
		}
		
	}

}
