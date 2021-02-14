package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void getUserCar(String model, int serias) {
      String hql = "from User where car.model= :model and car.serias = :serias";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("model", model);
      query.setParameter("serias", serias);
      for(User user : query.getResultList()) {
         System.out.println("====================");
         System.out.println("Car = " + user.getCar());
         System.out.println("Name car owner = " + user.getFirstName());
         System.out.println("Surname car owner = " + user.getLastName());
      }
   }

}
