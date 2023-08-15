import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/UpdateProductServlet", description = "product_id placeholder")
public class UpdateProductServlet extends HttpServlet {

    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

            String selectedId = request.getParameter("product_id");

            int id = Integer.parseInt(selectedId);

        List<Product> products = Product.getAll();

        int index = 0;

        boolean exists = false;

        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getProductId()) {
                index = i;
                exists = true;
            }
        }

        if (exists) {
            out.println("<html><head><style>div{padding:5px; margin:5px;}</style></head><body>");
            out.println("<form action=\"UpdateProductServlet2\" method=\"post\">");
            out.println("<div>");
            out.println("<label>Product Id: <label>");
            out.println("<input type=\"text\" name=\"productId\" value=\"" + products.get(index).getProductId() + "\" readonly=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Name: <label>");
            out.println("<input type=\"text\" name=\"name\" value=\"" + products.get(index).getName() + "\" required=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Category: <label>");
            out.println("<input type=\"text\" name=\"category\" value=\"" + products.get(index).getCategory() + "\" required=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Quantity in stock: <label>");
            out.println("<input type=\"text\" name=\"quantityInStock\" value=\"" + products.get(index).getQuantityInStock() + "\" required=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Price: <label>");
            out.println("<input type=\"text\" name=\"price\" value=\"" + products.get(index).getPrice() + "\" required=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<input type=\"submit\" value=\"Update\">");
            out.println("</div>");
            out.println("</form>");
            out.println("<br><br>");
            out.println("<a href='products.htm'>Back to Products</a>");
            out.println("<br><br>");
            out.println("<a href='admin.htm'>Back to main menu</a>");
            out.println("</body></html>");
        } else {
            out.println("<h3>The requested id does not exist.</h3>");
            out.println("<a href='products.htm'>Back to Products</a>");
            out.println("<br><br>");
            out.println("<a href='admin.htm'>Back to main menu</a>");
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
