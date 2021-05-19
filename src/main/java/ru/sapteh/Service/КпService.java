package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Kp;

import java.util.List;

public class КпService implements DAO<Kp,Integer>{
    private final SessionFactory factory;

    public КпService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Kp kp) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(kp);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Kp kp) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(kp);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Kp kp) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(kp);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Kp> readByAll() {
        try(Session session = factory.openSession()){
            Query<Kp> query = session.createQuery("FROM Kp");
            return query.list();
        }

    }

    @Override
    public Kp read(Integer integer) {
        try(Session session = factory.openSession()){
            Kp kp = session.get(Kp.class,integer);
            return kp;
        }
    }
}
