package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Passport;
import ru.sapteh.Model.Student;

import java.util.List;

public class StudentService implements DAO<Student,Integer> {
    private final SessionFactory factory;

    public StudentService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Student student) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Student student) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Student student) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Student> readByAll() {
        try(Session session = factory.openSession()){
            Query<Student> query = session.createQuery("FROM Student");
            return query.list();
        }
    }

    @Override
    public Student read(Integer integer) {
        try(Session session = factory.openSession()){
            Student student = session.get(Student.class,integer);
            return student;
        }
    }
}
