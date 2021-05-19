package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Mdk;

import java.util.List;

public class МдкService implements DAO<Mdk,Integer> {
    private final SessionFactory factory;

    public МдкService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Mdk mdk) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(mdk);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Mdk mdk) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(mdk);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Mdk mdk) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(mdk);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Mdk> readByAll() {
        try(Session session = factory.openSession()){
            Query<Mdk> query = session.createQuery("FROM Мдк");
            return query.list();
        }

    }

    @Override
    public Mdk read(Integer integer) {
        try(Session session = factory.openSession()){
            Mdk mdk = session.get(Mdk.class,integer);
            return mdk;
        }
    }
}
