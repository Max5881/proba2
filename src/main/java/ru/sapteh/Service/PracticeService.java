package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Passport;
import ru.sapteh.Model.Practice;

import java.util.List;

public class PracticeService implements DAO<Practice,Integer> {
    private final SessionFactory factory;

    public PracticeService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Practice practice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(practice);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Practice practice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(practice);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Practice practice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(practice);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Practice> readByAll() {
        try(Session session = factory.openSession()){
            Query<Practice> query = session.createQuery("FROM Practice");
            return query.list();
        }

    }

    @Override
    public Practice read(Integer integer) {
        try(Session session = factory.openSession()){
            Practice practice = session.get(Practice.class,integer);
            return practice;
        }
    }
}
