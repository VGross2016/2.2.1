package hiber.model;

import javax.persistence.*;

@Entity
@Table
public class Car {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String model;

   @Column
   private int serias;

   @OneToOne(mappedBy = "car")
   private User user;

   public Car() {}

   public Car(String model, int serias) {
      this.model = model;
      this.serias = serias;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public int getSerias() {
      return serias;
   }

   public void setSerias(int serias) {
      this.serias = serias;
   }

   @Override
   public String toString() {
      return "Car{" +
              ", model='" + model + '\'' +
              ", serias=" + serias +
              '}';
   }
}
