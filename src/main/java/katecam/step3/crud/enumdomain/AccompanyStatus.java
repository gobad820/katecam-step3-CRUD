package katecam.step3.crud.enumdomain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccompanyStatus {
    TO_HOSPITAL("병원 이동"),
    IN_CLINIC("진료 중"),
    MEDICINE("약국"),
    TO_HOME("귀가중");

    private final String krName;
}
