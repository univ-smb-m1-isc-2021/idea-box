package com.example.ideabox.Campaign;

import com.example.ideabox.User.User;

import javax.persistence.*;

@Entity
@Table(name = "Campaigns")
public class Campaign {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @ManyToOne
    private User user;
}