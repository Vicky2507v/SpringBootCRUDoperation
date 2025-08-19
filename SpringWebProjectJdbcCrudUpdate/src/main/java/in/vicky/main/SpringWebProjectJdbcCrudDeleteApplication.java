package in.vicky.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.vicky.main.entity.User;
import in.vicky.main.userdao.UserDao;

@SpringBootApplication
public class SpringWebProjectJdbcCrudDeleteApplication implements CommandLineRunner {

	@Autowired
	private UserDao userdao;

	public static void main(String[] args) {
		SpringApplication.run(SpringWebProjectJdbcCrudDeleteApplication.class, args);
	
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Vicky", "vicky@gmail.com", "Male", "Bharuch");
		
//		User user = userdao.get("rahul@gmail.com");
//		user.setCity("london");
		
		boolean status = userdao.updateUser(user);
		
		if(status) {
			System.out.println("Updated");
		}else {
			System.out.println("Try again !!!!");
		}
	}

}
