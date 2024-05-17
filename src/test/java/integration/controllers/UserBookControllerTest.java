package integration.controllers;

import static io.restassured.RestAssured.*;

import com.example.bkshlf.BkshlfApplication;
import com.example.bkshlf.model.Book;
import com.example.bkshlf.model.Edition;
import com.example.bkshlf.model.User;
import com.example.bkshlf.repository.BookRepository;
import com.example.bkshlf.repository.UserBookRepository;
import com.example.bkshlf.repository.UserRepository;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = BkshlfApplication.class)
@ActiveProfiles("test")
@PropertySource("classpath:application.properties")
@TestPropertySource(locations="classpath:application.properties")
public class UserBookControllerTest
{
    private String baseUri = "http://localhost:8080";
    private String token;

    private final UserRepository userRepository;
    private final UserBookRepository userBookRepository;
    private final BookRepository bookRepository;

    @Autowired
    public UserBookControllerTest(UserRepository userRepository, BookRepository bookRepository, UserBookRepository userBookRepository)
    {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.userBookRepository = userBookRepository;
    }

    @BeforeEach
    public void setUp()
    {
//        userRepository.deleteAll();

//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode("password");
//
//        User user = new User();
//        user.setEmail("blackhole@example.com");
//        user.setPassword(encodedPassword);
//
//        userRepository.save(user);

        getToken();
    }

    @AfterEach
    public void tearDown()
    {
//        userRepository.deleteAll();
    }

    private void getToken()
    {
        String response = given()
                .contentType("application/json")
                .body("{\"email\": \"blackhole@example.com\", \"password\": \"password\"}")
                .when()
                .post(baseUri + "/auth")
                .then()
                .statusCode(200)
                .body("$", hasKey("accessToken"))
                .extract()
                .asString();
        JsonPath jsonPath = new JsonPath(response);
        token = jsonPath.getString("accessToken");
    }

    @DisplayName("A user can add a book to their library")
    @Test
    public void testUserCanAddBookToPersonalLibrary()
    {
        Book book = bookRepository.findByTitle("Jurassic Park");
        Edition edition = book.getEditions().stream().findFirst().get();

        given()
            .baseUri(baseUri)
            .contentType("application/json")
            .header("Authorization", "Bearer " + token)
            .when()
                .post("/users/books/" + book.getId() + "/editions/" + edition.getId())
            .then()
                .statusCode(200);
    }
}
