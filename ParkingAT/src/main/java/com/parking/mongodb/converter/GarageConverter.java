package com.parking.mongodb.converter;

import org.bson.types.ObjectId;

import com.parking.entity.Garage;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class GarageConverter {

	// convert Garage Object to MongoDB DBObject
	// take special note of converting id String to ObjectId
	public static DBObject toDBObject(Garage g) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("GarageID", g.getGarageID()).append("Location", g.getLocation()).append("Capacity", g.getCapacity()).append("Name", g.getName());
		if (g.getOwnerID() != null)
			builder = builder.append("_id", new ObjectId(g.getOwnerID()));
		return builder.get();
	}

	// convert DBObject Object to Garage
	// take special note of converting ObjectId to String
	public static Garage toGarage(DBObject doc) {
		Garage g = new Garage();
		g.setGarageID((String) doc.get("GarageID"));
		g.setLocation((String) doc.get("Location"));
		g.setCapacity((Integer) doc.get("Capacity"));
		g.setName((String) doc.get("Name"));
		
		ObjectId id = (ObjectId) doc.get("_id");
		g.setOwnerID(id.toString());
		return g;

	}
}


