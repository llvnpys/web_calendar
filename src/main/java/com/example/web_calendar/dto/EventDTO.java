package com.example.web_calendar.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

    private Long id;

    private String title;
    private String description;
    private String location;

    private LocalDateTime start;
    private LocalDateTime end;
    private boolean isAllDay;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
