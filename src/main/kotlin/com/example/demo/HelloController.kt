package com.example.demo


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val userRepository: UserRepository
) {
    @GetMapping("/hello")
    fun hello(): String {
        val users = userRepository.findAll()
        if (users.isEmpty()) {
            return "Ahoj! V databázi zatím nejsou žádní uživatelé."
        }
        val names = users.joinToString { "${it.name} ${it.surname}" }
        return "Ahoj! V databázi mám ${users.size} uživatele: $names"
    }
}


