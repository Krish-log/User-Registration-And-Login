package UserRegistrationAndLogin.UserRegistrationAndLogin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import UserRegistrationAndLogin.UserRegistrationAndLogin.Model.User;
import UserRegistrationAndLogin.UserRegistrationAndLogin.Repositories.UserRepository;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@AutoConfigureTestDatabase(replace = Replace.ANY)
@Rollback(false)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("abc@gmail.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPassword("123456");
        user.setUsername("john.doe");
        
        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());

        assert(existUser.getEmail().equals(user.getEmail()));
    }
}
