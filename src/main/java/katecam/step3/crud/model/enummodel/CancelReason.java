package katecam.step3.crud.model.enummodel;

public enum CancelReason {
    PATIENTCANCEL("피진료자취소"),
    MANAGERCANCEL("매니저취소"),
    NOKCANCEL("보호자취소"),
    CHANGEOFMIND("단순변심"),// 단순 변심
    SECHEDULEDREBOOK("재예약예정"),// 재예약 예정
    NONEMATCHED("매니저 매치 안됨");// 매니저 매치 안됨

    private final String krName;

    CancelReason(String krName) {
        this.krName = krName;
    }

    public String getKrName() {
        return krName;
    }
}
