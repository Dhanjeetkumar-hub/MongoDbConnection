//import com.mongodb.MongoClientURI;
//import com.mongodb.MongoCredential;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
//import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
public class CreatingCollection {
   public static void main( String args[] ) throws Exception{
      // Creating a Mongo client
	 //  MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017"));
	   MongoClient mongo = new MongoClient("localhost",27017);
      // Creating Credentials
      MongoCredential credential;
      //credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
      com.mongodb.client.MongoClient mongoClient = MongoClients.create();
      System.out.println("Connected to the database successfully");
      //Accessing the database
      MongoDatabase database = mongo.getDatabase("myDb");
      DB db1=mongo.getDB("db1");
      //Creating a collection
      DBCollection coll=db1.createCollection("sampleCollection",null);
      
      System.out.println("Collection created successfully");
      //MongoObject ob1=new MongoObject();
      BasicDBObject ob1=new BasicDBObject("name","dhanjeet").append("id", "09").append("address", "delhi");
      BasicDBObject ob2=new BasicDBObject("name","dk").append("id", "08").append("address", "Noida");
      BasicDBObject ob3=new BasicDBObject("name","john").append("id", "88");
     coll.insert(ob1);
     coll.insert(ob2);
     coll.insert(ob3);
     DBCursor curl=coll.find();
     while(curl.hasNext()) {
    	 System.out.println(curl.next());
     }
     BasicDBObject ob4=new BasicDBObject("name","john").append("id", "88");
      coll.remove(ob4);
   }
}