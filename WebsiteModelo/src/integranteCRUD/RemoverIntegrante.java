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

@WebServlet("/RemoverIntegrante")
public class RemoverIntegrante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoverIntegrante() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idInteg"));
		
		IntegranteDAO dao = new IntegranteDAO();
		try {
			dao.removerIntegrante(id);
		} catch (SQLException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			e.printStackTrace();
			return;
		}
		
		request.setAttribute("msgSucesso", "Integrante removido com sucesso!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin");
		dispatcher.forward(request,response);
	}

}
