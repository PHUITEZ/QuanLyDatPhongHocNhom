package com.group5.main.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TimeSlot implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TimeSlot() {
    }

    public TimeSlot(LocalDateTime startTime,
                    LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}