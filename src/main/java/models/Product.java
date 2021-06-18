package models;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY) //fetch = FetchType.LAZY
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product", fetch= FetchType.EAGER, orphanRemoval = true)
    private List<PropertyValue> propertyValues;
    //private Map<PropertyName, PropertyValue> properties;
    @OneToMany(mappedBy = "product", fetch= FetchType.LAZY)
    private List<Order> orders;

}
