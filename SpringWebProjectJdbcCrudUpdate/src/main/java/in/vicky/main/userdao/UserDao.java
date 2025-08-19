package in.vicky.main.userdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.vicky.main.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplete;
		
	public boolean updateUser(User user) {
		boolean status=false;
		try {
			
			String update = "UPDATE `users` SET `email` = ?, `gender`=?, `city`=? WHERE `name` = ? ";
			int count = jdbcTemplete.update(update, user.getEmail(),user.getGender(),user.getCity(), user.getName());
			
			if(count>0) {
				status = true;
			}else {
				status = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
