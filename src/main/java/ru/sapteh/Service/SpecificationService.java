package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Passport;
import ru.sapteh.Model.Specification;

import java.util.List;

public class SpecificationService implements DAO<Specification,Integer> {
    private final SessionFactory factory;

    public SpecificationService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Specification specification) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(specification);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(Specification specification) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(specification);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(Specification specification) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(specification);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<Specification> readByAll() {
        try(Session session = factory.openSession()){
            Query<Specification> query = session.createQuery("FROM Specification");
            return query.list();
        }

    }

    @Override
    public Specification read(Integer integer) {
        try(Session session = factory.openSession()){
            Specification specification = session.get(Specification.class,integer);
            return specification;
        }
    }
}
