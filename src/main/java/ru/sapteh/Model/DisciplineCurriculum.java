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
@Table(name = "discipline_curriculum")
public class DisciplineCurriculum {

    public DisciplineCurriculum(String code, int maxHours) {
        this.code = code;
        this.maxHours = maxHours;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String code;

    @Column(name = "max_hours",nullable = false)
    private int maxHours;

    @Column(name = "sam_hours",nullable = false)
    private int samHours;

    @Column(name = "audit_hours",nullable = false)
    private String auditHours;

    @OneToMany(mappedBy = "disciplineCurriculum",cascade = CascadeType.ALL)
    private Set<StudentDiscipline> studentDisciplines;

    @ManyToOne(cascade = CascadeType.ALL)
    private Curriculum curriculum;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fpa fpa;

    @ManyToOne(cascade = CascadeType.ALL)
    private Discipline discipline;

    @Override
    public String toString() {
        return "DisciplineCurriculum{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", maxHours=" + maxHours +
                ", samHours=" + samHours +
                ", auditHours='" + auditHours + '\'' +
                '}';
    }
}
