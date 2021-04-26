package com.example.gabriel_jayme;

import com.example.gabriel_jayme.repository.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletBDLoginUser", value = "/ServletBDLoginUser")
public class ServletBDLoginUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String senha = request.getParameter("senha");
            UsersDAO dao = new UsersDAO();
            if (dao.getUser(senha).getName() == null) {
                response.sendRedirect("./index.html");
            }

            response.sendRedirect("./dashboard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
