package ie.gmit.sw;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class DisplayHighScores
 */
@WebServlet("/DisplayHighScores")
public class DisplayHighScores extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<GameToDatabase> topTen = MongoDBUtil.getTopTen();
            request.setAttribute("topTen", topTen);
            System.out.println("Data displayed successfully");
        } catch (Throwable throwable) {
            request.setAttribute("connection_error", AttributeKeys.DATABASE_CONNECTION_ERROR);
            System.out.println("Data display failed");
            throwable.printStackTrace();
        }
        ServletContext ctx = getServletContext();
        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/highScores.jsp");
        dispatcher.forward(request, response);

    }
}
