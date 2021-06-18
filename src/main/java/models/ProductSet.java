package models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_sets")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class ProductSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String products; // id, quantity
    @OneToMany(mappedBy = "productSet", fetch= FetchType.LAZY)
    private List<Order> orders;

}


