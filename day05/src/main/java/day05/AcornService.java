package day05;

import java.util.ArrayList;

// DAO는 sql, Service는 비즈니스
public class AcornService {
	DBDAO2 dao = new DBDAO2();
	
	int registerMember(Acorn acorn) {
		int rtn = dao.insert(acorn);
		return rtn;
	}
	
	ArrayList<Acorn> getMemberList(){
		return dao.selectAll();
	}
	
	Acorn getMember(String id) {
		return dao.selectOne(id);
	}
	
	int modifyMember(Acorn acorn) {
		return dao.update(acorn);
	}
	
	int deleteMember(String id) {
		return dao.delete(id);
	}
}


