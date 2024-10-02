package day11;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list")
public class ListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Model
		//게시판 글 목록
		//페이징 관련 객체
		
		int pageSize = 3;
		int grpSize = 5;
		int totRecords = 0;
		int currentPage = 1;
		
		AcornDAO dao = new AcornDAO();
		totRecords = dao.selectTotalCnt();
		
		String p_ = req.getParameter("p");
		if(p_ != null) {
			currentPage = Integer.parseInt(p_);
		}
		
		ArrayList<Acorn> list = dao.selectListPaging(currentPage, pageSize);
		
		PageHandler pageHandler = new PageHandler(pageSize, grpSize, totRecords, currentPage);
		
		req.setAttribute("list", list);
		req.setAttribute("handler", pageHandler);
		
		
		req.getRequestDispatcher("WEB-INF/views/list.jsp").forward(req, resp);
	}
}
