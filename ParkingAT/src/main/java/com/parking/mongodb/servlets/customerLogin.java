package com.parking.mongodb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.parking.entity.Customer;
import com.parking.mongodb.dao.MongoDBCustomerDAO;

/**
 * Servlet implementation class customerLogin
 */
@WebServlet("/customerLogin")
public class customerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String Password = request.getParameter("password");
		
		System.out.println("email:"+email);
		System.out.println("Password:"+Password);
		
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		
		MongoDBCustomerDAO CustomerDAO = new MongoDBCustomerDAO(mongo);
		CustomerDAO.findCustomer(email,Password);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(CustomerDAO.findCustomer(email,Password)!=true) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerlogin.html");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/homepage.html");
			rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
