package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Passport;
import ru.sapteh.Model.TypePractice;

import java.util.List;

public class TypePracticeService implements DAO<TypePractice,Integer> {
    private final SessionFactory factory;

    public TypePracticeService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(TypePractice typePractice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(typePractice);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(TypePractice typePractice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(typePractice);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(TypePractice typePractice) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(typePractice);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<TypePractice> readByAll() {
        try(Session session = factory.openSession()){
            Query<TypePractice> query = session.createQuery("FROM TypePractice");
            return query.list();
        }

    }

    @Override
    public TypePractice read(Integer integer) {
        try(Session session = factory.openSession()){
            TypePractice typePractice = session.get(TypePractice.class,integer);
            return typePractice;
        }
    }
}
