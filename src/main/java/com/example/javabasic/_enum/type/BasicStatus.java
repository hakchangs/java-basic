package com.example.javabasic._enum.type;

public enum BasicStatus {

    PREPARED("00", "준비됨"),
    RUNNING("10", "진행중"),
    COMPLETED("20", "완료"),
    FAILED("99", "실패");

    private final String code;
    private final String description;

    //private 생성자로 고정
    BasicStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public boolean isGreaterThan(BasicStatus status) {
        int code = Integer.parseInt(status.code);
        int thisCode = Integer.parseInt(this.code);
        return thisCode > code;
    }

    public boolean isLessThan(BasicStatus status) {
        int code = Integer.parseInt(status.code);
        int thisCode = Integer.parseInt(this.code);
        return thisCode < code;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
