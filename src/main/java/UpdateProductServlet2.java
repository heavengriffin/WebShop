import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/UpdateProductServlet2", description = "update product")
public class UpdateProductServlet2 extends HttpServlet {

    public void process(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        Product product = new Product();

        boolean exception = false;

        product.setProductId(Integer.parseInt(request.getParameter("productId")));
        product.setName(request.getParameter("name"));
        product.setCategory(request.getParameter("category"));
        try {
            product.setQuantityInStock(Integer.parseInt(request.getParameter("quantityInStock")));
            product.setPrice(Integer.parseInt(request.getParameter("price")));
        } catch (NumberFormatException exc) {
            out.println("<h3>Quantity in stock and Price must be numbers.</h3>");
            out.println("<a href='products.htm'>Back to Products</a>");
            out.println("<br><br>");
            out.println("<a href='admin.htm'>Back to main menu</a>");
            exception = true;
        }
        if (!exception) {
            int updated = product.updateProduct();

            if (updated == 1) {
                out.println("<html><body>");
                out.println("<h3>You have successfully updated the product with id " + product.getProductId() + ".</h3>");
                out.println("<a href='products.htm'>Back to Products</a>");
                out.println("<br><br>");
                out.println("<a href='admin.htm'>Back to main menu</a>");
                out.println("</body></html>");
            } else {
                out.println("<h3>Something went wrong. Please try again.</h3>");
                out.println("<a href='products.htm'>Back to Products</a>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo();
    }
}
