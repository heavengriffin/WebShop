import models.Buyer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/UpdateBuyerServlet2", description = "confirm update buyer")
public class UpdateBuyerServlet2 extends HttpServlet {

    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        Buyer buyer = new Buyer();

        boolean exception = false;

        buyer.setBuyerId(Integer.parseInt(request.getParameter("buyerId")));
        buyer.setName(request.getParameter("name"));
        buyer.setSurname(request.getParameter("surname"));
        buyer.setAddress(request.getParameter("address"));
        buyer.setTelephoneNumber(request.getParameter("telephoneNumber"));
        buyer.setUsername(request.getParameter("username"));
        buyer.setPassword(request.getParameter("password"));
        try {
            buyer.setNumberOfProductsBought(Integer.parseInt(request.getParameter("numberOfProductsBought")));
        } catch (NumberFormatException exc) {
            out.println("<h3>Number of products bought must be a number.</h3>");
            out.println("<a href=\"buyers.htm\">Back to Buyers</a>");
            out.println("<br><br>");
            out.println("<a href=\"admin.htm\">Back to main menu</a>");
            exception = true;
        }
        if (!exception) {
            try {
                int updated = buyer.updateBuyerByAdmin();
                if (updated == 1) {
                    out.println("<html><body>");
                    out.println("<h3>You have successfully updated the buyer with id " + buyer.getBuyerId() + ".</h3>");
                    out.println("<a href=\"buyers.htm\">Back to Buyers</a>");
                    out.println("<br><br>");
                    out.println("<a href=\"admin.htm\">Back to main menu</a>");
                    out.println("</body></html>");
                } else {
                    out.println("<h3>Something went wrong. Please try again</h3>");
                    out.println("<a href=\"buyers.htm\">Back to Buyers</a>");
                }
            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo();
    }
}
