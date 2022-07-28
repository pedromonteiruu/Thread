package br.com.usingcache.TrainingCaches.Entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PESSOA")
@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer Id;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;
}
