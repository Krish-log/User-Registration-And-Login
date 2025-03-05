package UserRegistrationAndLogin.UserRegistrationAndLogin;

import UserRegistrationAndLogin.UserRegistrationAndLogin.Model.User;
import UserRegistrationAndLogin.UserRegistrationAndLogin.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // Initializes only JPA-related beans
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User();
        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isNotNull();
    }
}
