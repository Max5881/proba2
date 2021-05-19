package ru.sapteh.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Discipline;
import ru.sapteh.Model.DisciplineCurriculum;
import ru.sapteh.Service.DisciplineCurriculumService;
import ru.sapteh.Service.DisciplineService;

public class createDisciplineWindowController {

    @FXML
    private TextField nameDisciplineTextField;

    @FXML
    private TextField hoursDisciplineTextField;

    @FXML
    private TextField codeDisciplineTextField;

    @FXML
    private Button createDisciplineButton;

    @FXML
    private Button exitDisciplineButton;

    @FXML
    public void initialize(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Discipline,Integer> disciplineIntegerDAO = new DisciplineService(factory);
        DAO<DisciplineCurriculum,Integer> disciplineCurriculumIntegerDAO = new DisciplineCurriculumService(factory);

        createDisciplineButton.setOnAction(event -> {
            disciplineIntegerDAO.create(new Discipline(nameDisciplineTextField.getText()));
            disciplineCurriculumIntegerDAO.create(new DisciplineCurriculum(codeDisciplineTextField.getText(),Integer.parseInt(hoursDisciplineTextField.getText())));
        });
        exitDisciplineButton.setOnAction(event -> {
            exitDisciplineButton.getScene().getWindow().hide();

        });
    }

}
