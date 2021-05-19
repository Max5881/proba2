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
@Table(name = "fpa")
public class Fpa {

    public Fpa(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "fpa",cascade = CascadeType.ALL)
    private Set<Mdk> mdks;

    @OneToMany(mappedBy = "fpa",cascade = CascadeType.ALL)
    private Set<DisciplineCurriculum> disciplineCurricula;

    @OneToMany(mappedBy = "fpa",cascade = CascadeType.ALL)
    private Set<Practice> practices;

    @Override
    public String toString() {
        return "Fpa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
