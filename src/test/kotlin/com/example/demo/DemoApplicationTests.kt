package com.example.demo

import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests (
    @Autowired private val noteRepository: NoteRepository,
    @Autowired private val rest: TestRestTemplate,
    @LocalServerPort private val port: Int
) : FunSpec({

    beforeTest {
        noteRepository.deleteAll()
    }

    test("GET /notes returns two items") {
        noteRepository.saveAll(listOf(
            Note(text = "First"),
            Note(text = "Second")
        ))

        val url = "http://localhost:$port/notes"
        val body = rest.getForEntity(url, Array<NoteDto>::class.java).body!!

        body.shouldHaveSize(2)
        body.map { it.text }.toSet() shouldBe setOf("First", "Second")
    }
}) {
    override fun extensions() = listOf(SpringExtension)
}

