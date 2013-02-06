package examples.model;

import javax.persistence.*;

@Entity
public class Address implements java.io.Serializable {
	@Id
   int id;
   private String city;
   private String street;
   
   public int getId() { return id; }
   public void setId(int id) { this.id = id; }
   
   public String getCity() { return city; }
   public void setCity(String city) { this.city = city; }

   public String getStreet() { return street; }
   public void setStreet(String street) { this.street = street; }
   
   
   
}
