package publicacaoCRUD;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PublicacaoDAO;
import models.Publicacao;

@WebServlet("/RecuperarPublicacao")
public class RecuperarPublicacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecuperarPublicacao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idPub"));
		PublicacaoDAO dao = new PublicacaoDAO();
		Publicacao p = null;
		
		try {
			p = dao.recuperarPublicacao(id);
		} catch (SQLException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			e.printStackTrace();
			return;
		}
		
		request.setAttribute("pub", p);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarPublicacao.jsp");
		dispatcher.forward(request,response);
	}

}
