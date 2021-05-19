package ru.sapteh.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grup")
public class Grup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "year",nullable = false)
    private String year;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Curriculum curriculum;

    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL)
    private Set<Student> students;

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
