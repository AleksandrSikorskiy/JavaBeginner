package org.example;

public class Stroka {
    private final String str;
    private int kol;

    public Stroka(String str, int kol) {
        this.str = str;
        this.kol = kol;
    }

    public String getStr() {
        return str;
    }

    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    }
}
