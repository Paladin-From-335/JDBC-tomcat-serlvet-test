package com.github.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomRowMapper<T> {
    T rowMap(ResultSet resultSet) throws SQLException;
}
