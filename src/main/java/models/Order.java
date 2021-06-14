package models;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class Order {
    private int id;
    private User customer;
    private int quantity;
    private Product product;

}
