package in.vicky.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.vicky.main.dao.UserDao;
import in.vicky.main.entity.User;

@SpringBootApplication
public class SpringWebProjectJdbcCrud7Application implements CommandLineRunner {
	
	@Autowired
	private UserDao userdao; 
	public static void main(String[] args) {
		SpringApplication.run(SpringWebProjectJdbcCrud7Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		User user1=new User("Rahul", "rahul@gamil.com", "Male", "Delhi");
		User user2 = new User("Priya", "Priya@gmail.com", "Female", "bharuch");
		
		boolean status = userdao.insertUser(user2);
		
		if(status) {
			System.out.println("Inserted");
		}else {
			System.out.println("Try again !!!");
		}
	}
}
