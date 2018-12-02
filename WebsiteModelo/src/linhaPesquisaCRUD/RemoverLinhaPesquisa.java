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

@WebServlet("/RemoverLinhaPesquisa")
public class RemoverLinhaPesquisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoverLinhaPesquisa() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idLinha"));
		
		LinhaPesquisaDAO dao = new LinhaPesquisaDAO();
		try {
			dao.removerLinhaPesquisa(id);
		} catch (SQLException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			e.printStackTrace();
			return;
		}
		
		request.setAttribute("msgSucesso", "Linha de pesquisa removida com sucesso!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin");
		dispatcher.forward(request,response);
	}

}
