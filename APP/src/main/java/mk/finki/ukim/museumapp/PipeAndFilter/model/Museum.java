package mk.finki.ukim.museumapp.PipeAndFilter.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


/**
 * @version 1.0
 * @apiNote This class represents a museum.
 * @implNote This implementation consists of the name, latitude, longitude, street, email, internetAccess, wikidata, openingHours, phone, fee, charge and website.
 * @since 1.0
 *
 */
@Data
@Entity
@Table(name = "Museums")
public
class Museum {
    public Museum() {

    }

    /**
     * @return String
     * @apiNote Returns a string representation of the object.
     * @implNote This implementation returns a string representation consisting of the name, latitude, longitude, street, email, internetAccess, wikidata, openingHours, phone, fee, charge and website.
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", street='" + street + '\'' +
                ", email='" + email + '\'' +
                ", internetAccess='" + internetAccess + '\'' +
                ", wikidata='" + wikidata + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", phone='" + phone + '\'' +
                ", fee='" + fee + '\'' +
                ", charge='" + charge + '\'' +
                ", website='" + website + '\'' +
                '}';
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * @Note This field represents the name of the museum.
     * @since 1.0
     * @implNote This implementation consists of the name. Collation is Macedonian_FYROM_90_CI_AS. Without this, the name is not displayed correctly, because of the Macedonian characters.
     */
    @Column(name = "name", columnDefinition = "VARCHAR(255) COLLATE Macedonian_FYROM_90_CI_AS")
    private String name;
    private double latitude;
    private double longitude;
    @Column(name = "street", columnDefinition = "VARCHAR(255) COLLATE Macedonian_FYROM_90_CI_AS")
    private String street;
    private String email;
    private String internetAccess;
    private String wikidata;
    private String openingHours;
    private String phone;
    private String fee;
    private String charge;
    private String website;
    @OneToMany(mappedBy = "museum", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Museum(
            String name,
            double latitude,
            double longitude,
            String street,
            String email,
            String internetAccess,
            String wikidata,
            String openingHours,
            String phone,
            String fee,
            String charge,
            String website
    ) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.email = email;
        this.internetAccess = internetAccess;
        this.wikidata = wikidata;
        this.openingHours = openingHours;
        this.phone = phone;
        this.fee = fee;
        this.charge = charge;
        this.website = website;
        //make id random
    }

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
    }

    public Long getId() {
        return (long) id;
    }
}
