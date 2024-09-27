package loginProj;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();
	
	public Member getMember(String id) {
		return dao.selectMember(id);
	}
	
	public boolean verifyMember(String id, String pw) {
		return dao.isUserExist(id, pw);
	}
}
