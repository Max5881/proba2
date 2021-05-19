package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Passport;
import ru.sapteh.Model.StudentPractice;

import java.util.List;

public class StudentPracticeService implements DAO<StudentPractice,Integer> {
    private final SessionFactory factory;

    public StudentPracticeService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(StudentPractice studentPractice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(studentPractice);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(StudentPractice studentPractice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(studentPractice);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(StudentPractice studentPractice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(studentPractice);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<StudentPractice> readByAll() {
        try(Session session = factory.openSession()){
            Query<StudentPractice> query = session.createQuery("FROM StudentPractice");
            return query.list();
        }

    }

    @Override
    public StudentPractice read(Integer integer) {
        try(Session session = factory.openSession()){
            StudentPractice studentPractice = session.get(StudentPractice.class,integer);
            return studentPractice;
        }
    }
}
