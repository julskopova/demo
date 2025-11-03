package com.example.demo

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var surname: String = "",

    @Column(name = "rodne_cislo", nullable = false, unique = true)
    var rodneCislo: String = ""
)
