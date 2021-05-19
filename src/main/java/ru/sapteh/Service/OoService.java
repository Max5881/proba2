package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Gia;
import ru.sapteh.Model.Oo;

import java.util.List;

public class OoService implements DAO<Oo,Integer> {
    private final SessionFactory factory;

    public OoService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Oo oo) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(oo);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Oo oo) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(oo);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Oo oo) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(oo);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Oo> readByAll() {
        try(Session session = factory.openSession()){
            Query<Oo> query = session.createQuery("FROM Oo");
            return query.list();
        }

    }

    @Override
    public Oo read(Integer integer) {
        try(Session session = factory.openSession()){
            Oo oo = session.get(Oo.class,integer);
            return oo;
        }
    }
}
