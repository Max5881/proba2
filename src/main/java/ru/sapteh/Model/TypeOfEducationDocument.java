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
@Table(name = "type_of_education_document")
public class TypeOfEducationDocument {

    public TypeOfEducationDocument(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "typeOfEducationDocument",cascade = CascadeType.ALL)
    private Set<CertificateOfEducation> certificateOfEducations;

    @Override
    public String toString() {
        return "TypeOfEducationDocument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
