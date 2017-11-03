package models;

import models.movie;
import models.ratings;

public class Fixtures {
	
	  public static users[] users =
	  {
	    new users ("Keith","mAHER","24","m","uSELESS","e91w594"),
	    new users ("Keith","mAHER","24","m","uSELESS","e91w594"),
	    new users ("Keith","mAHER","24","m","uSELESS","e91w594"),
	    new users ("Keith","mAHER","24","m","uSELESS","e91w594")
	  };

		public static movie[] movie = 
		{ 
			new movie("Gonnies", "1989", "Gonnies.com"),
			new movie("Twilight", "2008", "Twilight.com"), 
			new movie("Shrek", "2001", "Shrek.org"),
			new movie("Robocop", "1992", "Robocop.net")
		
		};
		
		public static ratings[] rating = 
			{ 
			new ratings(1L, 2L, 3),
			new ratings(2L, 3L, 4),
			new ratings(3L, 4L, 5),
			new ratings(4L, 5L, 6)
		};
}