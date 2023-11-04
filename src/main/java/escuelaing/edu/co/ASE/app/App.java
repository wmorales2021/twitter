package escuelaing.edu.co.ASE.app;

import escuelaing.ASE.controller.tweets.controller.tweets_controller;



/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        tweets_controller controller = new tweets_controller();
        controller.tweets_controller_services();
        controller.postController();
}
}
