package kz.narxoz.musicapp.service;
import kz.narxoz.musicapp.dto.ArtistDto;
import kz.narxoz.musicapp.mapper.ArtistMapper;
import kz.narxoz.musicapp.model.Artist;
import kz.narxoz.musicapp.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository repository;
    private final ArtistMapper mapper;

    public List<ArtistDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public ArtistDto create(ArtistDto dto) {
        Artist artist = mapper.toEntity(dto);
        return mapper.toDto(repository.save(artist));
    }
}