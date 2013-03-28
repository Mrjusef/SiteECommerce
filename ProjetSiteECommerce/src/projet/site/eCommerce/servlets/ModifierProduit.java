package projet.site.eCommerce.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifierProduit
 */
@WebServlet("/ModifierProduit")
public class ModifierProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Connection connection=null; 
		 Statement st=null; 
	     int rs; 
	    
	    
	   
	        try { 
	        	//chargement du driver 
	        	Class.forName("com.mysql.jdbc.Driver");	
	            System.out.println("Pilote MySQL JDBC chargé"); 
	        } catch (ClassNotFoundException e) { 
	            // TODO Auto-generated catch block 
	            e.printStackTrace(); 
	            System.out.println("Erreur lors du chargement du pilote"); 
	        } 
	 
	        try { 
	        	
	            //obtention de la connexion 
	            connection =(Connection) DriverManager.getConnection ("jdbc:mysql://localhost:3306/ecommerce","root",""); 
	            System.out.println("Connexion opérationnelle"); 
	            st=connection.createStatement();
	            rs=st.executeUpdate("update produit set`libelle`= `description`= `prix`= `datePro`= `photo`= `etatproduit`= `idCategorie`=  where `idProduit`=\""+request.getAttribute("id")+"\"");
	          
	          
	            
	            RequestDispatcher dis=request.getRequestDispatcher("ServletProduitModel");
	                             dis.forward(request, response);
	        } catch (SQLException e) { 
	            // TODO Auto-generated catch block 
	            e.printStackTrace(); 
	            System.out.println("Erreur lors de l’établissement de la connexion"); 
	        } 
	 
	        
	        finally {
	        	  try {
	        	 
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
		// TODO Auto-generated method stub
	}

}
