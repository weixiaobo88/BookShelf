package linne;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

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

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOOKSHELF", "root", "");
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO book VALUES(?, ?, ?, ?)");

            pstmt.setInt(1, isbn);
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.setString(4, author);

            pstmt.executeUpdate();
            pstmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(isbn);
        System.out.println(name);
        System.out.println(price);
        System.out.println(author);

    }
}
