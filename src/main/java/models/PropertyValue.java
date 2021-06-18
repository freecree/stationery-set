package models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "property_values")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class PropertyValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String value;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propertyName_id")
    private PropertyName propertyName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

}
