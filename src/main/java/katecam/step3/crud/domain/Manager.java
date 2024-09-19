package katecam.step3.crud.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "managers")
public class Manager extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name",length = 50, nullable = false)
    private String name;

    @Column(name = "profile_image", nullable = false)
    private String profileImage;

    @Column(name = "carrer", nullable = false, length = 256)
    private String carrer;

    @Column(name = "comment", nullable = false,length = 256)
    private String comment;

    @Column(name = "working_region", nullable = false,length = 256)
    private String workingRegion;

    @OneToMany(mappedBy = "manager")
    private List<Reservation> reservations = new ArrayList<>();
}