package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.*;
/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	private ProductBase productBase = new ProductBase();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int barcode = Integer.parseInt(request.getParameter("barcode"));
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String description = request.getParameter("description");
		//Product product = new Product(barcode,name,color,description);
		Product product = new Product();
		product.setBarcode(barcode);
		product.setName(name); 
		product.setColor(color);
		product.setDescription(description);
		Product prodfound = new Product();
		
		int c = 1;
		c = productBase.saveProduct(product);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(c == 0) {
			
			out.println("A product with the Barcode  "+ barcode + "  is already registered. <br>This Product was not registered<br> Try another product");
		}
		else {
			out.println("Product with characteristics"+"<br>barcode = " + barcode +"<br>name =" + name +"<br>color ="
					+ color +"<br>description = " + description + "<br>has been registered");
		}	
	}
}
