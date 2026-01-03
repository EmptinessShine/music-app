package kz.narxoz.musicapp.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "albums")
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}