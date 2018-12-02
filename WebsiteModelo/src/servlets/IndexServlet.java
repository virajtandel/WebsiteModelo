	package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SobreLabDAO;
import models.SobreLab;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SobreLabDAO dao = new SobreLabDAO();
		SobreLab sobre = null;
		try {
			sobre = dao.getSobreLab();
		} catch (SQLException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			e.printStackTrace();
			return;
		}
		
		request.setAttribute("sobre", sobre);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
