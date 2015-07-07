package linne;

import db.DBConnection;
import db.DBOperate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<h1>" + "Book Shelf" + "</h1>");
        response.getWriter().println("<form action=\"add\" method=\"POST\">\n" +
                " ISBN: <input type=\"text\" name=\"isbn\">\n" +
                "  name: <input type=\"text\" name=\"name\">\n" +
                "  price: <input type=\"text\" name=\"price\">\n" +
                "  author: <input type=\"text\" name=\"author\">\n" +
                "  <input type=\"submit\" value=\"Submit form \"/>\n" +
                "  </form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int isbn = Integer.parseInt(request.getParameter("isbn"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String author = request.getParameter("author");
        DBOperate dbOperate = new DBOperate();

        try {
            dbOperate.addBook(isbn, name, price, author);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }

        System.out.println(isbn);
        System.out.println(name);
        System.out.println(price);
        System.out.println(author);
    }

}
