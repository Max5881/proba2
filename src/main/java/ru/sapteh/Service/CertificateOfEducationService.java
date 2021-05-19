package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.CertificateOfEducation;

import java.util.List;

public class CertificateOfEducationService implements DAO<CertificateOfEducation,Integer> {
    private final SessionFactory factory;

    public CertificateOfEducationService(SessionFactory factory) {
        this.factory = factory;
    }

    public void create(CertificateOfEducation certificateOfEducation) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(certificateOfEducation);
            session.getTransaction().commit();
        }
    }

    public void update(CertificateOfEducation certificateOfEducation) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(certificateOfEducation);
            session.getTransaction().commit();
        }
    }

    public void delete(CertificateOfEducation certificateOfEducation) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(certificateOfEducation);
            session.getTransaction().commit();
        }
    }

    public List<CertificateOfEducation> readByAll() {
        try(Session session = factory.openSession()){
            Query<CertificateOfEducation> query = session.createQuery("FROM CertificateOfEducation");
            return query.list();
        }

    }

    public CertificateOfEducation read(Integer integer) {
        try(Session session = factory.openSession()){
            CertificateOfEducation certificateOfEducation= session.get(CertificateOfEducation.class,integer);
            return certificateOfEducation;
        }

    }
}
