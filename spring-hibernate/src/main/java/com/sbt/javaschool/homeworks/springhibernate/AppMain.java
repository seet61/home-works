package com.sbt.javaschool.homeworks.springhibernate;

import com.sbt.javaschool.homeworks.springhibernate.config.AppConfig;
import com.sbt.javaschool.homeworks.springhibernate.dao.DishDAO;
import com.sbt.javaschool.homeworks.springhibernate.model.Dish;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DishDAO dishDAO = context.getBean(DishDAO.class);

        /*Dish dish = new Dish();
        dish.setName("Окрошка");
        dish.setIngredients("Огурцы,Картофель,Квас,Колбаса,Яйца,Зелень");

        dishDAO.create(dish);

        System.out.println(dish);*/

        List<Dish> list = dishDAO.listDishes();
        for(Dish d: list) {
            System.out.println("Dish: " + d);
        }

        context.close();
    }
}
