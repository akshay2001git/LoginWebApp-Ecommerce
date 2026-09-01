package com.ecommerce.controller;

import com.ecommerce.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        String username=req.getParameter("userName"), password=req.getParameter("password");
        try {
            int id=new UserDAO().authenticate(username,password);
            if(id>0){ req.getSession().setAttribute("userId",id); req.getSession().setAttribute("username",username); res.sendRedirect("products.jsp"); }
            else { req.setAttribute("error","Invalid username or password."); req.getRequestDispatcher("login.jsp").forward(req,res); }
        } catch(Exception e){ throw new ServletException("Login failed",e); }
    }
}
