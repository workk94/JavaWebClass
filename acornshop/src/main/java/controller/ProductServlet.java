package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ShopService;


@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		ShopService service = new ShopService();
		ArrayList<Product> productList = service.getAllproduct();
		
//		for(Product product : productList) {
//			System.out.println(product);
//		}
		
		req.setAttribute("productList", productList);
		req.getRequestDispatcher("WEB-INF/views/productlist.jsp").forward(req, resp);
	}
}
