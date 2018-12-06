package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.RegistrationService;

/**
 * Servlet implementation class RemoveCourse
 */
@WebServlet("/remove")
public class RemoveCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/result.jsp";
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course=request.getParameter("course");
		HttpSession session=request.getSession();
		RegistrationService registrationService=(RegistrationService)session.getAttribute("registrationService");
		
		registrationService.removeCourse(course);
		session.setAttribute("registrationService", registrationService);
		
		String url="/result.jsp";
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
