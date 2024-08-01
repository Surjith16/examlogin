package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dto.User;

@WebServlet("/ulogin")

public class UserLogin {

	
	
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String usermail = req.getParameter("usermail");
		
		String userpassword = req.getParameter("userpassword");
		
		Dao dao = new Dao();
		
		try {
		
		User user = dao.findByEmailUser(usermail);
		
		
		
		if(user!=null && userpassword!=null)
		{
			if(user.getUserpassword().equals(userpassword)) {
				
			HttpSession session = req.getSession();
			session.setAttribute("username", user.getUsername());
			RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
			dispatcher.include(req, resp);
			
			}
			else {
				req.setAttribute("message", "password is wrong");
				RequestDispatcher dispatcher = req.getRequestDispatcher("ulogin.jsp");
				dispatcher.include(req, resp);
			}
//			
		}
		else {
			req.setAttribute("message", "email is wrong");
			RequestDispatcher dispatcher = req.getRequestDispatcher("ulogin.jsp");
			dispatcher.include(req, resp);
			
		}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
