package com.sbt.javaschool.homeworks.springjdbc;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishMapper implements RowMapper<Dish> {
    public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dish student = new Dish();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setIngredients(rs.getString("ingredients"));
        return student;
    }
}
