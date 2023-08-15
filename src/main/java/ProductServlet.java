import models.Buyer;
import models.Product;
import models.Sale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/ProductServlet", description = "for products")
public class ProductServlet extends HttpServlet {

    void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String quantity = request.getParameter("quantity");

        Sale sale = new Sale();

        int customerId = 0;

        Buyer customer = new Buyer();

        List<Buyer> buyers = Buyer.getAllBuyers();

        for (Buyer b : buyers) {
            if (customer.getCurrentBuyer().equals(b.getUsername()))
                customerId = b.getBuyerId();
        }

        Product product = new Product();

        List<Product> products = Product.getAll();

        for (Product p : products) {

            if (request.getParameter("bought") != null && request.getParameter("bought").equals(p.getName())) {

                product.setId(p.getProductId());

                product.setQuantity(quantity);

                int askedQuantity = Integer.parseInt(quantity);

                if (askedQuantity > p.getQuantityInStock()) {

                    out.println("<html><body>");
                    out.println("<h2>Item out of stock</h2>");
                    out.println("<a href='sales.htm'>Back to main page</a>");
                    out.println("<br>");
                    out.println("<a href='login.htm'>Log out</a>");
                    out.println("</body></html>");
                } else {

                    int state = p.getItemsSold();

                    state++;

                    p.setItemsSold(state);

                    product.updateItemSold();

                    product.updateQuantity();

                    Buyer buyer = new Buyer();

                    buyer.setQuantity(quantity);

                    Buyer.updateBuyer();

                    sale.setProductId(p.getProductId());

                    sale.setBuyerId(customerId);

                    sale.setQuantity(Integer.parseInt(quantity));

                    sale.insert();

                    out.println("<html><body>");
                    out.println("<h2>You just bought " + quantity + "x " + request.getParameter("bought") + ".</h2>");
                    out.println("<a href='sales.htm'>Back to main page</a>");
                    out.println("<br>");
                    out.println("<a href='login.htm'>Log out</a>");
                    out.println("</body></html>");
                }
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

