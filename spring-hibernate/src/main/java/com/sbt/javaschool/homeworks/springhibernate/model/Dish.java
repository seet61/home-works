package com.sbt.javaschool.homeworks.springhibernate.model;

import org.jboss.logging.Field;
import org.springframework.stereotype.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/***
 * Описание модели данных в формате Entity bean with JPA annotations
 */
@Entity
@Table(name="Dish")
@Indexed
public class Dish implements Serializable {
    @Id
    @Column(name="id")
    private Integer id;
    private String name;
    private String ingredients;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}
