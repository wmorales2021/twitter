/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelaing.edu.co.ASE.handler;

import escuelaing.ASE.controller.tweets.controller.tweets_controller;
import escuelaing.edu.co.ASE.models.Tweet;
import java.util.List;

/**
 *
 * @author 57311
 */
public class tweetHandler {
    
   
    public List<Tweet> getMethod (){

     tweets_controller controller = new tweets_controller();
     List<Tweet> result = controller.tweets_controller_services();
     return result; 
    }

     public String postMethod(){

     tweets_controller controller = new tweets_controller();
     String result = controller.postController();
     return result;
}

}
