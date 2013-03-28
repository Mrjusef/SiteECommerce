package projet.site.eCommerce.servlets;

import java.io.IOException;

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
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory df;
	DaoClient dc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.df=DAOFactory.getInstance();
        dc=df.getClientDao();
        String login=request.getParameter("login");
        String pwdd=request.getParameter("pwd");
        System.out.println(login + " "+ pwdd);
        Client c=dc.getUser(login, pwdd);
        request.setAttribute("user", c);
        if(c.getRole()== "client"){
        
        RequestDispatcher dis=request.getRequestDispatcher("indexClient.jsp");
                         dis.forward(request, response);}
        else {
        	  RequestDispatcher dis=request.getRequestDispatcher("indexAdmin.jsp");
              dis.forward(request, response);
        	
        }
        }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
