package com.example.tests;

public class FullDateBirthday {
    private final String byear;
    private final String bday;
    private final String bmonth;

    public FullDateBirthday(String byear, String bday, String bmonth) {
        this.byear = byear;
        this.bday = bday;
        this.bmonth = bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }
}
