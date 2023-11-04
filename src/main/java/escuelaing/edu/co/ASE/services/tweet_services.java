/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelaing.edu.co.ASE.services;



import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import escuelaing.edu.co.ASE.models.Tweet;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author wmorales
 */
public class tweet_services {
    
   // private String mongoUri = "mongodb+srv://moralesradawilson:sEdgUsVrGeU4TcGG@cluster0.k8jdpyl.mongodb.net/tweet?retryWrites=true&w=majority";
    private String mongoUri = "mongodb://moralesradawilson:sEdgUsVrGeU4TcGG@ac-ala5yde-shard-00-00.k8jdpyl.mongodb.net:27017,ac-ala5yde-shard-00-01.k8jdpyl.mongodb.net:27017,ac-ala5yde-shard-00-02.k8jdpyl.mongodb.net:27017/tweets?ssl=true&replicaSet=atlas-1ubx2b-shard-0&authSource=admin&retryWrites=true&w=majority";
    MongoClientURI client = new MongoClientURI(mongoUri);
    MongoClient mongoClient = new MongoClient(client);
    Datastore store = new Morphia().createDatastore(mongoClient, "Twitter");
    
    public String newTweet(Tweet tw){
        
        store.save(tw);
        return "Haz publicado un tweet!";
        
    }
    
    public List<Tweet> tweets_stream(){
        
        List<Tweet> list = store.find(Tweet.class).asList();
        if (list != null){
            return list;
        }
        return null;
    }
           
}
