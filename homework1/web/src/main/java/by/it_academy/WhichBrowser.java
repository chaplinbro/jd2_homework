package by.it_academy;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/browser")
public class WhichBrowser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Костыль, но работает..
        String info = req.getHeader("User-Agent");
        String browser = null;

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        if (info.contains("OPR")) {
            browser = "Opera";
        } else if (info.contains("Edg")) {
            browser = "Edge";
        } else if (info.contains("Firefox")) {
            browser = "Firefox";
        } else if (info.contains("Safari")) {
            browser = "Chrome";
        } else {
            browser = "неизвестного системе браузера :)";
        }

        out.println("<html><body>");
        out.println("<h3>Приветствую пользователя " + browser + "</h3>");
        out.println("</body></html>");

//     Попытка №2 решить задачу - провал. вывод всегда "Chrome"
//        UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
//        Browser browser = userAgent.getBrowser();
//        String browserName = browser.getGroup().getName();
//
//        PrintWriter out = resp.getWriter();
//        out.println(browserName);
    }
}
