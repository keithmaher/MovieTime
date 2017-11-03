package models;

import java.util.ArrayList;
import java.util.List;

import utils.ToJsonString;

public class movie{
	
	 static Long counter = 1L;
	 public Long id;
	 public String title;
	 public String videoYear;
	 public String url;
	 
	 public List<ratings> movie  = new ArrayList<>();
	 
	 public movie(String title, String year, String url)
	 {
	 this.id = counter++;;
	 this.title = title;
	 this.videoYear = year;
	 this.url = url;
	 }
	 
	 @Override
	  public String toString()
	  {
		 return new ToJsonString(getClass(), this).toString();
	  }

}
