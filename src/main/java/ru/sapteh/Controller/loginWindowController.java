package ru.sapteh.Controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Diplom;
import ru.sapteh.Model.Gia;
import ru.sapteh.Model.Student;
import ru.sapteh.Service.DiplomService;
import ru.sapteh.Service.GiaService;
import ru.sapteh.Service.StudentService;

import java.io.IOException;
import java.util.ArrayList;

public class loginWindowController {
    ObservableList<Student> studentObservableList = FXCollections.observableArrayList();
    ObservableList<Diplom> diplomObservableList = FXCollections.observableArrayList();
    ObservableList<Gia> giaObservableList = FXCollections.observableArrayList();
    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @FXML
    private TableView<Student> studentTableView;

    @FXML
    private TableColumn<Student, Integer> idStudent;

    @FXML
    private TableColumn<Student, String> LFPStudent;

    @FXML
    private TableColumn<Student, String> birthday;

    @FXML
    private TableColumn<Student, Integer> diplom;

    @FXML
    private TableColumn<Student, Integer> regNumber;

    @FXML
    private TableColumn<Student, String> dateRes;

    @FXML
    private TableColumn<Student, String> dataVid;

    @FXML
    private MenuItem createStudentMenuBar;

    @FXML
    private MenuItem closeMenuBar;

    @FXML
    private MenuItem saveMenuBar;

    @FXML
    private MenuItem exitMenuBar;

    @FXML
    private MenuItem updateMenuBar;

    @FXML
    private MenuItem shablonMenuBar;

    @FXML
    private MenuItem deleteMenuBar;

    @FXML
    private MenuItem diplomDifference;

    @FXML
    private MenuItem registrationNumberDiplomMenuBar;

    @FXML
    private MenuItem numberProtocolMenuBar;

    @FXML
    private MenuItem dateDecisionMenuBar;

    @FXML
    private MenuItem dateOfIssuedMenuBar;

    @FXML
    private MenuItem userGuideMenuBar;

        @FXML
        public void initialize(){
            initDate();
            menuBar();
        }
        public void initDate(){
            DAO<Student,Integer> studentIntegerDAO = new StudentService(factory);
            studentObservableList.addAll(studentIntegerDAO.readByAll());

            idStudent.setCellValueFactory(p->new SimpleObjectProperty<Integer>(p.getValue().getId()));
            LFPStudent.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getLastName() +" " + p.getValue().getFirstName() + " " + p.getValue().getPatronymic()));
            birthday.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getDateBirthday()));
            diplom.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getDiploms().getNumberDiplom()));
            regNumber.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getDiploms().getRegisterNumber()));
            dateRes.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getDiploms().getGia().getDecisionDate()));
            dataVid.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getDiploms().getDateOfIssue()));

            studentTableView.setItems(studentObservableList);
        }

        public void menuBar(){
            createStudentMenuBar.setOnAction(event -> {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/View/createStudentWindow.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = new Stage();
                Image image = new Image("/image/icon.jpg");
                stage.getIcons().add(image);
                stage.setTitle("Карточка студента");
                stage.setScene(new Scene(root));
                stage.show();
            });
        }

}
