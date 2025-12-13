package uk.co.jlsigntech.interpreterbookingportalservice.domain.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Builder(toBuilder = true)
public record Interpreter(@MongoId UUID interpreterId,
                          String preferredInterpreterName) {
}
//todo test builder