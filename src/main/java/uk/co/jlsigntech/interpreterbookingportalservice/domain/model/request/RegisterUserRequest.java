package uk.co.jlsigntech.interpreterbookingportalservice.domain.model.request;

public record RegisterUserRequest(String firstName,
                                  String lastName,
                                  String email,
                                  String password) {
}
