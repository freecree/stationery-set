package models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tests")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
}
