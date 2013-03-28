package projet.site.eCommerce.Dao.metier;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.site.eCommerce.Dao.donnees.DAOFactory;
import projet.site.eCommerce.Dao.donnees.DaoProduit;
import projet.site.eCommerce.beans.Produit;

/**
 * Servlet implementation class ProduitMain
 */
@WebServlet("/ProduitMain")
public class ProduitMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory df;
	DaoProduit dp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 ArrayList<Produit> listeProduit=new ArrayList<Produit>();
		 
	       df=DAOFactory.getInstance();
	       dp=df.getProduitDao();
	       listeProduit=dp.getAll();
	            request.setAttribute("listeProduit", listeProduit);
	            
	            RequestDispatcher dis=request.getRequestDispatcher("Main.jsp");
	                             dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
