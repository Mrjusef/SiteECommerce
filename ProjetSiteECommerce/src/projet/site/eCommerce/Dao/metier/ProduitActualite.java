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
 * Servlet implementation class ServletProduitActualite
 */
@WebServlet("/ProduitActualite")
public class ProduitActualite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory df;
	DaoProduit dp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitActualite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		df=DAOFactory.getInstance();
	       dp=df.getProduitDao();
		ArrayList<Produit> listeProduit=dp.GetActualite();		 	       	  
	            request.setAttribute("listeProduit", listeProduit);
	            
	           request.getRequestDispatcher("Actualite.jsp").forward(request, response);
	                             
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
