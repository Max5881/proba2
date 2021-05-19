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
@Table(name = "type_practice")
public class TypePractice {

    public TypePractice(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "typePractice",cascade = CascadeType.ALL)
    private Set<Practice> practices;

    @Override
    public String toString() {
        return "TypePractice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
