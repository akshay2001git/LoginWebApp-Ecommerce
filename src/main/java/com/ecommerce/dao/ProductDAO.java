package com.ecommerce.dao;

import com.ecommerce.model.Product;
import com.ecommerce.util.DBConnection;
import java.sql.*;
import java.util.*;

public class ProductDAO {
    public List<Product> findAll() throws SQLException {
        List<Product> list=new ArrayList<>();
        String sql="SELECT * FROM products ORDER BY id DESC";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql); ResultSet r=p.executeQuery()){
            while(r.next()) list.add(map(r));
        }
        return list;
    }
    public Product findById(int id) throws SQLException {
        String sql="SELECT * FROM products WHERE id=?";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setInt(1,id);
            try(ResultSet r=p.executeQuery()){ if(r.next()) return map(r); }
        }
        return null;
    }
    private Product map(ResultSet r)throws SQLException{
        return new Product(r.getInt("id"),r.getString("name"),r.getString("description"),
            r.getBigDecimal("price"),r.getString("image_url"),r.getString("category"),r.getInt("stock"));
    }
}
