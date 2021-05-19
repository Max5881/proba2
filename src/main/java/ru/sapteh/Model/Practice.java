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
@Table(name = "practice")
public class Practice {

    public Practice(int code, int maxHours) {
        this.code = code;
        this.maxHours = maxHours;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int code;

    @Column(name = "max_hours",nullable = false)
    private int maxHours;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fpa fpa;

    @ManyToOne(cascade = CascadeType.ALL)
    private Pm pm;

    @ManyToOne(cascade = CascadeType.ALL)
    private TypePractice typePractice;

    @Override
    public String toString() {
        return "Practice{" +
                "id=" + id +
                ", code=" + code +
                ", maxHours=" + maxHours +
                '}';
    }
}
