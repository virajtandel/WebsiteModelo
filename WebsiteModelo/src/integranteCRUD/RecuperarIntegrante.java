package integranteCRUD;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IntegranteDAO;
import models.Integrante;

@WebServlet("/RecuperarIntegrante")
public class RecuperarIntegrante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecuperarIntegrante() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idInteg"));
		IntegranteDAO dao = new IntegranteDAO();
		Integrante i = null;
		
		try {
			i = dao.recuperarIntegrante(id);
		} catch (SQLException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			e.printStackTrace();
			return;
		}
		
		request.setAttribute("integ", i);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarIntegrante.jsp");
		dispatcher.forward(request,response);
	}

}
