package com.sbt.javaschool.homeworks.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class MainApp {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DishJDBCTemplate dishJDBCTemplate = (DishJDBCTemplate) context.getBean("dishJDBCTemplate");

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
                    ingredients = scanner.nextLine();
                    dishJDBCTemplate.create(name, ingredients);
                    break;
                case "Найти":
                    Dish dish = dishJDBCTemplate.searchDish(name);
                    System.out.println("Найдено: " + dish);
                    break;
                case "Удалить":
                    dishJDBCTemplate.delete(name);
                    break;
                default:
                    List<Dish> dishes = dishJDBCTemplate.listDishes();
                    dishes.stream().forEach(System.out::println);
                    break;
            }
        }
    }
}
