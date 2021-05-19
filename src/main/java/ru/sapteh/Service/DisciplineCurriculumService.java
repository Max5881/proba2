package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Discipline;
import ru.sapteh.Model.DisciplineCurriculum;

import java.util.List;

public class DisciplineCurriculumService implements DAO<DisciplineCurriculum,Integer> {
    private final SessionFactory factory;

    public DisciplineCurriculumService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(DisciplineCurriculum disciplineCurriculum) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(disciplineCurriculum);
            session.getTransaction().commit();
        }

    }

    @Override
    public void update(DisciplineCurriculum disciplineCurriculum) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(disciplineCurriculum);
            session.getTransaction().commit();
        }

    }

    @Override
    public void delete(DisciplineCurriculum disciplineCurriculum) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(disciplineCurriculum);
            session.getTransaction().commit();
        }

    }

    @Override
    public List<DisciplineCurriculum> readByAll() {
        try(Session session = factory.openSession()){
            Query<DisciplineCurriculum> query = session.createQuery("FROM DisciplineCurriculum");
            return query.list();
        }

    }

    @Override
    public DisciplineCurriculum read(Integer integer) {
        try(Session session = factory.openSession()){
            DisciplineCurriculum disciplineCurriculum = session.get(DisciplineCurriculum.class,integer);
            return disciplineCurriculum;
        }
    }
}
