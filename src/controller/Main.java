package controller;

import java.io.File;
import java.util.Collection;
import java.util.Scanner;

import models.movie;
import models.users;
import utils.FileLogger;
import utils.Serializer;
import utils.XMLSerializer;

public class Main {
	
	public MovieTimeAPI movietime;
	public Main() throws Exception {
		File userList = new File ("./lib/usersList.xml");
		Serializer serializer = new XMLSerializer(userList);
		movietime= new MovieTimeAPI(serializer);
		if (userList.isFile()) 
		{
			movietime.load();
		}
		
	}
	

	public static void main(String[] args) throws Exception {
		
		Main api = new Main();
		String firstname, lastname, occupation, title, url, gender, age, videoYear, zipcode;
		int choice = 0;
		
		
			api.movietime.initisalLoad();
			api.movietime.loadMovie();
		
		
	        FileLogger logger = FileLogger.getLogger();
			logger.log("Creating - user list");
			     	
	                	do{
	                        System.out.println();
	                        System.out.println("1. List All User Details");
	                        System.out.println("2. Add User");
	                        System.out.println("3. Find User By Name");
	                        System.out.println("4. Delete User By Name");
	                        System.out.println("5. Add Movie");
	                        System.out.println("6. List All Movies");
	                        System.out.println("7. Find Movie By Name");
	                        System.out.println("8. Find Movie By Year");
	                        System.out.println("9. Write users to XML file");
	                        System.out.println("0. Back");
	                        System.out.println();
	                        System.out.print("Enter choice [1-9]: ");
	                        
	                      //get choice
	        	            Scanner sc = new Scanner(System.in);
	        	            choice = sc.nextInt();
	        	            System.out.println();
	        	            //process the menu choice
	                       
	                        
	                        System.out.println();
	                        
	                        //process the menu choice
	                        
	                        switch(choice)
	                        {
	                            case 1: 
	                            	Collection<users> users = api.movietime.getUsers();
	                        	    System.out.println(users);
	                            break;
	                            
	                            case 2: 
	                               System.out.println("Enter your first name: ");
	             			       firstname = EasyScanner.nextString();
	             			       
	             			       System.out.println("Enter your last name: ");
	             			       lastname = EasyScanner.nextString();
	             			       
	             			       System.out.println("Enter your age: ");
	             			       age = EasyScanner.nextString();
	             			       
	             			       System.out.println("Enter your gender: ");
	             			       gender = EasyScanner.nextString();
	             			       
	             			       System.out.println("Enter your occupation: ");
	             			       occupation = EasyScanner.nextString();
	             			       
	             			      System.out.println("Enter your zipcode: ");
	             			       zipcode = EasyScanner.nextString();
	             			       
	             			       api.movietime.addUser(firstname, lastname, age, gender, occupation, zipcode);	     			          
	                               api.movietime.store();
	                               
	                               System.out.println("Thank you for adding "+ firstname + " "
      			      		              + "to the system. ");
	                            break;
	                            
	                            case 3: 
	                            	System.out.println("Enter your first name of who you wish to find: ");
		             			    firstname = EasyScanner.nextString();
	                            	users person = api.movietime.getUserByName(firstname);
	                        	    System.out.println(person);
	                            break;
	                            
	                            case 4: 
		                            	System.out.println("Enter your first name of who you wish to delete: ");
			             			    firstname = EasyScanner.nextString();
	                            		users person1 = api.movietime.getUserByName(firstname);
	                            		api.movietime.deleteUser(person1.id);
	                            	    System.out.println("You Deleted " + firstname);
	                            	    api.movietime.store();
	                            break;
	                            
	                            case 5:
	                            	Long id = 0L;
	                            	System.out.println("Enter title of the movie: ");
	             			       title = EasyScanner.nextString();
	             			       System.out.println("Enter the year it was made: ");
	             			       videoYear = EasyScanner.nextString();
	             			       System.out.println("Enter the movie URL: ");
	             			       url = EasyScanner.nextString();
	             			      api.movietime.store();
	             			       api.movietime.addMovie(id, title, videoYear, url);
	             			       
	                            break;
	                            
	                            case 6:
	                            	Collection<movie> movieList = api.movietime.getMovies();
	                        	    System.out.println(movieList);
	                            break;
	                            case 7:
	                            	System.out.println("Enter the title of the movie you wish to find: ");
		             			    title = EasyScanner.nextString();
	                            	movie movie = api.movietime.getMovieByTitle(title);
	                        	    System.out.println(movie);
	                            break;
	                                
	                            case 8:
	                            	System.out.println("Enter the year of the movies you want to find: ");
		             			    videoYear = EasyScanner.nextString();
	                            	movie year = api.movietime.getMoviesByYear(videoYear);
	                        	    System.out.println(year);
	                            break;
	                            
	                            case 9:
	                            	api.movietime.store();
	                            	System.out.println("Writing File");
	                            break;
	                
				                case 0: 
				                	System.out.println("Thanks Good Bye.");
				                	break;
				                
				                default: System.out.println("Invalid entry");
	                
	            }
	            
	        }
	        while(choice != 0);

		
		
	}
}
