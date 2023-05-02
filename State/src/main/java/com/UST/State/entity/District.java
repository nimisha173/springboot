package com.UST.State.entity;

import javax.persistence.*;

@Entity
@Table(name = "districts")
    public class District {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String state;

        // Constructors, getters, and setters
    }


