package com.merrymeal.mealsonwheels_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Double totalAmount;

    // ManyToOne relationship with Member (already there)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    @JsonBackReference
    private Member member;

    // NEW: ManyToOne relationship with Rider
    // Each Order can be delivered by one Rider
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rider_id") // Foreign key column in 'orders' table
    @JsonBackReference // Prevents infinite recursion in JSON serialization if Rider also has a reference to Orders
    private Rider rider; // <-- This field name 'rider' MUST match 'mappedBy = "rider"' in the Rider entity's @OneToMany

    // Constructors (update them if needed to include rider, or add a setter)
    public Order() {
    }

    public Order(LocalDateTime orderDate, String status, Double totalAmount, Member member, Rider rider) {
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.member = member;
        this.rider = rider; // Include in constructor if you typically set it at creation
    }


    // Getters and Setters (update them if needed to include rider)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }

    // NEW Getter and Setter for rider
    public Rider getRider() { return rider; }
    public void setRider(Rider rider) { this.rider = rider; }
}