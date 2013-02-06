package examples.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import javax.persistence.Inheritance;
import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.DiscriminatorValue;

@Entity
@Table(name="PERSON_HIERARCHY", schema = "APP")
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="DISCRIMINATOR", discriminatorType = STRING)
@DiscriminatorValue("PER")
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
