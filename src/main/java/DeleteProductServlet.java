import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@WebServlet(urlPatterns = "/DeleteProductServlet", description = "delete product")
public class DeleteProductServlet extends HttpServlet {

    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLIntegrityConstraintViolationException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String selectedId = request.getParameter("delete_product");

        int id = Integer.parseInt(selectedId);

        Product product = new Product();

        List<Product> products = Product.getAll();

        boolean exists = false;

        for (Product p : products) {
            if (id == p.getProductId()) {
                exists = true;
                break;
            }
        }

        if (exists) {
            product.setProductId(id);

            if (product.getItemsSold() == 0) {
                int deleted = product.delete();
                if (deleted == 1) {
                    out.println("<html><body>");
                    out.println("<h3>You deleted the product with id " + product.getProductId() + "</h3>");
                    out.println("<a href=\"products.htm\">Back to Products</a>");
                    out.println("<br><br>");
                    out.println("<a href=\"admin.htm\">Back to main menu</a>");
                    out.println("</body></html>");
                } else {
                    out.println("<h3>Something went wrong. Please try again.</h3>");
                    out.println("<a href=\"products.htm\">Back to Products</a>");
                }
            } else {
                out.println("<html><body>");
                out.println("<h3>Deleting this product would erase all records. Are you sure you want to continue?</h3>");
                out.println("<form action='DeleteProductServlet2' method='post'>");
                out.println("<label>If yes, please confirm id to delete: </label>");
                out.println("<input type='text' name='id'>");
                out.println("<input type='submit' name='delete' value='Delete'>");
                out.println("</form>");
                out.println("<br><br>");
                out.println("<a href=\"products.htm\">Back to Products</a>");
                out.println("<br><br>");
                out.println("<a href=\"admin.htm\">Back to main menu</a>");
                out.println("</body></html>");
            }
        } else {
            out.println("<h3>The requested id does not exist.</h3>");
            out.println("<a href=\"products.htm\">Back to Products</a>");
            out.println("<br><br>");
            out.println("<a href=\"admin.htm\">Back to main menu</a>");
        }
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
