package by.it_academy;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


@WebServlet("/countservletimage")
public class CountServletTask12 extends HttpServlet {

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

        resp.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        ServletOutputStream output = resp.getOutputStream();

        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("serif", Font.ITALIC, 48));
        graphics.setColor(Color.green);
        graphics.drawString("Count visits:" + count, 100, 100);
        ImageIO.write(image, "jpeg", output);
    }
}
