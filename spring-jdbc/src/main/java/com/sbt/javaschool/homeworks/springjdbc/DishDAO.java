package com.sbt.javaschool.homeworks.springjdbc;

import javax.sql.DataSource;
import java.util.List;

public interface DishDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the Dish table.
     */
    public void create(String name, String ingredients);

    /**
     * This is the method to be used to list down
     * a record from the Dish table corresponding
     * to a passed rule.
     */
    public Dish searchDish(String rule);

    /**
     * This is the method to be used to list down
     * all the records from the Dish table.
     */
    public List<Dish> listDishes();

    /**
     * This is the method to be used to delete
     * a record from the Dish table corresponding
     * to a passed student id.
     */
    public void delete(String name);
}
