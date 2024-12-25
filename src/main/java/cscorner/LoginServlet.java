package cscorner;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Ghitaatt@123");
            
            String n = request.getParameter("TXTName");
            String p = request.getParameter("password");

            PreparedStatement ps = con.prepareStatement("SELECT uname FROM users WHERE uname = ? AND password = ?");
            ps.setString(1, n);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("User authenticated!");
                RequestDispatcher rd = request.getRequestDispatcher("welcom.jsp");
                rd.forward(request, response);
            } else {
                out.println("<font color=red>Login failed! Check username or password.</font>");
                out.println("<a href='login.jsp'>Try again</a>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<font color='red'>Driver Error: " + e.getMessage() + "</font>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<font color='red'>Database Error: " + e.getMessage() + "</font>");
        }
    }
}
