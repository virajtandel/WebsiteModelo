package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.SHA512HashUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String hashSenha = "f6db7d57056b4c61df8b2bc8173cd380e80e2d04b30dddaaa636ff945e5dc883e7759c32158b186baf519b6c68e00ef2ef579228ec1cb4f78785a9551a9e1941";
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("usuario") != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin");
			dispatcher.forward(request,response);
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String senha = (String) request.getParameter("senhaInput");

		senha = SHA512HashUtil.digest(senha);

		if(senha.equals(hashSenha)) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", "admin");
			session.setMaxInactiveInterval(30*60);
			Cookie cookie = new Cookie("usuario", "admin");
			response.addCookie(cookie);
			//SessionUtil.login();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin");
			dispatcher.forward(request,response);
		} else {
			request.setAttribute("msgErro", "Senha incorreta!");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request,response);
		}

	}

}
