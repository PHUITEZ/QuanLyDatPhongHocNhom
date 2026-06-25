package com.group5.main.model;

import java.io.Serializable;

public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bookingId;
    private Student student;
    private Room room;
    private TimeSlot timeSlot;
    private int numberOfParticipants;
    private String status;
    private double totalFee;

    public Booking() {
    }

    public Booking(String bookingId,
                   Student student,
                   Room room,
                   TimeSlot timeSlot,
                   int numberOfParticipants,
                   String status,
                   double totalFee) {

        this.bookingId = bookingId;
        this.student = student;
        this.room = room;
        this.timeSlot = timeSlot;
        this.numberOfParticipants = numberOfParticipants;
        this.status = status;
        this.totalFee = totalFee;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }
}