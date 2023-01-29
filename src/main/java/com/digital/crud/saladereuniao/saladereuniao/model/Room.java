package com.digital.crud.saladereuniao.saladereuniao.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "meetingroom")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private OffsetDateTime date;
    @Column(nullable = false)
    private OffsetDateTime startHour;
    @Column(nullable = false)
    private OffsetDateTime endHour;
}
