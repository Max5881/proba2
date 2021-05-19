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
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int serial;

    @Column(nullable = false)
    private int number;

    @Column(name = "date_of_issue",nullable = false)
    private String dateOdIssue;

    @Column(name = "issue_by_whom",nullable = false)
    private String issueByWhom;

    @Column(name = "where_issued",nullable = false)
    private String whereIssued;

    @OneToMany(mappedBy = "passport",cascade = CascadeType.ALL)
    private Set<Student> studentSet;

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", serial=" + serial +
                ", number=" + number +
                ", dateOdIssue='" + dateOdIssue + '\'' +
                ", issueByWhom='" + issueByWhom + '\'' +
                ", whereIssued='" + whereIssued + '\'' +
                '}';
    }
}
