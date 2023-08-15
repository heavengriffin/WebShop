import models.Buyer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@WebServlet(urlPatterns = "/DeleteBuyerServlet", description = "delete buyer")
public class DeleteBuyerServlet extends HttpServlet {

    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLIntegrityConstraintViolationException, ClassNotFoundException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        Buyer buyer = new Buyer();

        String selectedId = request.getParameter("delete_buyer");

        int id = Integer.parseInt(selectedId);

        buyer.setBuyerId(id);

        List<Buyer> buyers = Buyer.getAllBuyers();

        int numberOfProductsBought = 0;

        boolean exists = false;

        for (Buyer b : buyers) {
            if (b.getBuyerId() == id) {
                numberOfProductsBought = b.getNumberOfProductsBought();
                exists = true;
            }
        }
        if (exists) {
            if (numberOfProductsBought == 0) {
                int deleted = buyer.delete();

                if (deleted == 1) {
                    out.println("<html><body>");
                    out.println("<h3>You deleted the product with id " + buyer.getBuyerId() + ".</h3>");
                    out.println("<a href=\"buyers.htm\">Back to Buyers</a>");
                    out.println("<br><br>");
                    out.println("<a href=\"admin.htm\">Back to main menu</a>");
                    out.println("</body></html>");
                } else {
                    out.println("<h3>Something went wrong. Please try again.</h3>");
                    out.println("<a href=\"buyers.htm\">Back to Buyers</a>");
                }
            } else {
                out.println("<html><body>");
                out.println("<h3>Deleting this buyer would erase all records. Are you sure you want to continue?</h3>");
                out.println("<form action='DeleteBuyerServlet2' method='post'>");
                out.println("<label>If yes, please confirm id to delete: </label>");
                out.println("<input type='text' name='id'>");
                out.println("<input type='submit' name='delete' value='Delete'>");
                out.println("</form>");
                out.println("<br><br>");
                out.println("<a href=\"buyers.htm\">Back to Buyers</a>");
                out.println("<br><br>");
                out.println("<a href=\"admin.htm\">Back to main menu</a>");
                out.println("</body></html>");
            }
        } else {
            out.println("<h3>The selected id does not exist.");
            out.println("<a href=\"buyers.htm\">Back to Buyers</a>");
            out.println("<br><br>");
            out.println("<a href=\"admin.htm\">Back to main menu</a>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (SQLIntegrityConstraintViolationException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (SQLIntegrityConstraintViolationException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo();
    }
}
