package mk.finki.ukim.museumapp.PipeAndFilter.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;


/**
 * @version 1.0
 * @apiNote This class represents a museum.
 * @implNote This implementation consists of the name, latitude, longitude, street, email, internetAccess, wikidata, openingHours, phone, fee, charge and website.
 * @since 1.0
 */
@Data
@Entity
@Table(name = "Reviews")
public class Review {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "review",columnDefinition="VARCHAR(255) COLLATE Macedonian_FYROM_90_CI_AS")
    private String review;
    private String username;
    private int stars;

    @ManyToOne
    @JoinColumn(name = "museum_id")
    private Museum museum;

    public Review() {

    }

    public Review(String review, String username, int stars) {
        this.review = review;
        this.username = username;
        this.stars = stars;
    }

    public Review(String review, String username, int stars, Museum museum) {
        this.review = review;
        this.username = username;
        this.stars = stars;
        this.museum = museum;
    }
}
