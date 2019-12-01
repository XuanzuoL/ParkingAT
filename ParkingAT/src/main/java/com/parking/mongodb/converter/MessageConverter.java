package com.parking.mongodb.converter;

import org.bson.types.ObjectId;


import com.parking.entity.Message;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class MessageConverter {

	// convert Message Object to MongoDB DBObject
	// take special note of converting id String to ObjectId
	public static DBObject toDBObject(Message m) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("MessageContent", m.getMessageContent()).append("Reciever", m.getReciever()).append("Sender", m.getSender());
		if (m.getMessageID() != null)
			builder = builder.append("_id", new ObjectId(m.getMessageID()));
		return builder.get();
	}

	// convert DBObject Object to Message
	// take special note of converting ObjectId to String
	public static Message toMessage(DBObject doc) {
		Message m = new Message();
		m.setMessageContent((String) doc.get("MessageContent"));
		m.setReciever((String) doc.get("Reciever"));
		m.setSender((String) doc.get("Sender"));
		ObjectId id = (ObjectId) doc.get("_id");
		m.setMessageID(id.toString());
		return m;

	}
}

