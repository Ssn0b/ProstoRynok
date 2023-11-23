package app.snob.customerservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "_customers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String email;
    private String phoneNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
}
