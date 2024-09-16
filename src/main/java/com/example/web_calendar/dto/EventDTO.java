package com.example.web_calendar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

// 검증 로직 포함
public class EventDTO {

    private Long eno;

    @NotBlank
    private String title;
    private String description;
    private String location;

    private LocalDateTime start;
    private LocalDateTime end;
    private boolean isAllDay;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
