package com.arj.search.dao.impl;

import com.arj.search.dao.UserDAO;
import com.arj.search.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM tbl_users";
        return jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setUserName(rs.getString("user_name"));
                u.setStatus(rs.getBoolean("status"));
                return u;
            }
        });
    }

    @Override
    public List<User> search(String searchParam) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM tbl_users WHERE user_name LIKE ?";
        
        return jdbcTemplate.query(sql,new Object[]{"%"+searchParam+"%"} , new RowMapper<User>() {
 
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setUserName(rs.getString("user_name"));
                u.setStatus(rs.getBoolean("status"));
                return u;
            }
        });
    }
    
}
