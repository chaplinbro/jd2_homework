package by.it_academy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/countservlet")
public class CountServletTask9 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            session.setAttribute("count", 1);
            count = 1;
        } else {
            session.setAttribute("count", count + 1);
        }

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Servlet count</title></head>");
        out.println("<body>");
        out.println("<h1>Count visits:</h1>" + "<h2>" + count + "<h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
