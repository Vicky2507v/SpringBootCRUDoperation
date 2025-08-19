package in.vicky.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.vicky.main.entity.User;
import in.vicky.main.userdao.UserDao;

@SpringBootApplication
public class SpringWebProjectJdbcCrudDeleteApplication implements CommandLineRunner{
	

	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringWebProjectJdbcCrudDeleteApplication.class, args);
	}
	
	@Autowired
	private UserDao userdao;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Shreya", "shreya@gmail.com", "Female", "pune");
		
		boolean status = userdao.deleteUser(user);
		
		if(status) {
			System.out.println("Deleted ");
		}else {
			System.out.println("Try again !!");
		}
	}
}
