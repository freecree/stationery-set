package models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = {"orders", "propertyValues"})
@ToString(exclude = {"orders", "propertyValues"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    private String name;
    private String description;
    private double price;
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY) //fetch = FetchType.LAZY
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product", fetch= FetchType.EAGER, orphanRemoval = true) //, orphanRemoval = true
    private List<PropertyValue> propertyValues = new ArrayList<>();
    //private Map<PropertyName, PropertyValue> properties;
    @OneToMany(mappedBy = "product", fetch= FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();
}
