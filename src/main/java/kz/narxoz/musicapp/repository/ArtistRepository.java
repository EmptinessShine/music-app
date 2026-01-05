package kz.narxoz.musicapp.repository;
import kz.narxoz.musicapp.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ArtistRepository extends JpaRepository<Artist, Long> {}