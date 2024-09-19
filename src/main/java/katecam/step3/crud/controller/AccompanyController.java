package katecam.step3.crud.controller;

import jakarta.validation.Valid;
import java.util.List;
import katecam.step3.crud.domain.Accompany;
import katecam.step3.crud.dto.AccompanyDto;
import katecam.step3.crud.dto.ApiDto;
import katecam.step3.crud.service.AccompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tracking")
public class AccompanyController {

    private final AccompanyService accompanyService;

    public AccompanyController(AccompanyService accompanyService) {
        this.accompanyService = accompanyService;
    }

    @GetMapping("/{reservation_id}")
    public ApiDto<List<Accompany>> getTracking(@PathVariable(name = "reservation_id") Long reservationId) {
        return new ApiDto<>(accompanyService.getTrackingAccompanies(reservationId),"성공", HttpStatus.OK);
    }

    @PostMapping("/{reservation_id}")
    public ApiDto<Accompany> postTracking(@PathVariable(name = "reservation_id") Long reservationId,
        @Valid
        AccompanyDto accompanyDto) {
        return new ApiDto<>(accompanyService.getTrackingAccompany(reservationId, accompanyDto),
            "성공", HttpStatus.CREATED);
    }
}
