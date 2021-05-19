package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Diplom;

import java.util.List;

public class DiplomService implements DAO<Diplom,Integer> {
    private final SessionFactory factory;

    public DiplomService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Diplom diplom) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(diplom);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Diplom diplom) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(diplom);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Diplom diplom) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(diplom);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Diplom> readByAll() {
        try(Session session = factory.openSession()){
            Query<Diplom> query = session.createQuery("FROM Diplom");
            return query.list();
        }

    }

    @Override
    public Diplom read(Integer integer) {
        try(Session session = factory.openSession()){
            Diplom diplom = session.get(Diplom.class,integer);
            return diplom;
        }
    }
}
