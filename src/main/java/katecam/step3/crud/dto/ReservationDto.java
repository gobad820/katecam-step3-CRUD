package katecam.step3.crud.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import katecam.step3.crud.enumdomain.ServiceType;
import katecam.step3.crud.enumdomain.Transportation;

/**
 * DTO for {@link katecam.step3.crud.domain.Reservation}
 */
public record ReservationDto(String departureLocation, String arrivalLocation,
                             LocalDateTime reservationDateTime, ServiceType serviceType,
                             Transportation transportation, int price) implements
    Serializable {

}