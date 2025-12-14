package uk.co.jlsigntech.interpreterbookingportalservice.out.mongo.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InterpreterPO {

    @Id
    UUID interpreterId;
    String preferredInterpreterName;
}
