package com.UdemyProjectDev.UdemyProjectDev.model;

import jakarta.persistence.*;

@Entity
public class Hour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // TODO : need to add time like this hh:00
    // private LocalTime time
    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "hour")
    private Event event;
}
