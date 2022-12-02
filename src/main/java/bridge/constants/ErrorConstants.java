package bridge.constants;

public enum ErrorConstants {
    SIZE_EXCEPTION("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    UPDOWN_ERROR("[ERROR] U와 D 중 입력해주세요."),
    RETRY_ERROR("[ERROR] R과 Q 중 입력해주세요.");
    private String exception;

    ErrorConstants(String exception) {
        this.exception = exception;
    }

    public void printException() {
        System.out.println(this.exception);
    }
}
