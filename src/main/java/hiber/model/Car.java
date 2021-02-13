package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "model")
   private String model;

   @Column(name = "serias")
   private int serias;

   @OneToOne(mappedBy = "users")
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

   @Override
   public String toString() {
      return "Car{" +
              "id=" + id +
              ", model='" + model + '\'' +
              ", serias=" + serias +
              '}';
   }
}
