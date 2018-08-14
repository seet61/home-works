package com.sbt.javaschool.homeworks.springhibernate;

import com.sbt.javaschool.homeworks.springhibernate.config.AppConfig;
import com.sbt.javaschool.homeworks.springhibernate.dao.DishDAO;
import com.sbt.javaschool.homeworks.springhibernate.model.Dish;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DishDAO dishDAO = context.getBean(DishDAO.class);

        /*Dish dish = new Dish();
        dish.setName("Pankaj");
        dish.setIngredients("India");

        DishDAO.save(Dish);

        System.out.println("Dish::"+dish);
        */

        List<Dish> list = dishDAO.listDishes();

        for(Dish p : list){
            System.out.println("Dish List::"+p);
        }
        //close resources

        /*
        Scanner scanner = new Scanner(System.in);

        String line = "";
        String name = "";
        String ingredients = "";
        while (!"выход".equals(line) || !"quit".equals(line) || !"q".equals(line)) {
            System.out.print("Добавить|Найти|Удалить: ");
            line = scanner.nextLine();
            System.out.print("Название: ");
            name = scanner.nextLine();
            switch (line.trim()){
                case "Добавить":
                    System.out.print("Ингридиенты: ");
                    Dish item = new Dish();
                    item.setName(name);
                    item.setIngredients(scanner.nextLine());
                    dishDAO.create(item);
                    break;
                case "Найти":
                    Dish dish = dishDAO.searchDish(name);
                    System.out.println("Найдено: " + dish);
                    break;
                case "Удалить":
                    dishDAO.delete(name);
                    break;
                default:
                    List<Dish> dishes = dishDAO.listDishes();
                    dishes.stream().forEach(System.out::println);
                    break;
            }
        }
        */

        context.close();
    }
}
