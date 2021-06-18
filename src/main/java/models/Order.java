package models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString()
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY) //fetch = FetchType.LAZY
    @JoinColumn(name = "user_id")
    private User customer;
    //private int quantity;
    @ManyToOne(fetch = FetchType.LAZY) //fetch = FetchType.LAZY
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY) //fetch = FetchType.LAZY
    @JoinColumn(name = "productSet_id")
    private ProductSet productSet;

}
