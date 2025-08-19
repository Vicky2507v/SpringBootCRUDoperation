package in.vicky.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.vicky.main.entity.User;

@Repository
public class UserDao {
	// Provide CRUD operation method. 
	// JDBC automatically configured JDBC configured
	// With the help of JdbcTemplete we can interact with database via methods
	
	@Autowired
	private JdbcTemplate jdbcTemplete;
	
	public boolean insertUser(User user) {
		boolean status = false;
		try {
			String insert="INSERT INTO `users`(`name`, `email`, `gender`, `city`) VALUES (?,?,?,?)";
			int count = jdbcTemplete.update(insert, user.getName(), user.getEmail(), user.getGender(),user.getCity()); 
			
			if(count>0) {
				status = true;
			}else {
				status = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
}
