package kz.narxoz.musicapp.mapper;

import kz.narxoz.musicapp.dto.AlbumDto;
import kz.narxoz.musicapp.model.Album;
import kz.narxoz.musicapp.model.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    @Mapping(source = "artist.id", target = "artistId")
    AlbumDto toDto(Album album);

    @Mapping(source = "artistId", target = "artist")
    Album toEntity(AlbumDto dto);

    List<AlbumDto> toDtoList(List<Album> albums);

    default Artist map(Long id) {
        if (id == null) return null;
        Artist artist = new Artist();
        artist.setId(id);
        return artist;
    }
}