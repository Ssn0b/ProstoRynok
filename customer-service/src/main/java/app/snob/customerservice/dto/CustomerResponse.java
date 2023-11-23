package app.snob.customerservice.dto;

import app.snob.customerservice.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private UUID id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String email;
    private String phoneNumber;
    private Address address;

}
