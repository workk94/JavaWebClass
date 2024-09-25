package model;

import java.util.ArrayList;

public class UserService {
	UserDAO dao = new UserDAO();
	
	//모든 회원정보
	public ArrayList<User> getAllMember(){
		return dao.selectAll();
	}
	
	//회원 정보(id)
	public User getMember(String id) { 
		return dao.selectOne(id);
	}
	
	//회원 등록
	public int registerMember(User user) {
		int rtn = dao.insert(user);
		return rtn;
	}	
	
	
}
