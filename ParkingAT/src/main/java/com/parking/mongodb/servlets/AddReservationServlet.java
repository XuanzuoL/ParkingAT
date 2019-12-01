package com.parking.mongodb.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.mongodb.internal.connection.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.parking.entity.Reservation;
import com.parking.mongodb.dao.MongoDBReservationDAO;

/**
 * Servlet implementation class AddReservationServlet
 */
@WebServlet("/addReservation")
public class AddReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reservationId = request.getParameter("ReservationId");
		if ( reservationId == null || "".equals(reservationId)) {
			throw new ServletException("id missing for edit operation");
		}

		String userID = request.getParameter("DriverLicenceId");
		String garageID = request.getParameter("garageID");
		String spots = request.getParameter("spot");
		Date checkin = null;
		try {
			checkin = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(request.getParameter("checkIn"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Date checkout = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(request.getParameter("checkOut"));
		double price = Double.parseDouble(request.getParameter("price"));
		boolean paid = false;
		String paymentId = request.getParameter("PaymentID");
		if((userID == null || userID.equals(""))||(garageID == null || garageID.equals(""))||(spots == null || spots.equals(""))
				||(checkin==null)){
			request.setAttribute("error", "Mandatory Parameters Missing");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/reservation.html");
			rd.forward(request, response);
		}
		else {
			Reservation r = new Reservation();
			r.setUserID(userID);
			r.setGarageID(garageID);
			r.setPaid(paid);
			r.setEndTime(null);
			r.setPaymentId(paymentId);
			r.setStartTime(checkin);
			r.setPrice(price);
			r.setReservationID(reservationId);
			r.setSpots(spots);
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			MongoDBReservationDAO ReservationDAO = new MongoDBReservationDAO(mongo);
			ReservationDAO.createReservation(r);
			System.out.println("Reservation Added Successfully with id="+r.getReservationID());
			request.setAttribute("success", "Reservation added successfully");
			List<Reservation> reservations = ReservationDAO.readAllReservation();
			request.setAttribute("reservations", reservations);

			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/customerlogin.html");
			rd.forward(request, response);
		}
	}
}
