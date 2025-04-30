package cart.controller;

import java.io.IOException;
import java.util.List;

import cart.model.dto.ProductDTO;
import cart.service.ProductService;
import cart.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product/order")
public class OrderServlet extends HttpServlet {
	
	private ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得所有商品
		List<ProductDTO> productDTOs = productService.findAllProducts();
		req.setAttribute("productDTOs", productDTOs);
		// 將商品重導到訂單頁面
		req.getRequestDispatcher("/WEB-INF/view/cart/product_order.jsp").forward(req, resp);
		
	}
	
}
