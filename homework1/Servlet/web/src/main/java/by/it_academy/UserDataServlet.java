package by.it_academy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userdata")
public class UserDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

//      Long phone = Long.parseLong( req.getParameter("phone"));
//      Если заходить через url /userdata выдает ошибку "java.lang.NumberFormatException: null" ,
//      но если заходить по url form.html ошибки не будет.
//      Сделал проверку на null, теперь можно заходить под любым url :)

        String phoneParam = req.getParameter("phone");
        Long phone = 0L;
        if (phoneParam != null) {
            try {
                phone = Long.parseLong(phoneParam);
            } catch (NumberFormatException e) {
            }
        }

        String email = req.getParameter("email");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<h2> Name:" + name + "</h2>");
        out.println("<h2> Phone:" + phone + "</h2>");
        out.println("<h2> Email:" + email + "</h2>");
        out.println("<a href='/web/form.html'>Back</a>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
