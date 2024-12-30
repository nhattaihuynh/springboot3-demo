package com.devteria.identity.dto.client;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCreateRequest {
    private String userId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String city;
}
