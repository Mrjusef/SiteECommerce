package projet.site.eCommerce.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.site.eCommerce.beans.Produit;

/**
 * Servlet implementation class PrepareModifierProduit
 */
@WebServlet("/PrepareModifierProduit")
public class PrepareModifierProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareModifierProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null; 
		 Statement st=null; 
	     ResultSet rs=null; 
	     ResultSetMetaData rsmd=null;
	    
	     ArrayList<Produit> listeProduit=new ArrayList<Produit>();
	 
	        try { 
	        	Class.forName("com.mysql.jdbc.Driver");	
	  	        System.out.println("Pilote MySQL JDBC chargé");
	            //obtention de la connexion 
	            connection =(Connection) DriverManager.getConnection ("jdbc:mysql://localhost:3306/ecommerce","root",""); 
	            System.out.println("Connexion opérationnelle"); 
	            st=connection.createStatement();
	            rs=st.executeQuery("SELECT `idProduit`, `libelle`, `description`, `prix`, `datePro`, `photo`, `etatproduit` FROM produit where `idProduit`=\""+request.getParameter("id")+"\"; ");
	            Produit p=new Produit();
	            while(rs.next())
	            {
	            
	                    p.setLibelle(rs.getString(2));
	                    p.setPrix(rs.getDouble(4));
	                    p.setIdProduit(rs.getInt(1));
	                    p.setDescription(rs.getString(3));
	           		           	
	            }
	            request.setAttribute("pr", p);
	            
	            RequestDispatcher dis=request.getRequestDispatcher("ModifierProduit.jsp");
	                             dis.forward(request, response);
	        } 
	        catch (ClassNotFoundException e) { 
	            // TODO Auto-generated catch block 
	            e.printStackTrace(); 
	            System.out.println("Erreur lors du chargement du pilote"); 
	        } 
	        catch (SQLException e) { 
	            // TODO Auto-generated catch block 
	            e.printStackTrace(); 
	            System.out.println("Erreur lors de l’établissement de la connexion"); 
	        } 
	 
	        
	        finally {
	        	  try {
	        	  if(rs != null) {
	        	  rs.close();
	        	  rs = null;
	        	  }
	        	  if(st != null) {
	        	  st.close();
	        	  st = null;
	        	  }
	        	  if(connection != null) {
	        	  connection.close();
	        	  connection = null;
	        	  }
	        	  } catch (SQLException e) {}
	        	  }
	        	  
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	doGet(request,response);
	}

}
