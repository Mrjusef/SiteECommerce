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
import projet.site.eCommerce.Dao.donnees.DaoClient;
import projet.site.eCommerce.beans.Client;

/**
 * Servlet implementation class ServletClientModel
 */
@WebServlet("/ServletClientModel")
public class ServletClientModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory df;
	ArrayList<Client> listeClient;
	DaoClient dc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClientModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        this.df=DAOFactory.getInstance();
		        dc=df.getClientDao();
		        listeClient=dc.getAll();
	            request.setAttribute("listeClient", listeClient);
	            
	            RequestDispatcher dis=request.getRequestDispatcher("Clients.jsp");
	                             dis.forward(request, response);
	}
	  
	       
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); 
	}

}
