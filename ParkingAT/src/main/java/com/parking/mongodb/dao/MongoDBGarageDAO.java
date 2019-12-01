package com.parking.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.parking.entity.Garage;
import com.parking.mongodb.converter.GarageConverter;

//DAO class for different MongoDB CRUD operations
//take special note of "id" String to ObjectId conversion and vice versa
//also take note of "_id" key for primary key
public class MongoDBGarageDAO {
	private DBCollection col;
	
//	@SuppressWarnings("deprecation")
	public MongoDBGarageDAO(MongoClient mongo) {
//		this.col = mongo.getDB("parking").getCollection("garage");
		this.col = (DBCollection) mongo.getDatabase("parking").getCollection("garage");
	}
	
	public Garage createGarage(Garage c) {
		DBObject doc = GarageConverter.toDBObject(c);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		c.setGarageID(id.toString());
		return c;
	}
	
	
	public Garage readGarage(Garage c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getGarageID())).get();
		DBObject data = this.col.findOne(query);
		return GarageConverter.toGarage(data);
	}
	
	public void updateGarage(Garage c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getGarageID())).get();
		this.col.update(query, GarageConverter.toDBObject(c));
	}

	public List<Garage> readAllGarage() {
		List<Garage> data = new ArrayList<Garage>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Garage c = GarageConverter.toGarage(doc);
			data.add(c);
		}
		return data;
	}

	public void deleteGarage(Garage c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getGarageID())).get();
		this.col.remove(query);
	}
}
