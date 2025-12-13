package uk.co.jlsigntech.interpreterbookingportalservice.domain.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Builder(toBuilder = true)
public record User(@MongoId UUID userId,
                   String password,
                   String firstName,
                   String lastName,
                   String email,
                   String role) {
}
