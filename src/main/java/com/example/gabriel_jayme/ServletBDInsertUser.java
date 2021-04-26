package com.example.gabriel_jayme;

import com.example.gabriel_jayme.repository.UsersDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletBDInsertUser", value = "/ServletBDInsertUser")
public class ServletBDInsertUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        UsersDAO dao = new UsersDAO();
        dao.inserirEnderecos(nome,senha);

        request.getSession().setAttribute("lista",dao.listarUsuarios());

        response.sendRedirect("dashboard.jsp");
//        RequestDispatcher dispatcher =
//                request.getRequestDispatcher("dashboard.jsp");
//        dispatcher.forward(request,response);

    }
}
