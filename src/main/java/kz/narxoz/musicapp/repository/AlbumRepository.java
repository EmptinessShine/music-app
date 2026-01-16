package kz.narxoz.musicapp.repository;

import kz.narxoz.musicapp.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}