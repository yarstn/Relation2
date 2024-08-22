package com.example.school.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Address {
    @Id
    private Integer id;


    private String area;
    private String street;
    private int buildingNo;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
