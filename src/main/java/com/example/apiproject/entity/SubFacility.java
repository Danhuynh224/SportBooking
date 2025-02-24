package com.example.apiproject.entity;

import com.example.apiproject.enums.FacilityStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "sports_facility_id", nullable = false)
    private SportsFacility sportsFacility; // Thuộc một khu thể thao

    @ManyToOne
    @JoinColumn(name = "facility_type_id", nullable = false)
    private FacilityType facilityType; // Thuộc loại sân nào (Cầu lông, Tennis, ...)

    @Column(nullable = false)
    private BigDecimal pricePerHour;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FacilityStatus status = FacilityStatus.AVAILABLE;

}
