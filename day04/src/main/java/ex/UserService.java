package ex;

import java.util.ArrayList;

public class UserService {
	UserDAO dao = new UserDAO();
	
	public ArrayList<UserDTO> showUser() {
		return dao.selectAll();
	}
}
