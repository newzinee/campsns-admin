package com.campfour.domain;

import lombok.Getter;

@Getter
public enum CampTheme {

    SEA("바다", 1, BigType.NATURE),
    MOUNTAIN("산", 2, BigType.NATURE),

    FAMILY("가족", 1, BigType.PEOPLE),
    COUPLE("연인", 2, BigType.PEOPLE),

    OFTEN("종종", 1, BigType.FREQUENCY),
    SOMETIME("가끔", 2, BigType.FREQUENCY);


    private String value;
    private int code;
    private BigType bigType;
    CampTheme(String value, int code, BigType bigType) {
        this.value = value;
        this.code = code;
        this.bigType = bigType;
    }

    public String getValue() { return value; }
    public String getCode() { return bigType.code+code; }

    enum BigType {
        NATURE("자연","n"),
        PEOPLE("사람", "p"),
        FREQUENCY("빈도", "f"),
        ETC("기타", "e");

        private String value;
        private String code;

        BigType(String value, String code) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {return value;}
        public String getCode() {return code;}
    }
}
