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
@Table(name = "curriculum")
public class Curriculum {

    public Curriculum(String yearOfTheCurriculum, String qualification) {
        this.yearOfTheCurriculum = yearOfTheCurriculum;
        this.qualification = qualification;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "year_of_the_curriculum",nullable = false)
    private String yearOfTheCurriculum;

    @Column(name = "max_hours",nullable = false)
    private int maxHours;

    @Column(name = "sam_hourse",nullable = false)
    private int samHourse;

    @Column(name = "audit_hourse",nullable = false)
    private int auditHourse;

    @Column(nullable = false)
    private String qualification;

    @OneToMany(mappedBy = "curriculum",cascade = CascadeType.ALL)
    private Set<Grup> groups;

    @OneToMany(mappedBy = "curriculum",cascade = CascadeType.ALL)
    private Set<Pm> pms;

    @OneToMany(mappedBy = "curriculum",cascade = CascadeType.ALL)
    private Set<DisciplineCurriculum> disciplineCurriculums;

    @ManyToOne(cascade = CascadeType.ALL)
    private Specification specification;

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + id +
                ", yearOfTheCurriculum='" + yearOfTheCurriculum + '\'' +
                ", maxHours=" + maxHours +
                ", samHourse=" + samHourse +
                ", auditHourse=" + auditHourse +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
