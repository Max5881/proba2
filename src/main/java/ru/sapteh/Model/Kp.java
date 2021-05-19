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
@Table(name = "kp")
public class Kp {

    public Kp(String numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number_of_hours",nullable = false)
    private String numberOfHours;

    @OneToMany(mappedBy = "kp",cascade = CascadeType.ALL)
    private Set<KpStudent> kpStudents;

    @OneToMany(mappedBy = "kp",cascade = CascadeType.ALL)
    private Set<Mdk> mdks;

    @Override
    public String toString() {
        return "Кп{" +
                "id=" + id +
                ", numberOfHours='" + numberOfHours + '\'' +
                '}';
    }
}
