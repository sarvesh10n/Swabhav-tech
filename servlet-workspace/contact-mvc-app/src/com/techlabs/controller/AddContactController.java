package com.techlabs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlabs.contacts.Contact;
import com.techlabs.model.ContactsProvider;

/**
 * Servlet implementation class AddContactController
 */
@WebServlet("/AddContactController")
public class AddContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContactController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/addContact.jsp");
			view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ContactsProvider contactsProvider = ContactsProvider.getInstance();

		String name = request.getParameter("name");
		String phoneNo = request.getParameter("phoneNo").toString();
		String email = request.getParameter("email");
		Contact c = new Contact(name, phoneNo, email);
		contactsProvider.addStudent(c);
		// request.setAttribute("contacts", contactsProvider.getContacts());
		// RequestDispatcher view = request
		// .getRequestDispatcher("displayContact.jsp");
		// view.forward(request, response);
		response.sendRedirect("DisplayContactController");
	}

}
