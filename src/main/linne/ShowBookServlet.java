package linne;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        ArrayList<Book> books = new ArrayList<Book>();

        response.getWriter().println("2222222222222");
        response.getWriter().println("<h1>" + "Book Shelf" + "</h1>");
//        try {
//            DBOperate dbOperate = new DBOperate();
//            ResultSet rs = dbOperate.showBooks();
//
//
//            response.getWriter().println("------------------");
//
//            while (rs.next()) {
//                int isbn = rs.getInt("isbn");
//                String name = rs.getString("name");
//                double price = rs.getDouble("price");
//                String author = rs.getString("author");
////                response.getWriter().println("The " + rs.getRow() + " book: ");
////                response.getWriter().println("isbn is " + isbn);
////                response.getWriter().println("name is " + name);
////                response.getWriter().println("price is " + price);
////                response.getWriter().println("author is " + author);
////                response.getWriter().println("~~~~~~~~~~~~~~~~~");
////                response.getWriter().println();
//
//                Book book = new Book();
//                book.setIsbn(isbn);
//                book.setName(name);
//                book.setPrice(price);
//                book.setAuthor(author);
//                books.add(book);
//            }
//
////            request.setAttribute("books", books);
////            request.getRequestDispatcher("/show.jsp").forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    //条件查询跳转      public void dispatch(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException{      String id5=request.getParameter("id");      String name5=request.getParameter("name");        if(select(id5,name5).isEmpty()){          request.getRequestDispatcher("selectnothing.jsp").forward(request, response);         }        else{       request.setAttribute("result", select(id5,name5));              request.getRequestDispatcher("idnameselect.jsp").forward(request, response);          }     }
}
