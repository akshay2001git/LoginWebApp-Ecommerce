package com.ecommerce.dao;

import com.ecommerce.util.DBConnection;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;

public class UserDAO {
    public boolean register(String username, String email, String password) throws SQLException {
        String sql="INSERT INTO users(username,email,password_hash) VALUES(?,?,?)";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setString(1,username); p.setString(2,email);
            p.setString(3,BCrypt.hashpw(password,BCrypt.gensalt(12)));
            return p.executeUpdate()==1;
        }
    }
    public int authenticate(String username, String password) throws SQLException {
        String sql="SELECT id,password_hash FROM users WHERE username=?";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setString(1,username);
            try(ResultSet r=p.executeQuery()){
                if(r.next() && BCrypt.checkpw(password,r.getString("password_hash"))) return r.getInt("id");
            }
        }
        return -1;
    }
}
