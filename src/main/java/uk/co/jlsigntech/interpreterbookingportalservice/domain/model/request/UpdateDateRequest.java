package uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateDateRequest(@JsonProperty("bookingId") UUID bookingId,
                                @JsonProperty("date") LocalDate date) {
}
