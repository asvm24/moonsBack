package com.UdemyProjectDev.UdemyProjectDev.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "day")
    private List<Hour> hours;
}
