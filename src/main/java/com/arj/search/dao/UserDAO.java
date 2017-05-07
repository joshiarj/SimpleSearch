package com.arj.search.dao;

import com.arj.search.entity.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> getAll() throws SQLException, ClassNotFoundException;
    List<User> search(String searchParam) throws SQLException, ClassNotFoundException;
}
