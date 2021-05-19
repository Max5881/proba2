package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Passport;
import ru.sapteh.Model.StudentDiscipline;

import java.util.List;

public class StudentDisciplineService implements DAO<StudentDiscipline,Integer> {
    private final SessionFactory factory;

    public StudentDisciplineService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(StudentDiscipline studentDiscipline) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(studentDiscipline);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(StudentDiscipline studentDiscipline) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(studentDiscipline);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(StudentDiscipline studentDiscipline) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(studentDiscipline);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<StudentDiscipline> readByAll() {
        try(Session session = factory.openSession()){
            Query<StudentDiscipline> query = session.createQuery("FROM StudentDiscipline");
            return query.list();
        }

    }

    @Override
    public StudentDiscipline read(Integer integer) {
        try(Session session = factory.openSession()){
            StudentDiscipline studentDiscipline = session.get(StudentDiscipline.class,integer);
            return studentDiscipline;
        }
    }
}
