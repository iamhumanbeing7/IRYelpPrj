package TestIndex;

//import com.mongodb.DB;
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.MongoCursor;
//import org.bson.Document;

import java.util.ArrayList;

public class mngdbaccess {

    public static void main( String args[] ){
//        try{
//            MongoClient mongoClient = new MongoClient("localhost",27017);
//            MongoDatabase mdDB = mongoClient.getDatabase( "yelpdataset" );
//            MongoCollection<Document> collection = mdDB.getCollection("business");
//            MongoCursor<Document> mdCursor = collection.find().iterator();
//            try {
//                while(mdCursor.hasNext()) {
//                    Document docObject = mdCursor.next();
//                    ArrayList bzCategories = (ArrayList)docObject.get("categories");
//                    //System.out.println(bzCategories.size());
//                    System.out.println(bzCategories.toString());
//                    System.out.println(bzCategories.get(1));
//                    break;
//                }
//            }
//            finally {
//                mdCursor.close();
//                mongoClient.close();
//            }
//        }
//        catch(Exception e) {
//            System.err.println( e.getClass().getName() + ": " +
//                    e.getMessage() );
//        }
    }

}
