package projet.site.eCommerce.servlets;

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
 * Servlet implementation class GetProduitCategorie
 */
@WebServlet("/GetProduitCategorie")
public class GetProduitCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory df;
	DaoProduit dp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProduitCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<Produit> listeProduit=new ArrayList<Produit>();
		 int c=Integer.parseInt(request.getParameter("id"));
		 
	       df=DAOFactory.getInstance();
	       dp=df.getProduitDao();
	       listeProduit=dp.GetProduitCategorie(c);
	            request.setAttribute("listeProduit", listeProduit);
	            
	            RequestDispatcher dis=request.getRequestDispatcher("Produits.jsp");
	                             dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
