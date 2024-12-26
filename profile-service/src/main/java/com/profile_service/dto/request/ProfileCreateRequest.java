package com.profile_service.dto.request;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCreateRequest {
    private String userId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String city;
}
