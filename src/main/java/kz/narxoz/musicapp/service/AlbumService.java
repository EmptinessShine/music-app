package kz.narxoz.musicapp.service;

import kz.narxoz.musicapp.dto.AlbumDto;
import kz.narxoz.musicapp.mapper.AlbumMapper;
import kz.narxoz.musicapp.model.Album;
import kz.narxoz.musicapp.model.Artist;
import kz.narxoz.musicapp.repository.AlbumRepository;
import kz.narxoz.musicapp.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final AlbumMapper albumMapper;

    public List<AlbumDto> getAll() {
        return albumMapper.toDtoList(albumRepository.findAll());
    }


    public AlbumDto create(AlbumDto dto) {
        Artist artist = artistRepository.findById(dto.getArtistId())
                .orElseThrow(() -> new RuntimeException("Artist not found with id: " + dto.getArtistId()));

        Album album = albumMapper.toEntity(dto);
        album.setArtist(artist);

        return albumMapper.toDto(albumRepository.save(album));
    }
}