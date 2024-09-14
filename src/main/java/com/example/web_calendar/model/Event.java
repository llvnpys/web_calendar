package com.example.web_calendar.model;

import com.example.web_calendar.dto.EventDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "events")
public class Event extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eno;

    private String title;
    private String description;
    private String location;

    @Column(name = "start_time")
    private LocalDateTime start;
    @Column(name = "end_time")
    private LocalDateTime end;
    @Column(name = "is_all_day")
    private boolean isAllDay;


    public void updateInfo(EventDTO eventDTO) {
        this.title = eventDTO.getTitle();
        this.description = eventDTO.getDescription();
        this.location = eventDTO.getLocation();
    }

    public void updateDates(EventDTO eventDTO) {
        this.isAllDay = eventDTO.isAllDay();
        this.start = eventDTO.getStart();
        this.end = eventDTO.getEnd();
    }

}
