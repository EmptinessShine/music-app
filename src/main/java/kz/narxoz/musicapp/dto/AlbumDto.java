package kz.narxoz.musicapp.dto;

import lombok.Data;

@Data
public class AlbumDto {
    private Long id;
    private String title;
    private Integer year;
    private Long artistId; // Самое важное поле: ID артиста, чей это альбом
}