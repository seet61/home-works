package com.sbt.javaschool.homeworks.springjdbc;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishMapper implements RowMapper<Dish> {
    public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dish dish = new Dish();
        dish.setId(rs.getInt("id"));
        dish.setName(rs.getString("name"));
        dish.setIngredients(rs.getString("ingredients"));
        return dish;
    }
}
