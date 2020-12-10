package org.example;

/**
 * Hello world!
 */

import java.lang.String;
import java.util.Scanner;

class Tseawar {
    boolean pobeda = true;
    String[] poles = new String[7];
    String[] poleg = new String[7];
    String[] polem = new String[7];
    String[] arrc = {"0", "1"};
    String[] arrf = {"0", "1", "2", "3", "4", "5", "6"};
    String[] arrw = {"A", "B", "C", "D", "E", "F", "G"};

    void check() {
        int z = 0;
        int y = 0;
        for (int i = 0; i < 7; i++) {
            if (poleg[i].contains("1")) {
                z = z + 1;
            }
            if (polem[i].contains("1")) {
                y = y + 1;
            }
        }
        if ((z == 0) | (y == 0)) {
            if (z == 0) {
                System.out.println("Вы победили");
            }
            if (y == 0) {
                System.out.println("Компьютер победил");
            }
            pobeda = false;
        }
    }

    void newgame() {
        String sss = "";
        String sss2 = "";
        String s1 = "";
        String s2 = "";

        int rand = 0;
        for (int i = 0; i < 7; i++) {
            s1 = "";
            s2 = "";
            for (int j = 0; j < 7; j++) {
                rand = (int) (Math.random() * 2);
                sss = arrc[rand];
                s1 = s1 + sss.trim();
                poles[i] = "0000000";
                rand = (int) (Math.random() * 2);
                sss2 = arrc[rand];
                s2 = s2 + sss2.trim();
            }
            poleg[i] = s1;
            poles[i] = "0000000";
            polem[i] = s2;
        }
    }

    void print() {
        System.out.println("поле компа| моё поле боя");
        for (int i = 0; i < 7; i++) {
            int a = i + 65;
            char b = (char) a;
            System.out.println(b + " " + poles[i] + " | " + polem[i]);
        }
        System.out.println("  0123456 | 0123456");
    }

    void set(String buf) {
        int x = 15;
        int y = 15;
        if (buf.contains("A")) {
            x = 0;
        }
        if (buf.contains("B")) {
            x = 1;
        }
        if (buf.contains("C")) {
            x = 2;
        }
        if (buf.contains("D")) {
            x = 3;
        }
        if (buf.contains("E")) {
            x = 4;
        }
        if (buf.contains("F")) {
            x = 5;
        }
        if (buf.contains("G")) {
            x = 6;
        }
        if (buf.contains("0")) {
            y = 0;
        }
        if (buf.contains("1")) {
            y = 1;
        }
        if (buf.contains("2")) {
            y = 2;
        }
        if (buf.contains("3")) {
            y = 3;
        }
        if (buf.contains("4")) {
            y = 4;
        }
        if (buf.contains("5")) {
            y = 5;
        }
        if (buf.contains("6")) {
            y = 6;
        }
        if ((x < 15) && (y < 15)) {
            String si = poleg[x].substring(y, y + 1);
            if (si.equals("0")) {
                poles[x] = poles[x].substring(0, y) + "." + poles[x].substring(y + 1);
                System.out.println("Мимо");
            }
            if (si.equals("1")) {
                poles[x] = poles[x].substring(0, y) + "X" + poles[x].substring(y + 1);
                poleg[x] = poleg[x].substring(0, y) + "0" + poleg[x].substring(y + 1);
                System.out.println("Попал");
            }

        } else {
            System.out.println("Вы выстрелили за поле боя");
        }
    }

    void setm() {
        String buf = "";
        String s1;
        String s2;
        int rand = 0;
        rand = (int) (Math.random() * 7);
        s1 = arrw[rand];
        rand = (int) (Math.random() * 7);
        s2 = arrf[rand];
        buf = s1 + s2;
        System.out.println("Противник стреляет " + buf);
        int x = 15;
        int y = 15;
        if (buf.contains("A")) {
            x = 0;
        }
        if (buf.contains("B")) {
            x = 1;
        }
        if (buf.contains("C")) {
            x = 2;
        }
        if (buf.contains("D")) {
            x = 3;
        }
        if (buf.contains("E")) {
            x = 4;
        }
        if (buf.contains("F")) {
            x = 5;
        }
        if (buf.contains("G")) {
            x = 6;
        }
        if (buf.contains("0")) {
            y = 0;
        }
        if (buf.contains("1")) {
            y = 1;
        }
        if (buf.contains("2")) {
            y = 2;
        }
        if (buf.contains("3")) {
            y = 3;
        }
        if (buf.contains("4")) {
            y = 4;
        }
        if (buf.contains("5")) {
            y = 5;
        }
        if (buf.contains("6")) {
            y = 6;
        }
        if ((x < 15) && (y < 15)) {
            String si = polem[x].substring(y, y + 1);
            if (si.equals("0")) {
                polem[x] = polem[x].substring(0, y) + "." + polem[x].substring(y + 1);
                System.out.println("противник промазал " + buf);
            }
            if (si.equals("1")) {
                polem[x] = polem[x].substring(0, y) + "X" + poles[x].substring(y + 1);
                System.out.println("противник попал " + buf);
            }

        } else {
            System.out.println("Компьютер выстрелил за поле боя" + buf);
        }
    }
}


public class App {
    public static void main(String[] args) {
        Tseawar seawar = new Tseawar();
        seawar.newgame();
        seawar.print();
        while (seawar.pobeda) {
            Scanner ids = new Scanner(System.in);
            System.out.print("Куда стреляем: ");
            String id = ids.nextLine();
            seawar.set(id);
            seawar.setm();
            seawar.print();
            seawar.check();
        }
    }
}
