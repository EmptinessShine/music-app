package kz.narxoz.musicapp.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "artists")
@Data
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Album> albums;
}