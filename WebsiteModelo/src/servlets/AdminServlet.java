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
import javax.servlet.http.HttpSession;

import dao.IntegranteDAO;
import dao.LinhaPesquisaDAO;
import dao.PublicacaoDAO;
import dao.SobreLabDAO;
import models.Integrante;
import models.LinhaPesquisa;
import models.Publicacao;
import models.SobreLab;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("usuario") != null) {
			SobreLabDAO sobredao = new SobreLabDAO();
			LinhaPesquisaDAO linhasdao = new LinhaPesquisaDAO();
			PublicacaoDAO pubdao = new PublicacaoDAO();
			IntegranteDAO integdao = new IntegranteDAO();
			SobreLab sobre = null;
			ArrayList<LinhaPesquisa> linhas = null;
			ArrayList<Publicacao> pubs = null;
			ArrayList<Integrante> integs = null;
			try {
				sobre = sobredao.getSobreLab();
				linhas = linhasdao.getLinhasPesquisa();
				pubs = pubdao.getPublicacoes();
				integs = integdao.getIntegrantes(0);
				integs.addAll(integdao.getIntegrantes(1));
				
			} catch (SQLException e) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
				dispatcher.forward(request,response);
				e.printStackTrace();
				return;
			}
			
			request.setAttribute("linhas", linhas);
			request.setAttribute("sobre", sobre);
			request.setAttribute("pubs", pubs);
			request.setAttribute("integs", integs);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
			dispatcher.forward(request,response);
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request,response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
