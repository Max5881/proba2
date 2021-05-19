package ru.sapteh.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Practice;
import ru.sapteh.Model.TypePractice;
import ru.sapteh.Service.PracticeService;
import ru.sapteh.Service.TypePracticeService;

public class CreatePracticeWindowController {

    @FXML
    private TextField namePracticeTextField;

    @FXML
    private TextField hoursPracticeTextField;

    @FXML
    private TextField codePracticeTextField;

    @FXML
    private Button createPracticeButton;

    @FXML
    private Button exitPracticeButton;

    @FXML
    private void initialize(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Practice,Integer> practiceIntegerDAO = new PracticeService(factory);
        DAO<TypePractice,Integer> typePracticeIntegerDAO = new TypePracticeService(factory);

        createPracticeButton.setOnAction(event -> {
            typePracticeIntegerDAO.create(new TypePractice(namePracticeTextField.getText()));
            practiceIntegerDAO.create(new Practice(Integer.parseInt(codePracticeTextField.getText()),Integer.parseInt(hoursPracticeTextField.getText())));
        });
        exitPracticeButton.setOnAction(event -> {
            exitPracticeButton.getScene().getWindow().hide();
        });
    }
}
