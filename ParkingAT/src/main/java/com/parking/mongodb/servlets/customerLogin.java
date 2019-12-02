package com.parking.mongodb.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session=request.getSession();
		
		session.invalidate();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerlogin.html");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String Password = request.getParameter("password");
		
		MongoClient mongo = (MongoClient) request.getServletContext()
				.getAttribute("MONGO_CLIENT");
		
		MongoDBCustomerDAO CustomerDAO = new MongoDBCustomerDAO(mongo);
		CustomerDAO.findCustomer(email,Password);
//		Customer customer = new Customer();
//		customer = CustomerDAO.findCustomer(email,Password);
		if(CustomerDAO.findCustomer(email,Password) == null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/customerlogin.html");
			rd.forward(request, response);
		}else {
			HttpSession session=request.getSession();	
			Customer customer = CustomerDAO.findCustomer(email,Password);
			session.setAttribute("customer", customer);	
			//Customer customer = (Customer)session.getAttribute("customer");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/homepage.jsp");
			rd.forward(request, response);}
	}
}
