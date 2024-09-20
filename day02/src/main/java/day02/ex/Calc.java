package day02.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String _num1 = req.getParameter("num1");
		String _num2 = req.getParameter("num2");
		String op = req.getParameter("op");

		PrintWriter out = resp.getWriter();

		if (op == null) {
			out.println("op is null");
		} else {
			if (_num1 == null || _num2 == null) {
				out.println("num is null");
			} else {
				double result;
				try {
					int num1 = Integer.parseInt(_num1);
					int num2 = Integer.parseInt(_num2);
					switch (op) {
					case "add":
						result =addNum(num1, num2);
						out.print(result);
						break;
					case "sub":
						result = subNum(num1, num2);
						out.print(result);
						break;
					case "mul":
						result = mulNum(num1, num2);
						out.print(result);
						break;
					case "div":
						result = divNum(num1, num2);
						out.println(result);
						break;
					default: out.println("Invalid input");
					}
				} catch (NumberFormatException e) {
					out.println(e.toString());
				} catch (ArithmeticException e) {
					out.println(e.toString());
				}
				
			}
			
		}

	}

	public int addNum(int x, int y) {
		return x + y;
	}

	public int subNum(int x, int y) {
		return x - y;
	}

	public int mulNum(int x, int y) {
		return x * y;
	}

	public double divNum(int x, int y) {
		return x / (double) y;
	}
}
