package models;

import lombok.*;

import java.util.Collection;
import java.util.Map;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Category category;
    private Map<PropertyName, PropertyValue> properties;

}
