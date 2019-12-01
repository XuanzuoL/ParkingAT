package com.parking.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.parking.entity.Message;
import com.parking.mongodb.converter.MessageConverter;

//DAO class for different MongoDB CRUD operations
//take special note of "id" String to ObjectId conversion and vice versa
//also take note of "_id" key for primary key
public class MongoDBMessageDAO {
	private DBCollection col;
	
//	@SuppressWarnings("deprecation")
	public MongoDBMessageDAO(MongoClient mongo) {
//		this.col = mongo.getDB("parking").getCollection("Message");
		this.col = (DBCollection) mongo.getDatabase("parking").getCollection("Message");
	}
	
	public Message createMessage(Message c) {
		DBObject doc = MessageConverter.toDBObject(c);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		c.setMessageID(id.toString());
		return c;
	}
	
	
	public Message readMessage(Message c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getMessageID())).get();
		DBObject data = this.col.findOne(query);
		return MessageConverter.toMessage(data);
	}
	
	public void updateMessage(Message c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getMessageID())).get();
		this.col.update(query, MessageConverter.toDBObject(c));
	}

	public List<Message> readAllMessage() {
		List<Message> data = new ArrayList<Message>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Message c = MessageConverter.toMessage(doc);
			data.add(c);
		}
		return data;
	}

	public void deleteMessage(Message c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getMessageID())).get();
		this.col.remove(query);
	}
}
