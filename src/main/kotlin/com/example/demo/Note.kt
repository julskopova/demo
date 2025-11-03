package com.example.demo

import jakarta.persistence.*

@Entity
@Table(name = "notes")


data class Note (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var text: String = ""

)