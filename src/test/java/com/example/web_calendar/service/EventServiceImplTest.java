package com.example.web_calendar.service;

import com.example.web_calendar.dto.EventDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class EventServiceImplTest {

    @Autowired
    private EventService eventService;

    @Test
    @DisplayName("일정 생성")
    public void testCreate() {

        EventDTO eventDTO = EventDTO.builder()
                .title("test1")
                .description("test des1")
                .location("hanyang")
                .startTime(LocalDateTime.of(2024, 9, 13, 15, 0)) // 시작 시간 설정
                .endTime(LocalDateTime.of(2024, 9, 15, 17, 0))   // 종료 시간 설정
                .isAllDay(false) // All day 여부 설정
                .build();

        eventService.create(eventDTO);
    }

    @Test
    @DisplayName("일정 수정 : 기본 정보")
    public void testModifyInfo() {
        EventDTO eventDTO = EventDTO.builder()
                .eno(1L)
                .title("test2")
                .description("test des2")
                .location("hanyang3")
                .startTime(LocalDateTime.of(2024, 9, 13, 15, 0)) // 시작 시간 설정
                .endTime(LocalDateTime.of(2024, 9, 15, 17, 0))   // 종료 시간 설정
                .isAllDay(false) // All day 여부 설정
                .build();

        eventService.modifyInfo(eventDTO);
    }


}