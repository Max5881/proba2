package ru.sapteh.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Kp;
import ru.sapteh.Model.KpStudent;
import ru.sapteh.Service.КпService;
import ru.sapteh.Service.КпStudentService;

public class CreateKpWindowController {

    @FXML
    private TextField nameKpTextField;

    @FXML
    private TextField hoursKpTextField;

    @FXML
    private Button createKpButton;

    @FXML
    private Button exitKpButton;

    @FXML
    public void initialize(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Kp,Integer> kpIntegerDAO = new КпService(factory);
        DAO<KpStudent,Integer> kpStudentIntegerDAO = new КпStudentService(factory);
        
        createKpButton.setOnAction(event -> {
            kpIntegerDAO.create(new Kp(hoursKpTextField.getText()));
            kpStudentIntegerDAO.create(new KpStudent(nameKpTextField.getText()));
        });
        exitKpButton.setOnAction(event -> {
            exitKpButton.getScene().getWindow().hide();
        });


    }

}
