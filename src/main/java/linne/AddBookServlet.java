package linne;

import org.apache.commons.dbcp.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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


        Connection conn = null;
        PreparedStatement stmt = null;

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/BOOKSHELF");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("INSERT INTO book VALUES(?, ?, ?, ?)");
            stmt.setInt(1, isbn);
            stmt.setString(2, name);
            stmt.setDouble(3, price);
            stmt.setString(4, author);

            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println(isbn);
        System.out.println(name);
        System.out.println(price);
        System.out.println(author);

    }
}
