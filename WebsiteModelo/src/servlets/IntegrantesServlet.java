package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IntegranteDAO;
import models.Integrante;

@WebServlet("/integrantes")
public class IntegrantesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IntegrantesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IntegranteDAO dao = new IntegranteDAO();
		ArrayList<Integrante> orients = new ArrayList<Integrante>();
		ArrayList<Integrante> estuds = new ArrayList<Integrante>();
		
		try {
			orients = dao.getIntegrantes(0);
			estuds = dao.getIntegrantes(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("orients", orients);
		request.setAttribute("estuds", estuds);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/integrantes.jsp");
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
