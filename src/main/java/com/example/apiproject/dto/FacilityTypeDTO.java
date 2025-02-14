package com.example.apiproject.dto;

import com.example.apiproject.entity.FacilityType;
import com.example.apiproject.entity.SportsFacility;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityTypeDTO {
    private Long id;
    private String name;
    private List<String> facilityNames; // Chỉ lấy danh sách tên sân

    public static FacilityTypeDTO fromEntity(FacilityType facilityType) {
        return new FacilityTypeDTO(
                facilityType.getId(),
                facilityType.getName(),
                facilityType.getFacilities().stream()
                        .map(SportsFacility::getName) // Lấy tên sân
                        .collect(Collectors.toList())
        );
    }
}
