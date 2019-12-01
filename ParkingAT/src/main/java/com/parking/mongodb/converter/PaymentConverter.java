package com.parking.mongodb.converter;

import java.sql.Date;

import org.bson.types.ObjectId;


import com.parking.entity.Payment;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class PaymentConverter {

	// convert Payment Object to MongoDB DBObject
	// take special note of converting id String to ObjectId
	public static DBObject toDBObject(Payment p) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("UserID", p.getUserID()).append("CardNumber", p.getCardNumber()).append("ExpireDate", p.getExpireDate()).append("PaymentType", p.getPaymentType());
		if (p.getPaymentId() != null)
			builder = builder.append("_id", new ObjectId(p.getPaymentId()));
		return builder.get();
	}

	// convert DBObject Object to Payment
	// take special note of converting ObjectId to String
	public static Payment toPayment(DBObject doc) {
		Payment p = new Payment();
		p.setUserID((String) doc.get("UserID"));
		p.setCardNumber((String) doc.get("CardNumber"));
		p.setExpireDate((Date) doc.get("ExpireDate"));
		p.setPaymentType((String) doc.get("PaymentType"));
		
		ObjectId id = (ObjectId) doc.get("_id");
		p.setPaymentId(id.toString());
		return p;

	}
}
