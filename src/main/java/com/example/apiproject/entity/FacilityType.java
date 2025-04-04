package com.example.apiproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class FacilityType {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facilityTypeId;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @OneToMany(mappedBy = "facilityType", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<SubFacility> subFacilities = new ArrayList<>();
}
