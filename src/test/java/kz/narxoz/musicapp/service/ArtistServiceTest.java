package kz.narxoz.musicapp.service;
import kz.narxoz.musicapp.dto.ArtistDto;
import kz.narxoz.musicapp.model.Artist;
import kz.narxoz.musicapp.repository.ArtistRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
class ArtistServiceTest {
    @Autowired private ArtistService artistService;
    @Autowired private ArtistRepository artistRepository;

    @BeforeEach
    void setUp() { artistRepository.deleteAll(); }

    @Test
    void testCreateArtist() {
        ArtistDto dto = new ArtistDto();
        dto.setName("Dimash");
        ArtistDto result = artistService.create(dto);

        Assertions.assertNotNull(result.getId());
        List<Artist> db = artistRepository.findAll();
        Assertions.assertEquals(1, db.size());
        Assertions.assertEquals("Dimash", db.get(0).getName());
    }
}