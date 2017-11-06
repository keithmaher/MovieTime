package models;

import models.movie;
import models.ratings;

public class Fixtures {
	
	  public static users [] users = { 
			new users("Keith", "Maher", "27", "M", "Student", "qqww2233"),
			new users("Niamh", "Maher", "28", "F", "Student", "qqww2233"),
			new users("Eoin", "Kelly", "32", "M", "Student", "qqww2233") 
			};

	public static movie [] movies = { 
			new movie("Saw", "2017", "Saw.com"),
			new movie("Blade Runner", "2017", "Saw.com"), 
			new movie("Thor", "2017", "Thor.com") 
			};

	public static ratings [] rating = { 
			new ratings(1L, 4L, 3), 
			new ratings(2L, 1L, 8) 
			};
}
