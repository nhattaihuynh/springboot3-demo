package com.profile_service.dto.response;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCreateResponse {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String city;
}
