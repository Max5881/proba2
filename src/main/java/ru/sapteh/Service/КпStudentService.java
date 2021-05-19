package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.KpStudent;

import java.util.List;

public class КпStudentService implements DAO<KpStudent,Integer> {
    private final SessionFactory factory;

    public КпStudentService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(KpStudent kpStudent) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(kpStudent);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(KpStudent kpStudent) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(kpStudent);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(KpStudent kpStudent) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(kpStudent);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<KpStudent> readByAll() {
        try(Session session = factory.openSession()){
            Query<KpStudent> query = session.createQuery("FROM KpStudent");
            return query.list();
        }

    }

    @Override
    public KpStudent read(Integer integer) {
        try(Session session = factory.openSession()){
            KpStudent kpStudent = session.get(KpStudent.class,integer);
            return kpStudent;
        }
    }
}
