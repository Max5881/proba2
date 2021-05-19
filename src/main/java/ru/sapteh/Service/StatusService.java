package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Passport;
import ru.sapteh.Model.Status;

import java.util.List;

public class StatusService implements DAO<Status,Integer> {
    private final SessionFactory factory;

    public StatusService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Status status) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(status);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Status status) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(status);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Status status) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(status);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Status> readByAll() {
        try(Session session = factory.openSession()){
            Query<Status> query = session.createQuery("FROM Status");
            return query.list();
        }

    }

    @Override
    public Status read(Integer integer) {
        try(Session session = factory.openSession()){
            Status status = session.get(Status.class,integer);
            return status;
        }
    }
}
