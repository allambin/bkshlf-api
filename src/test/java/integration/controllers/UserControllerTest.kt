package integration.controllers

import com.example.bkshlf.model.User
import com.example.bkshlf.repository.UserRepository
import com.example.bkshlf.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.koin.KoinExtension
import io.kotest.koin.KoinLifecycleMode
import io.restassured.RestAssured
import net.datafaker.Faker
import org.junit.jupiter.api.Assertions
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.inject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.koin.test.KoinTest
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import kotlin.test.assertEquals

@SpringBootTest(classes = [com.example.bkshlf.BkshlfApplication::class]) // Kotlin syntax!
@ExtendWith(SpringExtension::class)
class UserControllerTest
{
    val baseUri = "http://localhost:8080"

    @Autowired
    private lateinit var userService: UserService

    @Test
    fun registerUser()
    {
        data class RegisterUserRequest(
            val email: String,
            val password: String
        )

        val faker = Faker()
        val fakeEmail: String = faker.internet().emailAddress()

        val registerUserRequest = RegisterUserRequest(fakeEmail, "password")

        // Serialize the data class to a JSON string using Jackson
        val objectMapper = ObjectMapper()
        val requestBody = objectMapper.writeValueAsString(registerUserRequest)

        RestAssured.given()
            .baseUri(baseUri)
            .contentType("application/json")
            .body(requestBody) // improve this with jackson
            .`when`()
            .post("/users/register")
            .then()
            .statusCode(200)

        val user: User? = userService.findUser(fakeEmail)
        Assertions.assertNotNull(user)
        if (user != null) {
            assertEquals(fakeEmail, user.email)
            userService.deleteUser(user.id);
        }
    }

}