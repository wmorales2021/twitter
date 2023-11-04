
 
package escuelaing.ASE.controller.tweets.controller;

import com.google.gson.Gson;
import escuelaing.edu.co.ASE.models.Tweet;
import escuelaing.edu.co.ASE.services.tweet_services;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;

/**
 *
 * @author wmorales
 */
public class tweets_controller {
    
    public List<Tweet> tweets_controller_services(){


    
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");

            if (accessControlRequestHeaders != null) {

                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);

            }
 
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");

            if (accessControlRequestMethod != null) {

                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);

            }
 
            return "OK";

        });
 
        before((request, response) -> {

            response.header("Access-Control-Allow-Origin", "*");

            response.header("Access-Control-Request-Method", "GET, POST, PUT, DELETE");

            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");

        });


        Gson gson = new Gson();
        tweet_services service = new tweet_services();
        
        
        
        get("/tweets", (req, res)-> {
            
            res.type("application/json");
            return service.tweets_stream();
        },gson::toJson);

     return service.tweets_stream();
       
    }


      public String postController(){

        Gson gson = new Gson();
        tweet_services service = new tweet_services();
         post("/tweets", (req, res)->{
            res.type("application/json");
            Tweet tw = gson.fromJson(req.body(), Tweet.class);
            UUID id = UUID.randomUUID();
            String id_value = id.toString();
            tw.setTweets_id(id_value);
            tw.setTweets_time(LocalDateTime.now());
            return service.newTweet(tw);
        },gson::toJson);

          return "Tweet publicado";
       }







}
