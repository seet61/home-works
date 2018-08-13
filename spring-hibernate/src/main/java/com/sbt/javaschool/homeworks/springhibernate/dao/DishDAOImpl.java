package com.sbt.javaschool.homeworks.springhibernate.dao;

import com.sbt.javaschool.homeworks.springhibernate.model.Dish;
import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
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
    @Transactional
    public void create(Dish dish) {
        Session session = this.sessionFactory.openSession();
        session.save(dish);
        session.close();
    }

    @Override
    @Transactional
    public List<Dish> searchDish(String rule) {
        Session session = this.sessionFactory.openSession();
        FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(session);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Dish.class)
                .get();
        Query keywordQuery = queryBuilder
                .keyword()
                .onField("name")
                .matching(rule)
                .createQuery();
        org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(keywordQuery, Dish.class);
        List<Dish> list = jpaQuery.getResultList();
        session.close();
        return list;
    }

    @Override
    @Transactional
    public List<Dish> listDishes() {
        Session session = this.sessionFactory.openSession();
        List<Dish> list = session.createQuery("from Dish").list();
        session.close();
        return list;
    }

    @Override
    @Transactional
    public void delete(String name) {

    }
}
