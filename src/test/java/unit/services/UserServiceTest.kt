package unit.services

import com.example.bkshlf.model.User
import com.example.bkshlf.repository.UserRepository
import com.example.bkshlf.service.UserService
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.core.spec.style.ShouldSpec
import io.mockk.every
import io.mockk.mockk
import net.datafaker.Faker
import org.junit.jupiter.api.Assertions
import java.util.*
import kotlin.test.assertEquals

class UserServiceTest: ShouldSpec
({
    should("find a user by email")
    {
        val faker = Faker()
        val fakeEmail: String = faker.internet().emailAddress()

        val mockUser: User = User()
        mockUser.id = 1L
        mockUser.email = fakeEmail

        val userRepository = mockk<UserRepository>()
        every { userRepository.findByEmail(fakeEmail) } returns Optional.of(mockUser)

        val userService = UserService(userRepository)

        val user: User? = userService.findUser(fakeEmail)
        Assertions.assertNotNull(user)
        if (user != null) {
            assertEquals(mockUser.email, user.email)
        }
    }
})