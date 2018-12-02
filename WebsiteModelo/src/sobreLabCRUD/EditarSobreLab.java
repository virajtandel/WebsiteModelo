package sobreLabCRUD;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SobreLabDAO;

@WebServlet("/EditarSobreLab")
public class EditarSobreLab extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarSobreLab() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nomeLab");
		String descricao = request.getParameter("descLab");
		
		SobreLabDAO dao = new SobreLabDAO();
		
		try {
			dao.alterarSobreLab(nome, descricao);
		} catch (SQLException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			e.printStackTrace();
			return;
		}
		
		request.setAttribute("msgSucesso", "Informações do laboratório atualizadas com sucesso!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin");
		dispatcher.forward(request,response);
		
	}

}
