package models;

import lombok.*;

import java.util.Collection;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class Category {
    private String name;
    private Collection<Product> products;
    private Collection<PropertyName> propertyNames;
}
