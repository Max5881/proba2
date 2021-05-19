package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Discipline;

import java.util.List;

public class DisciplineService implements DAO<Discipline,Integer> {
    private final SessionFactory factory;

    public DisciplineService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Discipline discipline) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(discipline);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Discipline discipline) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(discipline);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Discipline discipline) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(discipline);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Discipline> readByAll() {
        try(Session session = factory.openSession()){
            Query<Discipline> query = session.createQuery("FROM Discipline");
            return query.list();
        }

    }

    @Override
    public Discipline read(Integer integer) {
        try(Session session = factory.openSession()){
            Discipline discipline = session.get(Discipline.class,integer);
            return discipline;
        }
    }
}
