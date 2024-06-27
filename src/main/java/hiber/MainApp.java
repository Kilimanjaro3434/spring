package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW", 3)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Audi", 6)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Mercedes", 7)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }
      User user = userService.getUserByCar("BMW", 3);
      System.out.println("Пользователь с BMW 3: " + user.getFirstName() + " " + user.getLastName());


      context.close();
   }
}
