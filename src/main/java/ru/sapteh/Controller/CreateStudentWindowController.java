package ru.sapteh.Controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.*;
import ru.sapteh.Service.*;

import java.io.IOException;
import java.util.ArrayList;

public class CreateStudentWindowController {

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField patronymicTextField;

    @FXML
    private TextField dateBirthdayTextField;


    @FXML
    private TextField documentObrTextField;

    @FXML
    private TextField yearDocumentObrTextField;

    @FXML
    private TextField levelObrzTextField;

    @FXML
    private TextField periodTraingSTextField;


    @FXML
    private TextField SrocTextField;

    @FXML
    private TextField statusDiplomTextField;

    @FXML
    private TextField dateIssueDiplomTextField;

    @FXML
    private TextField regNumberDiplomTextField;

    @FXML
    private TextField seriaDiplomTextField;

    @FXML
    private TextField seriaAppTextField;

    @FXML
    private TextField dateResheniaTextField;


    @FXML
    private TextField qualificationTextField;

    @FXML
    private TextField specificationTextField;

    @FXML
    private TextField codeTextField;


    @FXML
    private TextField numberDiplomTextField;

    @FXML
    private TextField numberAppTextField;

    @FXML
    private TableColumn<KpStudent, Integer> idKpColumn;

    @FXML
    private TableColumn<KpStudent, String> nameKpColumn;

    @FXML
    private Button createKpButton;

    @FXML
    private Button deleteKpButton;

//    @FXML
//    private TableColumn<Kp, Integer> estimColumn;

    @FXML
    private TableColumn<Practice, Integer> numberPracticColumn;

    @FXML
    private TableColumn<Practice, String> namePracticColumn;

    @FXML
    private TableColumn<Practice, Integer> hoursPracticeColumn;

    @FXML
    private Button createPracticeButton;

    @FXML
    private Button deletePracticeButton;

//    @FXML
//    private TableColumn<Practice, Integer> estimPracticColumn;

    @FXML
    private TableColumn<DisciplineCurriculum, Integer> numberDisciplineColumn;

    @FXML
    private TableColumn<DisciplineCurriculum, String> nameDisciplineColumn;

    @FXML
    private TableColumn<DisciplineCurriculum, Integer> hoursDisciplineColumn;

    @FXML
    private Button createDisciplineButton;

    @FXML
    private Button deleteDisciplineButton;

//    @FXML
//    private TableColumn<Discipline, Integer> estimDisciplineColumn;

    @FXML
    private TextField quantityNumberTextField;

    @FXML
    private TextField quantityHoursTextField;

    @FXML
    private TextField ooTextField;

    @FXML
    private TextField chairmanTextField;

    @FXML
    private TextField secretaryTextField;

    @FXML
    private Button createStudentButton;

    @FXML
    private Button exitStudentButton;

    @FXML
    private TableView<Practice> practiceTableView;

    @FXML
    private TableView<DisciplineCurriculum> disciplineTableView;

    @FXML
    private TableView<KpStudent> kpTableView;


    @FXML
    public void initialize(){
        initStudent();
        initKp();
        initPractice();
        initDiscipline();
        initPodpis();
    }
    private void initStudent(){
        createStudentButton.setOnAction(event -> {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            DAO<Student,Integer> studentIntegerDAO = new StudentService(factory);
            Diplom diplom = new Diplom ((Integer.parseInt(seriaDiplomTextField.getText())),(Integer.parseInt(numberDiplomTextField.getText())),Integer.parseInt(seriaAppTextField.getText()),Integer.parseInt(seriaAppTextField.getText()),dateIssueDiplomTextField.getText());
            studentIntegerDAO.create(new Student(lastNameTextField.getText(),firstNameTextField.getText(),patronymicTextField.getText(),dateBirthdayTextField.getText(),diplom));
        });
        exitStudentButton.setOnAction(event -> {
            exitStudentButton.getScene().getWindow().hide();
        });
    }
    private void initKp(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        ObservableList<KpStudent> students = FXCollections.observableArrayList();
        DAO<KpStudent,Integer> studentIntegerDAO = new КпStudentService(factory);
        students.addAll(studentIntegerDAO.readByAll());

        Image image = new Image("/image/create.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        createKpButton.setGraphic(imageView);

        Image image1 = new Image("/image/del.jpg");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(20);
        imageView1.setFitHeight(20);
        deleteKpButton.setGraphic(imageView1);

        idKpColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getKp().getId()));
        nameKpColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getTopic()));

        kpTableView.setItems(students);

        createKpButton.setOnAction(event -> {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/View/createKpWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Добавление курсового проекта");
            stage.setScene(new Scene(root));
            stage.show();

        });

        deleteKpButton.setOnAction(event -> {

        });
    }
    private void initPractice(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        ObservableList<Practice> practices = FXCollections.observableArrayList();
        DAO<Practice,Integer> practiceIntegerDAO = new PracticeService(factory);
        practices.addAll(practiceIntegerDAO.readByAll());

        Image image = new Image("/image/create.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        createPracticeButton.setGraphic(imageView);

        Image image1 = new Image("/image/del.jpg");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(20);
        imageView1.setFitHeight(20);
        deletePracticeButton.setGraphic(imageView1);

        numberPracticColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getId()));
        namePracticColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getTypePractice().getName()));
        hoursPracticeColumn.setCellValueFactory(p->new SimpleObjectProperty<>((p.getValue().getMaxHours()/168)));

        practiceTableView.setItems(practices);

        createPracticeButton.setOnAction(event -> {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/View/createPracticeWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Добавление практики");
            stage.setScene(new Scene(root));
            stage.show();
        });
        deletePracticeButton.setOnAction(event -> {

        });
    }
    private void initDiscipline(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        ObservableList<DisciplineCurriculum> disciplineCurricula = FXCollections.observableArrayList();
        DAO<DisciplineCurriculum,Integer> disciplineCurriculumIntegerDAO = new DisciplineCurriculumService(factory);
        disciplineCurricula.addAll(disciplineCurriculumIntegerDAO.readByAll());

        Image image = new Image("/image/create.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        createDisciplineButton.setGraphic(imageView);

        Image image1 = new Image("/image/del.jpg");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(20);
        imageView1.setFitHeight(20);
        deleteDisciplineButton.setGraphic(imageView1);

        numberDisciplineColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getDiscipline().getId()));
        nameDisciplineColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getDiscipline().getName()));
        hoursDisciplineColumn.setCellValueFactory(p->new SimpleObjectProperty<>(p.getValue().getMaxHours()));

        int maxId = 1;
        int hourse = 0;
        int maxHours = 0;

        ArrayList<Discipline> disciplineArrayList =new ArrayList<>();
        for (Discipline discipline : disciplineArrayList){
            maxId++;
        }
//        ArrayList<DisciplineCurriculum> disciplineCurriculumArrayList = new ArrayList<>();
//        for (DisciplineCurriculum disciplineCurriculum : disciplineCurriculumArrayList){
//            hourse = disciplineCurriculum.getMaxHours();
//            maxHours = maxHours + hourse;
//        }

        quantityHoursTextField.setText(String.valueOf(maxHours));
        quantityNumberTextField.setText(String.valueOf(maxId));
        disciplineTableView.setItems(disciplineCurricula);

        createDisciplineButton.setOnAction(event -> {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/View/createDisciplineWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle("Добавление дисциплины");
            stage.setScene(new Scene(root));
            stage.show();
        });
        deleteDisciplineButton.setOnAction(event -> {

        });



    }
    private void initPodpis(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Oo,Integer> ooIntegerDAO = new OoService(factory);
        DAO<Gia,Integer> giaIntegerDAO = new GiaService(factory);
        DAO<Curriculum,Integer> curriculumIntegerDAO = new CurriculumService(factory);
        DAO<Specification,Integer> specificationIntegerDAO = new SpecificationService(factory);
        DAO<Status,Integer> statusIntegerDAO = new StatusService(factory);
        DAO<Diplom,Integer> diplomIntegerDAO = new DiplomService(factory);
        DAO<TypeOfEducationDocument,Integer> typeOfEducationDocumentIntegerDAO = new TypeOfEducationDocumentService(factory);

        ooTextField.setText(ooIntegerDAO.read(1).getDirector());
        secretaryTextField.setText(giaIntegerDAO.read(1).getSecretary());
        statusDiplomTextField.setText(statusIntegerDAO.read(1).getName());
        createStudentButton.setOnAction(event -> {
            giaIntegerDAO.create(new Gia(dateResheniaTextField.getText(),chairmanTextField.getText(),secretaryTextField.getText()));
            curriculumIntegerDAO.create(new Curriculum(periodTraingSTextField.getText(),qualificationTextField.getText()));
            specificationIntegerDAO.create(new Specification(codeTextField.getText(),specificationTextField.getText(),SrocTextField.getText()));
            diplomIntegerDAO.create(new Diplom(Integer.parseInt(seriaDiplomTextField.getText()),Integer.parseInt(numberDiplomTextField.getText()),Integer.parseInt(seriaAppTextField.getText()),Integer.parseInt(numberAppTextField.getText()),dateIssueDiplomTextField.getText()));
            typeOfEducationDocumentIntegerDAO.create(new TypeOfEducationDocument(documentObrTextField.getText()));


        });


    }
}
