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
@Table(name = "pm")
public class Pm {

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
    private Curriculum curriculum;

    @OneToMany(mappedBy = "pm",cascade = CascadeType.ALL)
    private Set<Practice> practices;

    @OneToMany(mappedBy = "pm",cascade = CascadeType.ALL)
    private Set<Mdk> mdks;

    @Override
    public String toString() {
        return "Пм{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxHours=" + maxHours +
                ", samHours=" + samHours +
                ", auditHours=" + auditHours +
                '}';
    }
}
