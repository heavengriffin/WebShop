import models.Product;
import models.Sale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet(urlPatterns = "/DeleteProductServlet2", description = "delete product")
public class DeleteProductServlet2 extends HttpServlet {

    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLIntegrityConstraintViolationException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        Product product = new Product();

        Sale sale = new Sale();

        product.setProductId(id);

        sale.setProductId(id);

        sale.deleteByProduct();

        int deleted = product.delete();

        out.println("<html><body>");
        out.println("<h3>Deleted</h3>");
        out.println("<a href='products.htm'>Back to Products</a>");
        out.println("<br><br>");
        out.println("<a href='admin.htm'>Back to main menu</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (ClassNotFoundException | SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (ClassNotFoundException | SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo();
    }
}
