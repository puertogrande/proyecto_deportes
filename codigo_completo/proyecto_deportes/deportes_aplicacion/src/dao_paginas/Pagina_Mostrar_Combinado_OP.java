package dao_paginas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connection.DBConnection;
import java.util.ArrayList;
import vo.Combinado;

public class Pagina_Mostrar_Combinado_OP {
	
	public ArrayList<Combinado> combinados_competicion(String ID_Competicion) {
				
				ArrayList<Combinado> listado_combinados = new ArrayList<Combinado>();
				DBConnection conex = new DBConnection();
				//seleccionar todos los combinados de la liga
				String sql = "SELECT * FROM combinados INNER JOIN combinados_participan_en_competiciones WHERE ID_Combinado=ID and ID_Competicion= '"+ID_Competicion+"'  ";
				
				try {
					Statement st = conex.getConnection().createStatement();
					ResultSet rs=st.executeQuery(sql);
					System.out.println("Se han conseguido todos los equipos de la liga");
						
					while (rs.next()) {
						Integer ID = Integer.parseInt(rs.getString("ID"));
						String Nombre =rs.getString("Nombre");
						Integer Ano_Creacion = Integer.parseInt(rs.getString("Ano_Creacion"));
						String Procedencia =rs.getString("Procedencia");
						String Estadio =rs.getString("Estadio");
						Combinado nuevo_equipo = new Combinado(ID,Nombre,Ano_Creacion,Procedencia,Estadio);
						listado_combinados.add(nuevo_equipo);
						
					}
					
					conex.getClose();
					}
				
				catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					conex.getClose();
				}
				return listado_combinados;
	}

}
