package models;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "property_names")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class PropertyName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "propertyName") // orphanRemoval = false
    private List<PropertyValue> propertyValues;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
