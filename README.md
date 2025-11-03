# Demo REST API aplikace

Tento projekt je jednoduchá **Spring Boot aplikace v Kotlinu**, která pracuje s databází **PostgreSQL**.  
Aplikace po spuštění vystaví REST API endpointy `/hello` a `/notes`, naplní databázi daty pomocí **Flyway**,  
a umožní data zobrazit přes webový prohlížeč nebo terminál.

---

## 1. Spuštění databáze v Dockeru

Spusť PostgreSQL kontejner:

    bash
    docker run --name pg-demo -e POSTGRES_USER=demo -e POSTGRES_PASSWORD=demo -e POSTGRES_DB=demo_db -p 5432:5432 -d postgres:16


Ověř, že běží:

    bash
    docker ps

## 2. Spuštění aplikace

Ve složce projektu (kde je pom.xml) spusť:

    bash
    ./mvnw sping-boot:run

Aplikace se spustí na adrese *http://localhost:8080*

## 3. Jak aplikaci používat

**Endpoint /hello**

V prohlížeči otevři:

    bash
    http://localhost:8080/hello

Vrátí textový pozdrav a seznam uživatelů z databáze.


**Endpoint /notes**

V prohlížeči nebo v terminálu otevři:

    bash
    http://localhost:8080/notes

Vrátí seznam poznámek (JSON)

## 4. Spuštění testů

Spuštění všech testů:

    bash
    ./mvnw test

Spuštění pouze jednoho testu:

    ./mvnw -Dtest=DemoApplicationTests test

## 5. Zastavení a vyčištění prostředí

Zastavení databáze:

    bash
    docker stop pg-demo

Odstranění kontejneru:

    bash
    docker rm pg-demo

## 7. Struktura projektu

src/
 ├── main/kotlin/com/example/demo/
 │   ├── DemoApplication.kt
 │   ├── HelloController.kt
 │   ├── NotesController.kt
 │   ├── Note.kt / NoteRepository.kt
 │   ├── User.kt / UserRepository.kt
 │   └── db/migration/
 │       ├── V1__create_users.sql
 │       └── V2__create_notes.sql
 └── test/kotlin/com/example/demo/
     └── DemoApplicationTests.kt
