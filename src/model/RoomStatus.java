package model;

import java.io.Serializable;

// Enum dùng để giới hạn các trạng thái của phòng
public enum RoomStatus implements Serializable {
    ACTIVE,
    MAINTENANCE
}