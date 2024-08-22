package com.example.school.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;


    @NotEmpty(message = "area cannot be null or empty")

    private String area;
    @NotEmpty(message = "street cannot be null or empty")

    private String street;
    @NotNull(message = "buildingNo cannot be null or empty")

    private int buildingNo;


}
