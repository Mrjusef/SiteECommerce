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
import projet.site.eCommerce.Dao.donnees.DaoCategorie;
import projet.site.eCommerce.beans.Categorie;

/**
 * Servlet implementation class ServletCategorieFormulaire
 */
@WebServlet("/ServletCategorieFormulaire")
public class ServletCategorieFormulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory df;
    DaoCategorie dc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCategorieFormulaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Categorie> listeCategorie=new ArrayList<Categorie>();
		df=DAOFactory.getInstance();
		dc=df.getCategorieDao();
		listeCategorie=dc.getAll();
         request.setAttribute("listeCategorie", listeCategorie);
         
         RequestDispatcher dis=request.getRequestDispatcher("AddProduit.jsp");
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
