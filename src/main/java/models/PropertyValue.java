package models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;


@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class PropertyValue {
    private String value;

}
