package servlets;

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
 * Servlet implementation class Introducir_Usuario
 */
@WebServlet("/Introducir_Usuario")
public class Introducir_Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Creamos una instancia del objeto UsuarioOP sobre el que realizaremos las operaciones
	UsuarioOP operaciones = new UsuarioOP();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
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
			
		/* El permiso 1 corresponde al administrador y el permiso 2 corresponde a los usuarios colaboradores */
		String Permiso="2";
		Usuario nuevo_usuario = new Usuario(Nick,generatedPassword,Permiso);
		boolean existe=operaciones.existeUsuario(nuevo_usuario);
	
		if(existe) {
			operaciones.insertarUsuario(nuevo_usuario);
			HttpSession misession= request.getSession(true);
			Usuario usuario=operaciones.conseguir_usuario(Nick);
			misession.setAttribute("usuario",usuario);
			response.getWriter().write("correcto");
		}
		else {
			System.out.println("El Nick no está disponible");		
		}
	}
}


