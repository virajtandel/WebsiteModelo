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

import dao.PublicacaoDAO;
import models.Publicacao;

@WebServlet("/publicacoes")
public class PublicacoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PublicacoesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PublicacaoDAO dao = new PublicacaoDAO();
		ArrayList<Publicacao> publics = new ArrayList<Publicacao>();
		try {
			publics = dao.getPublicacoes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("publics", publics);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/publicacoes.jsp");
		dispatcher.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
