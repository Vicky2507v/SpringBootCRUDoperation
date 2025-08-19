package in.vicky.main.userdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.vicky.main.entity.User;

@Repository
public class UserDao {

	@Autowired
	public JdbcTemplate jdbctemplete;
	
	public boolean deleteUser(User user) {
		boolean status = false;
		try {
			String delete = "DELETE FROM `users` WHERE `name` = ?";
			int count = jdbctemplete.update(delete, user.getName());
			
			if(count>0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
