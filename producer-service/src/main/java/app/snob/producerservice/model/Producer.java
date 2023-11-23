package app.snob.producerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "_producers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producer {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String photoUrl; // @TODO implement s3
    private String bannerImageUrl; // @TODO implement s3
}
