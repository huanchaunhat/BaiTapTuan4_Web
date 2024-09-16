package vn.iostar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.service.impl.*;
import vn.iostar.service.UserService;

import java.io.IOException;

/**
 * Servlet implementation class CheckForepassUserName
 */
@WebServlet(urlPatterns="/checkuser")
public class CheckPassFromUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CheckPassFromUserName() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/EnterUserName.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		UserService service = new UserServiceImpl();
		String alertMsg = "";

		if (username.isEmpty()) {
			alertMsg = "Vui lòng nhập tài khoản";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/views/EnterUserName.jsp").forward(request, response);
			return;
		}
		if (service.checkExistUsername(username)) {
			request.getRequestDispatcher("/views/forgetpass.jsp").forward(request, response);
		}else {
			alertMsg = "Không có tài khoản này";
			request.setAttribute("alert", alertMsg);
		}

	}

}