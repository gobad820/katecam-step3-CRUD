package katecam.step3.crud.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import katecam.step3.crud.enumdomain.MealTime;
import katecam.step3.crud.enumdomain.TimeInterval;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @OneToMany(mappedBy = "report")
    private List<TimeOfDays> timeOfDays = new ArrayList<>();

    @Column(name = "doctor_summary")
    private String doctorSummary;

    @Column(name = "frequency")
    private int frequency;

    @Column(name = "meal_time")
    private MealTime mealTime;

    @Column(name = "time_interval")
    @Enumerated(value = EnumType.STRING)
    private TimeInterval timeInterval;
}