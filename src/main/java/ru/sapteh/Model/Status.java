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
@Table(name = "status")
public class Status {

    public Status(String name) {
        this.name = name;
    }

    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "status",cascade = CascadeType.ALL)
    private Set<Diplom> diploms;

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
