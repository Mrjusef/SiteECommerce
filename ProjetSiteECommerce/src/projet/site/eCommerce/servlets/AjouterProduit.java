package projet.site.eCommerce.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.site.eCommerce.Dao.donnees.DAOFactory;
import projet.site.eCommerce.Dao.donnees.DaoCategorie;
import projet.site.eCommerce.Dao.donnees.DaoProduit;
import projet.site.eCommerce.beans.Produit;

/**
 * Servlet implementation class AjouterProduit
 */
@WebServlet("/AjouterProduit")
public class AjouterProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory df;
	DaoProduit dp;
	DaoCategorie dc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		df=DAOFactory.getInstance();
		dp=df.getProduitDao();
		dc=df.getCategorieDao();
		int c=dc.getId(request.getParameter("categorie"));
		
		double prix=Double.parseDouble(request.getParameter("prix"));
		Produit p=new Produit();
		p.setLibelle(request.getParameter("libelle"));
		p.setCategorie(c);
		p.setDescription(request.getParameter("description"));
		p.setdProduit(new Date());
		p.setPrix(prix);
		//p.setPhoto(request.getParameter(request.getParameter("photo")));
		p.setPhoto("pc2.jpg");
		
		
		dp.add(p);
		
	          
	            
	            RequestDispatcher dis=request.getRequestDispatcher("ServletProduitModel");
	                             dis.forward(request, response);
	       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     doGet(request,response);
		
	}

}
