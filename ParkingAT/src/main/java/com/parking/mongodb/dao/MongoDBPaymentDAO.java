package com.parking.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.parking.entity.Payment;
import com.parking.mongodb.converter.PaymentConverter;

//DAO class for different MongoDB CRUD operations
//take special note of "id" String to ObjectId conversion and vice versa
//also take note of "_id" key for primary key
public class MongoDBPaymentDAO {
	private DBCollection col;
	
//	@SuppressWarnings("deprecation")
	public MongoDBPaymentDAO(MongoClient mongo) {
//		this.col = mongo.getDB("parking").getCollection("Payment");
		this.col = (DBCollection) mongo.getDatabase("parking").getCollection("payment");
	}
	
	public Payment createPayment(Payment c) {
		DBObject doc = PaymentConverter.toDBObject(c);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		c.setPaymentId(id.toString());
		return c;
	}
	
	
	public Payment readPayment(Payment c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getPaymentId())).get();
		DBObject data = this.col.findOne(query);
		return PaymentConverter.toPayment(data);
	}
	
	public void updatePayment(Payment c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getPaymentId())).get();
		this.col.update(query, PaymentConverter.toDBObject(c));
	}

	public List<Payment> readAllPayment() {
		List<Payment> data = new ArrayList<Payment>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Payment c = PaymentConverter.toPayment(doc);
			data.add(c);
		}
		return data;
	}

	public void deletePayment(Payment c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getPaymentId())).get();
		this.col.remove(query);
	}
}
