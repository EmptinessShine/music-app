package kz.narxoz.musicapp.controller;
import kz.narxoz.musicapp.dto.ArtistDto;
import kz.narxoz.musicapp.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/artists")
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistService service;

    @GetMapping
    public List<ArtistDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ArtistDto create(@RequestBody ArtistDto dto) {
        return service.create(dto);
    }
}