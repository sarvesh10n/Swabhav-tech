package com.techlabs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class UpdateContactController
 */
@WebServlet("/UpdateContactController")
public class UpdateContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateContactController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			ContactsProvider contactsProvider = ContactsProvider.getInstance();
			ArrayList<Contact> contactList = contactsProvider.getContacts();
			Contact contact = null;
			String id = request.getParameter("id");
			for (Contact c : contactList) {
				if (c.getId().equals(id))
					contact = c;
			}

			request.setAttribute("contact", contact);
			request.setAttribute("id", id);
			RequestDispatcher view = request
					.getRequestDispatcher("/WEB-INF/updateContact.jsp");
			view.forward(request, response);
		} else
			response.sendRedirect("LoginController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ContactsProvider contactsProvider = ContactsProvider.getInstance();
		Contact contact = new Contact(request.getParameter("name"),
				request.getParameter("phoneNo"), request.getParameter("email"));
		contactsProvider.updateStudent(request.getParameter("id"), contact);
		response.sendRedirect("DisplayContactController");
	}

}
