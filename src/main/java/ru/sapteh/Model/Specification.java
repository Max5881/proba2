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
@Table(name = "specification")
public class Specification {

    public Specification(String code, String name, String durationOfTraining) {
        this.code = code;
        this.name = name;
        this.durationOfTraining = durationOfTraining;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(name = "duration_of_training",nullable = false)
    private String durationOfTraining;

    @ManyToOne(cascade = CascadeType.ALL)
    private Oo oo;

    @OneToMany(mappedBy = "specification",cascade = CascadeType.ALL)
    private Set<Diplom> diploms;

    @OneToMany(mappedBy = "specification",cascade = CascadeType.ALL)
    private Set<Curriculum> curricula;

    @Override
    public String toString() {
        return "Specification{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", durationOfTraining='" + durationOfTraining + '\'' +
                '}';
    }
}
