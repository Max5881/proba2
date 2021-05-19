package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Gia;
import ru.sapteh.Model.Passport;

import java.util.List;

public class PassportService implements DAO<Passport,Integer> {
    private final SessionFactory factory;

    public PassportService(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(Passport passport) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(passport);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Passport passport) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(passport);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Passport passport) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(passport);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Passport> readByAll() {
        try(Session session = factory.openSession()){
            Query<Passport> query = session.createQuery("FROM Passport");
            return query.list();
        }

    }

    @Override
    public Passport read(Integer integer) {
        try(Session session = factory.openSession()){
            Passport passport = session.get(Passport.class,integer);
            return passport;
        }
    }
}
