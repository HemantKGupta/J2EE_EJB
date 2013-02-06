package examples.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;
import javax.persistence.Inheritance;
import javax.persistence.Id;

@Entity
@Table(name="PERSON", schema = "APP")
@Inheritance(strategy=TABLE_PER_CLASS)
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
