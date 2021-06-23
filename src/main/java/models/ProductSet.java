package models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_sets")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"orders"})
@ToString(exclude = {"orders"})
public class ProductSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String products; // id, quantity
    @OneToMany(mappedBy = "productSet", fetch= FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

}


