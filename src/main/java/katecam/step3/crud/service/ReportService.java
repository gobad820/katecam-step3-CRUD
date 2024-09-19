package katecam.step3.crud.service;

import katecam.step3.crud.domain.Report;
import katecam.step3.crud.domain.Reservation;
import katecam.step3.crud.dto.ReportDto;
import katecam.step3.crud.repository.ReportRepository;
import katecam.step3.crud.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Slf4j
public class ReportService {

    private final ReportRepository reportRepository;
    private final ReservationRepository reservationRepository;

    public ReportService(ReportRepository reportRepository,
        ReservationRepository reservationRepository) {
        this.reportRepository = reportRepository;
        this.reservationRepository = reservationRepository;
    }

    // 리포트 조회
    public Report getReport(Long reservationId) {
        Reservation completedReservation = reservationRepository.findById(reservationId)
            .orElseThrow(IllegalArgumentException::new);
        Report report = reportRepository.findByReservation(
            completedReservation).orElseThrow(IllegalArgumentException::new);
        if(completedReservation.getReports().getLast() == report) {
            return report;
        }
        return completedReservation.getReports().getLast();
    }

    // 환자 결과 리포트 생성
    public Report createReport(Long reservationId, ReportDto reportDto) {
        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(IllegalArgumentException::new);
        Report report = Report.builder().
            doctorSummary(reportDto.doctorSummary())
            .frequency(reportDto.frequency())
            .mealTime(reportDto.mealTime())
            .timeOfDay(reportDto.timeOfDays())
            .build();
        reservation.getReports().add(report);
        reservationRepository.save(reservation);
        return report;
    }

}
