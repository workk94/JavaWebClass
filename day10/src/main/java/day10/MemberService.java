package day10;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	public Member getMemberById(String id) {
		return dao.findMember(id);
	}
	
	public boolean verifyLogin(String id, String password) {
		Member member = dao.findByMemberIdAndPassword(id, password);
		return member != null;
	}
}
