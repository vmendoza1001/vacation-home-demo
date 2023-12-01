package com.example.vacationhomedemo.model;

import com.example.vacationhomedemo.security.model.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="reservation")

public class Reservation {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number_of_guests")
    private int numberOfGuests;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

   // @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
   // @JoinColumn(name="user_id")
   // private User user;


    // define constructors
    public Reservation() {
    }

    public Reservation(int numberOfGuests, LocalDate startDate, LocalDate endDate) {
        this.numberOfGuests = numberOfGuests;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  /*  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
*/
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // define toString


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", numberOfGuests=" + numberOfGuests +
                ", startDate=" + startDate +
                ", endDate=" + endDate +'}';
    }
}