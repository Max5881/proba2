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
@Table(name = "gia")
public class Gia {

    public Gia(String decisionDate, String chairman, String secretary) {
        this.decisionDate = decisionDate;
        this.chairman = chairman;
        this.secretary = secretary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "decision_date",nullable = false)
    private String decisionDate;

    @Column(nullable = false)
    private String chairman;

    @Column(nullable = false)
    private String secretary;

    @OneToMany(mappedBy = "gia",cascade = CascadeType.ALL)
    private Set<Diplom> diploms;

    @Override
    public String toString() {
        return "Gia{" +
                "id=" + id +
                ", decisionDate='" + decisionDate + '\'' +
                ", chairman='" + chairman + '\'' +
                ", secretary='" + secretary + '\'' +
                '}';
    }
}
