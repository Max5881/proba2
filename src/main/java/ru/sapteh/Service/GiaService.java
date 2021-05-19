package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Gia;

import java.util.List;

public class GiaService implements DAO<Gia,Integer> {
    private final SessionFactory factory;

    public GiaService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Gia gia) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(gia);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Gia gia) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(gia);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Gia gia) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(gia);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Gia> readByAll() {
        try(Session session = factory.openSession()){
            Query<Gia> query = session.createQuery("FROM Gia");
            return query.list();
        }

    }

    @Override
    public Gia read(Integer integer) {
        try(Session session = factory.openSession()){
            Gia gia = session.get(Gia.class,integer);
            return gia;
        }
    }
}
