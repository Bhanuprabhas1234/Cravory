package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "track_orders")
public class TrackOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trackId;

    @Column(name = "menu_id")
    private int menuId;

    private int month;
    private int year;

    @Column(name = "reservations_count") // Ensure that the column names in the database match the field names here.
    private int reservationsCount;

    @Column(name = "orders_count")
    private int ordersCount;

    // Getters and Setters
    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getReservationsCount() {
        return reservationsCount;
    }

    public void setReservationsCount(int reservationsCount) {
        this.reservationsCount = reservationsCount;
    }

    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }
}
