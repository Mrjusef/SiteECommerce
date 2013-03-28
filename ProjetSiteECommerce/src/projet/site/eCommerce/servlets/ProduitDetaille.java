package projet.site.eCommerce.servlets;

import java.io.IOException;

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
 * Servlet implementation class ProduitDetaille
 */
@WebServlet("/ProduitDetaille")
public class ProduitDetaille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory df;
	DaoProduit dp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitDetaille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		df=DAOFactory.getInstance();
	    dp=df.getProduitDao();
	    Produit p=dp.getProduit(id);
	    request.setAttribute("produit", p);
        
        RequestDispatcher dis=request.getRequestDispatcher("DetailleProduit.jsp");
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
