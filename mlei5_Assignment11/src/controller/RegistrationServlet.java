package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;

import data.RegistrationDB;
import mailutils.MailUtilGmail;
import model.CostInformation;
import model.RegistrationInfo;
import service.RegistrationService;
import service.RegistrationServiceImplement;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void destroy() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/result.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegistrationService registrationService = new RegistrationServiceImplement();

		// get request parameters
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		List<String> courses = Arrays.asList(request.getParameterValues("courses"));
		String employmentStatus = request.getParameter("employmentStatus");
		String hotel = request.getParameter("hotel");
		String parking = request.getParameter("parking");
		
		RegistrationInfo reg=new RegistrationInfo(name,email,courses,employmentStatus,hotel,parking);
		
		// check user select a course or not
		if (courses == null || courses.isEmpty()) {
			response.getOutputStream().print("You have to choose at least one course.");

			// check user select employment status
		} else if (StringUtils.isEmpty(employmentStatus)) {

			response.getOutputStream().print("You have to select one of the Empolyment Status.");

			// We will continue if user selects both courses and employment status
		} else {
			registrationService.setRegistrationInfo(name, email, courses, employmentStatus, hotel, parking);

			HttpSession session = request.getSession();
			session.setAttribute("registrationService", registrationService);

			// send data to results.jsp
			String url = "/result.jsp";
//			RegistrationInfo reg=new RegistrationInfo();
			RegistrationServiceImplement regSrv=new RegistrationServiceImplement();
			regSrv.setRegistrationInfo(name, email, courses, employmentStatus, hotel, parking);
			
			CostInformation ci=new CostInformation();
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);
			RegistrationDB.insert(reg,regSrv,ci);
			
			try {
				MailUtilGmail.sendMail(regSrv.getEmail(), 
						   "noreply", 
						   "JHU Software Development Seminar Registration Confirmation", 
						   "Your registration is confirmed for the JHU Software Development Seminar.", 
						   false);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		

		
	}
}