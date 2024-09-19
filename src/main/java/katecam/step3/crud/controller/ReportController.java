package katecam.step3.crud.controller;

import jakarta.validation.Valid;
import katecam.step3.crud.domain.Report;
import katecam.step3.crud.dto.ApiDto;
import katecam.step3.crud.dto.ReportDto;
import katecam.step3.crud.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports/")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{reservation_id}")
    public ApiDto<Report> getReport(@PathVariable("reservation_id") Long reservationId) {
        return new ApiDto<>(reportService.getReport(reservationId), "리포트 조회를 성공했습니다",
            HttpStatus.OK);
    }

    @PostMapping("/{reservation_id}")
    public ApiDto<Report> createReport(@PathVariable("reservation_id") Long reservationId,
        @Valid @RequestBody ReportDto reportDto) {
        return new ApiDto<>(reportService.createReport(reservationId,reportDto), "리포트 생성이 완료되었습니다",
            HttpStatus.CREATED);
    }
}
