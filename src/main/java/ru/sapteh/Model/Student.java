package ru.sapteh.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    public Student(String lastName, String firstName, String patronymic, String dateBirthday, Diplom diploms) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateBirthday = dateBirthday;
        this.diploms = diploms;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column()
    private String patronymic;

    @Column()
    private String adress;

    @Column(name = "number_phone")
    private String numberPhone;

    @Column()
    private String email;

    @Column(name = "date_birthday")
    private String dateBirthday;

    @ManyToOne(cascade = CascadeType.ALL)
    private Grup group;

    @ManyToOne(cascade = CascadeType.ALL)
    private Passport passport;

    @OneToOne(mappedBy = "students",cascade = CascadeType.ALL)
    private Diplom diploms;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Set<StudentDiscipline> studentDisciplines;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Set<CertificateOfEducation> certificateOfEducations;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Set<StudentPractice> studentPractices;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Set<KpStudent> kpStudents;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", adress='" + adress + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", email='" + email + '\'' +
                ", dateBirthday='" + dateBirthday + '\'' +
                '}';
    }
}
