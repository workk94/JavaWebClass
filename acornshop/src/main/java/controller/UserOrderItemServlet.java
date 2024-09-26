package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderItem;
import model.ShopService;

@WebServlet("/orders")
public class UserOrderItemServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = (String)req.getSession().getAttribute("id");
		
		ShopService service = new ShopService();
		ArrayList<OrderItem> list = service.getUserOrder(id);
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("WEB-INF/views/orderItemList.jsp").forward(req, resp);
		
	}

}
