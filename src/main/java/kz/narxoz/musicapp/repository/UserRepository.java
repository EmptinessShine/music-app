package kz.narxoz.musicapp.repository;
import kz.narxoz.musicapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}