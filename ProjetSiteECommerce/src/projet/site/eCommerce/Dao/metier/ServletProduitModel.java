package projet.site.eCommerce.Dao.metier;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.site.eCommerce.Dao.donnees.DAOFactory;
import projet.site.eCommerce.Dao.donnees.DaoProduit;
import projet.site.eCommerce.beans.Client;
import projet.site.eCommerce.beans.Produit;

/**
 * Servlet implementation class ServletProduitModel
 */
@WebServlet("/ServletProduitModel")
public class ServletProduitModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory df;
	DaoProduit dp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProduitModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	     ArrayList<Produit> listeProduit=new ArrayList<Produit>();
	 
	       df=DAOFactory.getInstance();
	       dp=df.getProduitDao();
	       listeProduit=dp.getAll();
	            request.setAttribute("listeProduit", listeProduit);
	            
	            RequestDispatcher dis=request.getRequestDispatcher("Produits.jsp");
	                             dis.forward(request, response);
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
