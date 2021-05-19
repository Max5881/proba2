package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Passport;
import ru.sapteh.Model.TypeOfEducationDocument;

import java.util.List;

public class TypeOfEducationDocumentService implements DAO<TypeOfEducationDocument,Integer> {
    private final SessionFactory factory;

    public TypeOfEducationDocumentService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(TypeOfEducationDocument typeOfEducationDocument) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(typeOfEducationDocument);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(TypeOfEducationDocument typeOfEducationDocument) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(typeOfEducationDocument);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(TypeOfEducationDocument typeOfEducationDocument) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(typeOfEducationDocument);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<TypeOfEducationDocument> readByAll() {
        try(Session session = factory.openSession()){
            Query<TypeOfEducationDocument> query = session.createQuery("FROM TypeOfEducationDocument");
            return query.list();
        }

    }

    @Override
    public TypeOfEducationDocument read(Integer integer) {
        try(Session session = factory.openSession()){
            TypeOfEducationDocument typeOfEducationDocument = session.get(TypeOfEducationDocument.class,integer);
            return typeOfEducationDocument;
        }
    }
}
