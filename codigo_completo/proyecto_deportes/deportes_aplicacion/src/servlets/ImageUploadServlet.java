package servlets;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ImageUploadServlet
 */
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
@WebServlet("/ImageUploadServlet")
public class ImageUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public ImageUploadServlet() {
        // Do Nothing
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.html").forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
 
        // Getting File data
        Part part = request.getPart("imageData");
 
        // Getting Application Path
        String appPath = request.getServletContext().getRealPath("");
        System.out.println(appPath);
 
        // File path where all files will be stored
        String imagePath = appPath + "images";
 
        // Creates the file directory if it does not exists
        File fileDir = new File(imagePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
         
        //Get Image Name
        String imageName = part.getSubmittedFileName();
         
        if(validateImage(imageName)){
            try{
  
                part.write(imagePath + File.separator + imageName);
                System.out.println(imagePath+ File.separator + imageName);
                String todo=imagePath + File.separator + imageName; 
                int length = todo.length();
                System.out.println(length);
                out.print(imagePath+ File.separator + imageName);
            }catch (Exception ex) {
                out.print("<h1>"+ex.getMessage()+"</h1>");
            }
        }else{
            out.print("<h1>Invalid Image Format</h1>");
        }
    }
     
    //Validates uploaded file is Image or not
    private boolean validateImage(String imageName){
        String fileExt = imageName.substring(imageName.length()-3);
        if("jpg".equals(fileExt) || "png".equals(fileExt) || "gif".equals(fileExt))
            return true;
         
        return false;
    }

}
