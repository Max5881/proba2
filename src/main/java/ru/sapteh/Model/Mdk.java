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
@Table(name = "mdk")
public class Mdk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "max_hours",nullable = false)
    private int maxHours;

    @Column(name = "sam_hours",nullable = false)
    private int samHours;

    @Column(name = "audit_hours",nullable = false)
    private int auditHours;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fpa fpa;

    @ManyToOne(cascade = CascadeType.ALL)
    private Pm pm;

    @ManyToOne(cascade = CascadeType.ALL)
    private Kp kp;

    @Override
    public String toString() {
        return "Мдк{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxHours=" + maxHours +
                ", samHours=" + samHours +
                ", auditHours=" + auditHours +
                '}';
    }
}
