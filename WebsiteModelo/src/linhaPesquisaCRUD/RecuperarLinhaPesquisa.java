package linhaPesquisaCRUD;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LinhaPesquisaDAO;
import models.LinhaPesquisa;

@WebServlet("/RecuperarLinhaPesquisa")
public class RecuperarLinhaPesquisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecuperarLinhaPesquisa() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idLinha"));
		LinhaPesquisaDAO dao = new LinhaPesquisaDAO();
		LinhaPesquisa l = null;
		
		try {
			l = dao.recuperarLinhaPesquisa(id);
		} catch (SQLException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			e.printStackTrace();
			return;
		}
		
		request.setAttribute("lin", l);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarLinhaPesquisa.jsp");
		dispatcher.forward(request,response);
	}

}
