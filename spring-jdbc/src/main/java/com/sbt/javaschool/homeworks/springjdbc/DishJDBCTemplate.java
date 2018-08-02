package com.sbt.javaschool.homeworks.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DishJDBCTemplate implements DishDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public void create(String name, String ingredients) {
        String SQL = "insert into Dish(name, ingredients) values(?, ?)";
        jdbcTemplate.update(SQL, name, ingredients);
        System.out.println("Created record name = " + name + " ingredients = " + ingredients);
    }

    @Override
    public Dish searchDish(String rule) {
        String SQL = "select * from Dish where name like ?";
        Dish dish = jdbcTemplate.queryForObject(SQL, new DishMapper(), "%"+rule+"%");
        return dish;
    }

    @Override
    public List<Dish> listDishes() {
        String SQL = "select * from Dish";
        List<Dish> dishes = jdbcTemplate.query(SQL, new DishMapper());
        return dishes;
    }

    @Override
    public void delete(String name) {
        String SQL = "delete from Dish where name = ?";
        jdbcTemplate.update(SQL, name);
        System.out.println("Deleted Record with name = " + name);
    }
}
