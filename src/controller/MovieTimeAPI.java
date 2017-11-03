package controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import utils.Serializer;

import models.movie;
import models.users;

public class MovieTimeAPI {
	
	 private Serializer serializer;

	  public MovieTimeAPI()
	  {
	  }

	  public MovieTimeAPI(Serializer serializer)
	  {
	    this.serializer = serializer;
	  }

	  @SuppressWarnings("unchecked")
	  public void load() throws Exception
	  {
	    serializer.read();
	    userIndex       = (Map<Long, users>)     serializer.pop();
	    nameIndex       = (Map<String, users>)   serializer.pop();
	    movieIndex 		= (Map<Long, movie>)     serializer.pop();
	    titleIndex 		= (Map<String, movie>)   serializer.pop();
	    yearIndex 		= (Map<String, movie>)   serializer.pop();
	  }

	  void store() throws Exception
	  {
	    serializer.push(userIndex);
	    serializer.push(nameIndex);
	    serializer.push(movieIndex);
	    serializer.push(titleIndex);
	    serializer.push(yearIndex);
	    serializer.write(); 
	  }
	
	////////////////////////////////////////////////////////
	/////////////// USER DETAILS  //////////////////////////
	////////////////////////////////////////////////////////
	 
	  private  Map<Long, users> userIndex = new HashMap<Long, users>();
	  private  Map<String, users> nameIndex = new HashMap<String, users>();

	  public users addUser(String firstName, String lastName, String age, String gender, String occupation, String zipcode) 
	  {
	    users user = new users (firstName, lastName, age, gender, occupation, zipcode);
	    userIndex.put(user.id, user);
	    nameIndex.put(firstName, user);
	    return user;
	  }
	  
	  public Collection<users> getUsers ()
	  {
	    return userIndex.values();
	  }
	  
	  public  void deleteUsers() 
	  {
	    userIndex.clear();
	    nameIndex.clear();
	  }
	  
	  public users getUserByName(String firstName) 
	  {
	    return nameIndex.get(firstName);
	  }

	  public void deleteUser(Long id) 
	  {
	    users user = userIndex.remove(id);
	    nameIndex.remove(user.firstName);
	  }
	  
	  public void initisalLoad() throws IOException{
		    
		  String delims = "[|]";
		     Scanner scanner = new Scanner(new File("movies/users5.dat"));
		     while (scanner.hasNextLine()) {
		         String userDetails = scanner.nextLine();
		         // parse user details string
		         String[] userTokens = userDetails.split(delims);

		         if (userTokens.length == 7) {
		        	 String firstname = userTokens[1];
		        	 String lastname = userTokens[2];
		        	 String age = userTokens[3];
		        	 String gender = userTokens[4];
		        	 String occupation = userTokens[5];
		        	 String zipcode = userTokens[6];
		        	 
		        	 addUser(firstname, lastname, age, gender, occupation, zipcode);     
		             
		         } else {
		             scanner.close();
		             throw new IOException("Invalid member length: " + userTokens.length);
		         }
		     }
		     scanner.close();
		     
		     
		 
	  }
	  
	  
/////////////////////////////////////////////////////////////////
/////////////// MOVIE DETAILS  ///////////////////////////////////
/////////////////////////////////////////////////////////////////
	  
	  private  Map<Long, movie> movieIndex = new HashMap<Long, movie>();
	  private  Map<String, movie> titleIndex = new HashMap<String, movie>();
	  private  Map<String, movie> yearIndex = new HashMap<String, movie>();
	  
	  public movie addMovie(Long id, String title, String year, String url) {
		        movie movies = null;
				movies = new movie(title, year, url);
				movieIndex.put(movies.id, movies);
				titleIndex.put(movies.title, movies);
				yearIndex.put(movies.videoYear, movies);
		
			return movies;	
		}
	  
	  public Collection<movie> getMovies ()
	  {
	    return movieIndex.values();
	  }
	  
	  public movie getMovieByTitle(String title) 
		  {
		    return titleIndex.get(title);
		}

		public movie getMoviesByYear(String year) {
			return yearIndex.get(year);
		}

		public void loadMovie() throws IOException {
			
			  String delims = "[|]";
			     Scanner scanner = new Scanner(new File("movies/items5.dat"));
			     while (scanner.hasNextLine()) {
			         String userDetails = scanner.nextLine();
			         // parse user details string
			         String[] userTokens = userDetails.split(delims);

			         if (userTokens.length == 23) {
			        	 
			        	 String title = userTokens[1];
			        	 String year = userTokens[2];
			        	 String url = userTokens[3];
			        	 
			        	 
			        	 addMovie(null, title, year, url);
			             
			         } else {
			             scanner.close();
			             throw new IOException("Invalid member length: " + userTokens.length);
			         }
			     }
			     scanner.close();
		}
}
