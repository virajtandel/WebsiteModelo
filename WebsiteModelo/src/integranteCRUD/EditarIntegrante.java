package integranteCRUD;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.IntegranteDAO;
import models.Integrante;

@WebServlet("/EditarIntegrante")
public class EditarIntegrante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarIntegrante() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		String nome = null;
		String descricao = null;
		String email = null;
		String website = null;
		int tipo = 0;
		InputStream foto = null;
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> uploadItems = null;
		try {
			uploadItems = upload.parseRequest(request);
		} catch (FileUploadException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			e.printStackTrace();
			return;
		}
		for(FileItem uploadItem : uploadItems)
		{
			if(uploadItem.isFormField())
			{
				String fieldName = uploadItem.getFieldName();
				
				if(fieldName.equals("nome")) {
					nome = uploadItem.getString();
				} else if(fieldName.equals("descricao")) {
					descricao = uploadItem.getString();
				} else if(fieldName.equals("email")) {
					email = uploadItem.getString();
				} else if(fieldName.equals("website")) {
					website = uploadItem.getString();
				} else if(fieldName.equals("tipo")) {
					tipo = Integer.parseInt(uploadItem.getString());
				} else if(fieldName.equals("id")) {
					id = Integer.parseInt(uploadItem.getString());
				}
				
			} else {
				foto = uploadItem.getInputStream();
			}
		}
		
		Integrante i = new Integrante(nome, descricao, email, website, tipo);
		
		IntegranteDAO dao = new IntegranteDAO();
		try {
			if(foto == null)
				dao.alterarIntegrante(id, i);
			else {
				dao.alterarIntegrante(id, i, foto, request.getRealPath("/"));
			}
		} catch (SQLException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			e.printStackTrace();
			return;
		}
		/*String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		
		Integrante i = new Integrante(nome, descricao, email, website, tipo);
		
		IntegranteDAO dao = new IntegranteDAO();
		try {
			dao.alterarIntegrante(id, i);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		request.setAttribute("msgSucesso", "Integrante alterado com sucesso!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin");
		dispatcher.forward(request,response);
		
	}

}
