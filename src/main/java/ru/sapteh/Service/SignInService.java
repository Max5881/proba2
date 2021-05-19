package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.SignIn;

import java.util.List;

public class SignInService implements DAO<SignIn,Integer> {
    private final SessionFactory factory;

    public SignInService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(SignIn signIn) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(signIn);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(SignIn signIn) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(signIn);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(SignIn signIn) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(signIn);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<SignIn> readByAll() {
        try(Session session = factory.openSession()){
            Query<SignIn> result = session.createQuery("FROM SignIn");
            return result.list();
        }
    }

    @Override
    public SignIn read(Integer integer) {
        try(Session session = factory.openSession()){
            SignIn result = session.get(SignIn.class,integer);
            return result;
        }

    }
}
