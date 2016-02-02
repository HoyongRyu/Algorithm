package test;

import java.util.HashMap;
import java.util.Map;
import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class MongoSelect {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		
		MongoClient mongoClient = new MongoClient("localhost", 20017);
		MongoDatabase db = mongoClient.getDatabase("mean");
		
		FindIterable<Document> iterable = db.getCollection("words").find();
		
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document);
		        map.put(document.getString("korWordName"), document.getString("engAbbrName"));
		    }
		});

		System.out.println(map.size());
	}

}
