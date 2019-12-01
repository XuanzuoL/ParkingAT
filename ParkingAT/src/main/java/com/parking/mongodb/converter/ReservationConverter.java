package com.parking.mongodb.converter;

import java.sql.Date;

import org.bson.types.ObjectId;

import com.parking.entity.Reservation;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;


public class ReservationConverter {
	// convert Customer Object to MongoDB DBObject
		// take special note of converting id String to ObjectId
		public static DBObject toDBObject(Reservation r) {

			BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
					.append("reservationId", r.getReservationID()).append("userID", r.getUserID()).append("garageID", r.getGarageID()).append("checkIn", r.getStartTime()).append("checkOut", r.getEndTime())
					.append("price", r.getPrice()).append("spot", r.getSpots()).append("paid", r.getPaid()) .append("paymentId", r.getPaymentId());
			//if (c.getDriverLicenceId() != null)
			//	builder = builder.append("_id", new ObjectId(c.getDriverLicenceId()));
			return builder.get();
		}

		// convert DBObject Object to Customer
		// take special note of converting ObjectId to String
		public static Reservation toReservation(DBObject doc) {
			Reservation r = new Reservation();
			r.setUserID((String)doc.get("userID"));
			r.setGarageID((String)doc.get("garageID"));
			r.setPaid((Boolean) doc.get("paid"));
			r.setEndTime((Date)doc.get("checkIn"));
			r.setPaymentId((String)doc.get("paymentId"));
			r.setStartTime((Date)doc.get("checkOut"));
			r.setPrice((Double) doc.get("price"));
			r.setSpots((String)doc.get("spot"));
			
			//ObjectId id = (ObjectId) doc.get("_id");
			r.setReservationID((String) doc.get("reservationId"));
			return r;

		}
}

