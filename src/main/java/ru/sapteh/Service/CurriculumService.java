package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Curriculum;

import java.util.List;

public class CurriculumService implements DAO<Curriculum,Integer> {
    private final SessionFactory factory;

    public CurriculumService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Curriculum curriculum) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(curriculum);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Curriculum curriculum) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(curriculum);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Curriculum curriculum) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(curriculum);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Curriculum> readByAll() {
        try(Session session = factory.openSession()){
            Query<Curriculum> query = session.createQuery("FROM Curriculum");
            return query.list();
        }
    }

    @Override
    public Curriculum read(Integer integer) {
        try(Session session = factory.openSession()){
            Curriculum curriculum = session.get(Curriculum.class,integer);
            return curriculum;
        }
    }
}
