package examples.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;


@MappedSuperclass
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	
	private int id;
	   private String firstName;
	   private String lastName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	   

}
