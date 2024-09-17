package katecam.step3.crud.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import katecam.step3.crud.enumdomain.CancelReason;
import katecam.step3.crud.enumdomain.ReservationStatus;
import katecam.step3.crud.enumdomain.ServiceType;
import katecam.step3.crud.enumdomain.Transportation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // private Long UserId;

    // private Long ManagerId;

    @Column(name = "departure_location", nullable = false) // ERD 컬럼 이름 변경 요망
    private String departureLocation; // 출발지

    @Column(name = "arrival_location", nullable = false) // ERD 컬럼 이름 변경 요망
    private String arrivalLocation; // 도착지

    @Column(name = "reservation_date", nullable = false) // ERD 컬럼 이름 변경 요망
    private LocalDateTime reservationDateTime; // 예약일시

    @Column(name = "created_time", nullable = false) // ERD 컬럼 이름 변경 요망
    private LocalTime createdTime; // 생성시간

    @Column(name = "payment_status", nullable = false)
    private boolean paymentStatus; // 결제 상태

    @Column(name = "reservation_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ReservationStatus reservationStatus; // 예약 상태

    @Column(name = "cancel_reason")
    @Enumerated(value = EnumType.STRING)
    private CancelReason cancelReason; // 취소 사유

    @Column(name = "cancel_detail")
    private String cancelDetail; // 취소 세부 사유

    @Column(name = "creation_date")
    private LocalDateTime creationDate; // 생성일

    @Column(name = "service_type")
    @Enumerated(value = EnumType.STRING)
    private ServiceType serviceType; // 서비스 종류 (내시경검사, 외래 진료)

    @Column(name = "transportation")
    @Enumerated(value = EnumType.STRING)
    private Transportation transportation; // 이동 수단

    @Column(name = "price")
    private int price; // 비용

    @Column(name = "manager_status")
    private boolean mangerStatus; // 매니저 상태

    @OneToMany(mappedBy = "reservation")
    private List<Report> reports = new ArrayList<>(); // 리포트

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accompany_id", referencedColumnName = "id")
    private Accompany accompany; // 동행
}