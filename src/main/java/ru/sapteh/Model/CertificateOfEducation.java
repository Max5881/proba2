package ru.sapteh.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "certificate_of_education")
public class CertificateOfEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int serial;

    @Column(nullable = false)
    private int number;

    @Column(name = "date_issue",nullable = false)
    private String dateIssue;

    @Column(name = "issue_by_whom",nullable = false)
    private String issuedByWhom;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    private TypeOfEducationDocument typeOfEducationDocument;

    @Override
    public String toString() {
        return "CertificateOfEducation{" +
                "id=" + id +
                ", serial=" + serial +
                ", number=" + number +
                ", dateIssue='" + dateIssue + '\'' +
                ", issuedByWhom='" + issuedByWhom + '\'' +
                '}';
    }
}
