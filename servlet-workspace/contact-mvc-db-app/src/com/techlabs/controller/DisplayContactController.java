package com.techlabs.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.contacts.ContactDto;
import com.techlabs.model.ContactsProvider;

/**
 * Servlet implementation class GetContacts
 */
@WebServlet("/DisplayContactController")
public class DisplayContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactsProvider contactProvider=ContactsProvider.getInstance();	
		try {
			contactProvider.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<ContactDto> contacts = null;
		try {
			contacts = contactProvider.getContacts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("contacts", contacts);
		
		RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/displayContact.jsp");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
