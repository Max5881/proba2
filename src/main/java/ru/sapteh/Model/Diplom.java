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
@Table(name = "diplom")
public class Diplom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Diplom( int serialDiplom, int numberDiplom, int serialApplication, int numberApplication, String dateOfIssue) {

        this.serialDiplom = serialDiplom;
        this.numberDiplom = numberDiplom;
        this.serialApplication = serialApplication;
        this.numberApplication = numberApplication;
        this.dateOfIssue = dateOfIssue;
    }

    @Column(name = "register_number",nullable = false)
    private int registerNumber;

    @Column(name = "serial_diplom",nullable = false)
    private int serialDiplom;

    @Column(name = "number_diplom",nullable = false)
    private int numberDiplom;

    @Column(name = "serial_application",nullable = false)
    private int serialApplication;

    @Column(name = "number_application",nullable = false)
    private int numberApplication;

    @Column(name = "date_of_issue",nullable = false)
    private String dateOfIssue;

    @OneToOne(cascade = CascadeType.ALL)
    private Student students;

    @ManyToOne(cascade = CascadeType.ALL)
    private Specification specification;

    @ManyToOne(cascade = CascadeType.ALL)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    private Gia gia;

    @Override
    public String toString() {
        return "Diplom{" +
                "id=" + id +
                ", registerNumber=" + registerNumber +
                ", serialDiplom=" + serialDiplom +
                ", numberDiplom=" + numberDiplom +
                ", serialApplication=" + serialApplication +
                ", numberApplication=" + numberApplication +
                ", dateOfIssue=" + dateOfIssue +
                '}';
    }
}
