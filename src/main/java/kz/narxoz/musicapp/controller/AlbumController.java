package kz.narxoz.musicapp.controller;

import kz.narxoz.musicapp.dto.AlbumDto;
import kz.narxoz.musicapp.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService service;

    @GetMapping
    public List<AlbumDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public AlbumDto create(@RequestBody AlbumDto dto) {
        return service.create(dto);
    }
}