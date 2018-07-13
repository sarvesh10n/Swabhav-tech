package com.techlabs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlabs.captcha.VerifyRecaptcha;
import com.techlabs.model.Account;
import com.techlabs.model.AccountService;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/register.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String gRecaptchaResponse = request
				.getParameter("g-recaptcha-response");
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		if (verify) {

			String name = request.getParameter("userName");
			String password = request.getParameter("password");
			String amount = request.getParameter("initialAmount");

			Account account = new Account(name, password, amount);
			AccountService accService = new AccountService();
			response.sendRedirect("LoginController");
			try {
				accService.register(account);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			RequestDispatcher view=request.getRequestDispatcher("/WEB-INF/register.jsp");
			view.forward(request, response);
		}
	}

}
