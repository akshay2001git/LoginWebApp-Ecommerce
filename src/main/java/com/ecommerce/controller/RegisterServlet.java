package com.ecommerce.controller;

import com.ecommerce.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        String username=req.getParameter("username"), email=req.getParameter("email"), password=req.getParameter("password");
        try {
            new UserDAO().register(username,email,password);
            res.sendRedirect("login.jsp?registered=true");
        } catch(Exception e){ req.setAttribute("error","Registration failed. Username or email may already exist."); req.getRequestDispatcher("register.jsp").forward(req,res); }
    }
}
