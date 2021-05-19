package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Passport;

import java.util.List;

public class Пм implements DAO<Пм,Integer> {
    private final SessionFactory factory;

    public Пм(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(Пм пм) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(пм);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Пм пм) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(пм);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Пм пм) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(пм);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Пм> readByAll() {
        try(Session session = factory.openSession()){
            Query<Пм> query = session.createQuery("FROM Пм");
            return query.list();
        }

    }

    @Override
    public Пм read(Integer integer) {
        try(Session session = factory.openSession()){
            Пм пм = session.get(Пм.class,integer);
            return пм;
        }
    }
}
