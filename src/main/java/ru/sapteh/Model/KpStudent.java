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
@Table(name = "kp_student")
public class KpStudent {

    public KpStudent(String topic) {
        this.topic = topic;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String topic;

    @Column(nullable = false)
    private int estimation;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    private Kp kp;

    @Override
    public String toString() {
        return "КпStudent{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", estimation=" + estimation +
                '}';
    }
}
