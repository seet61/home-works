package com.sbt.javaschool.homeworks.springhibernate.dao;

import com.sbt.javaschool.homeworks.springhibernate.model.Dish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/***
 * Имплементация в DishDAO в формате Hibernate
 */
@Component
public class DishDAOImpl implements DishDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Dish dish) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(dish);
        tx.commit();
        session.close();
    }

    @Override
    public Dish searchDish(String rule) {
        return null;
    }

    @Override
    public List<Dish> listDishes() {
        Session session = this.sessionFactory.openSession();
        List<Dish> list = session.createQuery("from Dish").list();
        session.close();
        return list;
    }

    @Override
    public void delete(String name) {

    }
}
