package kz.narxoz.musicapp.service;

import kz.narxoz.musicapp.dto.ArtistDto;
import kz.narxoz.musicapp.mapper.ArtistMapper;
import kz.narxoz.musicapp.model.Artist;
import kz.narxoz.musicapp.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository repository;
    private final ArtistMapper mapper;

    public List<ArtistDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public ArtistDto getById(Long id) {
        Artist artist = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
        return mapper.toDto(artist);
    }

    public ArtistDto create(ArtistDto dto) {
        Artist artist = mapper.toEntity(dto);
        return mapper.toDto(repository.save(artist));
    }

    public ArtistDto update(Long id, ArtistDto dto) {
        Artist artist = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));

        artist.setName(dto.getName());
        artist.setGenre(dto.getGenre());

        return mapper.toDto(repository.save(artist));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}