package kz.narxoz.musicapp.repository;
import kz.narxoz.musicapp.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired private UserRepository userRepository;

    @Test
    void testSaveAndFind() {
        User user = new User();
        user.setUsername("student");
        user.setPassword("123");
        userRepository.save(user);

        User found = userRepository.findByUsername("student");
        Assertions.assertNotNull(found);
        Assertions.assertEquals("student", found.getUsername());
    }
}