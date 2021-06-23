package models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString(exclude = "orders")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String password;
    //private List<String> testList;
    @OneToMany(mappedBy = "customer", fetch= FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private List<Order> orders;
}
