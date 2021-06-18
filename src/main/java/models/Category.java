package models;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "category", fetch= FetchType.EAGER, orphanRemoval = true) //, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Product> products;
    @OneToMany(mappedBy = "category", fetch= FetchType.LAZY, orphanRemoval = true) //, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<PropertyName> propertyNames;
}
