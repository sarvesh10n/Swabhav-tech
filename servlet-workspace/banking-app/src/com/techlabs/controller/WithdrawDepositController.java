package com.techlabs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlabs.model.TransactionService;

/**
 * Servlet implementation class WithdrawDepositController
 */
@WebServlet("/WithdrawDepositController")
public class WithdrawDepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WithdrawDepositController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/withdrawDeposit.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("username");
		Double amount=Double.parseDouble(request.getParameter("amount"));
		String type=request.getParameter("type");
		try {
			TransactionService ts=new TransactionService();
			if(ts.withdrawDeposit(name, amount, type))
				response.sendRedirect("DisplayPassbookController");
			else{
				request.setAttribute("error", "Insufficient balance");
				RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/withdrawDeposit.jsp");
				view.forward(request, response);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
