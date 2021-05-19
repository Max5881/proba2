package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Grup;

import java.util.List;

public class GroupService implements DAO<Grup,Integer> {
    private final SessionFactory factory;

    public GroupService(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(Grup grup) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(grup);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Grup grup) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(grup);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Grup grup) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(grup);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Grup> readByAll() {
        try(Session session = factory.openSession()){
            Query<Grup> query = session.createQuery("FROM Group");
            return query.list();
        }

    }

    @Override
    public Grup read(Integer integer) {
        try(Session session = factory.openSession()){
            Grup grup = session.get(Grup.class,integer);
            return grup;
        }
    }
}
