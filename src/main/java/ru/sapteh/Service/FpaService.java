package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.DisciplineCurriculum;
import ru.sapteh.Model.Fpa;

import java.util.List;

public class FpaService implements DAO<Fpa,Integer> {
    private final SessionFactory factory;

    public FpaService(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(Fpa fpa) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(fpa);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Fpa fpa) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(fpa);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Fpa fpa) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(fpa);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Fpa> readByAll() {
        try(Session session = factory.openSession()){
            Query<Fpa> query = session.createQuery("FROM Fpa");
            return query.list();
        }

    }

    @Override
    public Fpa read(Integer integer) {
        try(Session session = factory.openSession()){
            Fpa fpa = session.get(Fpa.class,integer);
            return fpa;
        }
    }
}
