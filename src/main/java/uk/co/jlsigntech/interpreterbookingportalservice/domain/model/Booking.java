package uk.co.jlsigntech.interpreterbookingportalservice.domain.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.UUID;

@Builder(toBuilder = true)
public record Booking(@MongoId UUID id,
                      LocalDate date) {
}
