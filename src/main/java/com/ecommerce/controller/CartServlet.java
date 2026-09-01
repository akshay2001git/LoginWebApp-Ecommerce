package com.ecommerce.controller;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        try{
            int id=Integer.parseInt(req.getParameter("productId"));
            Product p=new ProductDAO().findById(id);
            if(p!=null){
                HttpSession s=req.getSession();
                Map<Integer,Integer> cart=(Map<Integer,Integer>)s.getAttribute("cart");
                if(cart==null){cart=new LinkedHashMap<>();s.setAttribute("cart",cart);}
                cart.put(id,cart.getOrDefault(id,0)+1);
            }
            res.sendRedirect("cart.jsp");
        }catch(Exception e){throw new ServletException("Cart update failed",e);}
    }
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException{
        res.sendRedirect("cart.jsp");
    }
}
