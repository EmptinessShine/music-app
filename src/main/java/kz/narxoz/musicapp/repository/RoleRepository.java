package kz.narxoz.musicapp.repository;
import kz.narxoz.musicapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}