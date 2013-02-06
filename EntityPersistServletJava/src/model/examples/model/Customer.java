package examples.model;

import javax.persistence.*;

@Entity
public class Customer implements java.io.Serializable {
   @Id
   int id;
   private String firstName;
   private String lastName;
   
      
   public int getId() { return id; }
   public void setId(int id) { this.id = id; }
   
   public String getFirstName() { return firstName; }
   public void setFirstName(String firstName) { this.firstName = firstName; }

   public String getLastName() { return lastName; }
   public void setLastName(String lastName) { this.lastName = lastName; }
   
   
   
}
