package model;

import java.io.Serializable;

// Lớp này không kế thừa ai, chỉ dùng để gom nhóm thời gian
public class TimeSlot implements Serializable {
    // Đóng gói dữ liệu (Encapsulation)
    private String startTime;
    private String endTime;

    // Constructor có tham số
    public TimeSlot(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Các hàm getter/setter để truy xuất dữ liệu an toàn
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}