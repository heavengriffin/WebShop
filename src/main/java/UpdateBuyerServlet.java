import models.Buyer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/UpdateBuyerServlet", description = "update buyer")
public class UpdateBuyerServlet extends HttpServlet {

    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String selectedId = request.getParameter("buyer_id");

        int id = Integer.parseInt(selectedId);

        int index = 0;

        List<Buyer> buyers = Buyer.getAllBuyers();

        boolean exists = false;

        for (int i = 0; i < buyers.size(); i++) {
            if (id == buyers.get(i).getBuyerId()) {
                index = i;
                exists = true;
            }
        }

        if (exists) {
            out.println("<html><head><style>div{padding:5px; margin:5px;}</style></head><body>");
            out.println("<form action=\"UpdateBuyerServlet2\" method=\"post\">");
            out.println("<div>");
            out.println("<label>Buyer id: </label>");
            out.print("<input type=\"text\" name=\"buyerId\" value=\"" + buyers.get(index).getBuyerId() + "\" readonly=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Name: </label>");
            out.print("<input type=\"text\" name=\"name\" value=\"" + buyers.get(index).getName() + "\" required=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Surname: </label>");
            out.print("<input type=\"text\" name=\"surname\" value=\"" + buyers.get(index).getSurname() + "\" required=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Address: </label>");
            out.print("<input type=\"text\" name=\"address\" value=\"" + buyers.get(index).getAddress() + "\" required=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Telephone number: </label>");
            out.print("<input type=\"text\" name=\"telephoneNumber\" value=\"" + buyers.get(index).getTelephoneNumber() + "\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Username: </label>");
            out.print("<input type=\"text\" name=\"username\" value=\"" + buyers.get(index).getUsername() + "\" required=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Password: </label>");
            out.print("<input type=\"text\" name=\"password\" value=\"" + buyers.get(index).getPassword() + "\" required=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label>Number of products bought: </label>");
            out.print("<input type=\"text\" name=\"numberOfProductsBought\" value=\"" + buyers.get(index).getNumberOfProductsBought() + "\" required=\"true\"><br>");
            out.println("</div>");
            out.println("<div>");
            out.println("<input type=\"submit\" name=\"update\" value=\"Update\">");
            out.println("</div>");
            out.println("</form>");
            out.println("<br><br>");
            out.println("<a href='buyers.htm'>Back to Buyers</a>");
            out.println("<br><br>");
            out.println("<a href='admin.htm'>Back to main menu</a>");
            out.println("</body></html>");
        } else {
            out.println("<h3>The requested id does not exist.</h3>");
            out.println("<a href='buyers.htm'>Back to Buyers</a>");
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
