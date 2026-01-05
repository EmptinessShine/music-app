package kz.narxoz.musicapp.mapper;
import kz.narxoz.musicapp.dto.ArtistDto;
import kz.narxoz.musicapp.model.Artist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    ArtistDto toDto(Artist artist);
    Artist toEntity(ArtistDto dto);
}
