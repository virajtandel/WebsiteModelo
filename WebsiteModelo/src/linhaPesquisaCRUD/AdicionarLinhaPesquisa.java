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

@WebServlet("/AdicionarLinhaPesquisa")
public class AdicionarLinhaPesquisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdicionarLinhaPesquisa() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String autores = request.getParameter("orientador");
		String resumo = request.getParameter("resumo");
		String referencias = request.getParameter("referencias").replace("\n", "$");
		
		LinhaPesquisa p = new LinhaPesquisa(titulo, autores, resumo, referencias);
		
		LinhaPesquisaDAO dao = new LinhaPesquisaDAO();
		try {
			dao.inserirLinhaPesquisa(p);
		} catch (SQLException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			e.printStackTrace();
			return;
		}
		
		request.setAttribute("msgSucesso", "Linha de pesquisa adicionada com sucesso!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin");
		dispatcher.forward(request,response);
	}

}
