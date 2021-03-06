package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountServices;

/**
 *
 * @author 504785
 */
public class LoginServlet extends HttpServlet {

    //  String username;
    //String password;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        HttpSession session = request.getSession();
        
        if (request.getParameter("out") != null) {
//
            request.getSession().invalidate();
            request.setAttribute("out", "You have been logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else {
            if (session.getAttribute("user") != null) {

                response.sendRedirect("home");
                // getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
                return;
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }
            
            
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountServices acc = new AccountServices();
        User user = acc.login(username, password);
        if (user == null) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("out", "Invalid login");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect("home");

    }

}