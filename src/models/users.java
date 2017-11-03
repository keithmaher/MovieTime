package models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import utils.ToJsonString;


public class users{
	
	static Long counter = 1L;
	public Long id = 1L;
	public String firstName;
	public String lastName;
	public String age;
	public String gender;
	public String occupation;
	public String zipcode;
	public Map<Long, movie> movies = new HashMap<>();
	
	
	
	public users(String firstName, String lastName, String age, String gender, String occupation, String zipcode) {
		this.id = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.zipcode = zipcode;
	 }
	 
	 @Override
	  public String toString()
	  {
		 return new ToJsonString(getClass(), this).toString();
	  }

}
