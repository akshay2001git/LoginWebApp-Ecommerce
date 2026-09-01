package com.ecommerce.controller;

import com.ecommerce.dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        try { req.setAttribute("products",new ProductDAO().findAll()); req.getRequestDispatcher("products.jsp").forward(req,res); }
        catch(Exception e){throw new ServletException("Unable to load products",e);}
    }
}
