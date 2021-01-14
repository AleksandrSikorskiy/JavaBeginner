package org.example;

import java.lang.String;

public class Gseawar {

    private static final String PUSTO = "0";
    private static final String SHIP = "1";
    private static final String POPAL = "X";
    private static final String MIMO = ".";
    public static final String SPACE = " ";
    public static final String STRINGDELIMITER = " | ";
    public static final String EMPTY_LINE = "";
    private final int quadSize;
    boolean pobeda = true;

    String[] warmapmyfire;
    String[] warmapvs;
    String[] warmapmy;
    String[] arrfillmap = {PUSTO, SHIP}; //0-пусто 1-корабль
    String arrxindex = "0123456789";
    String[] arryindex = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public Gseawar(int quadSize) {
        this.quadSize = quadSize;
        warmapmyfire = new String[quadSize];
        warmapvs = new String[quadSize];
        warmapmy = new String[quadSize];
    }

    // индекс символа в массиве
    int checkarrindex(int numchar, String searchstr, String[] arrindex) {
        int res = 99;
        String poiskstr = searchstr.substring(numchar, numchar + 1);

        int lenarrindex = arrindex.length;
        for (int i = 0; i < lenarrindex; i++) {
            if (arryindex[i].equals(poiskstr)) {
                res = i;
            }
        }
        return res;
    }

    void checkpobeda() { //если на поле боя остался хоть 1-н корабль ни кто не победил
        boolean mypobeda = true;
        boolean vspobeda = true;
        for (int i = 0; i < quadSize; i++) {
            if (warmapvs[i].contains(SHIP)) {
                mypobeda = false;
            }
            if (warmapmy[i].contains(SHIP)) {
                vspobeda = false;
            }
        }
        if (mypobeda) {
            pobeda = true;
            System.out.println("Вы победили");
        }
        if (vspobeda) {
            pobeda = true;
            System.out.println("Компьютер победил");
        }
    }

    void newgame() { //создаем пустое поле выстрелов и поля боя моё и противника
        for (int i = 0; i < quadSize; i++) {
            String strxmapvs = EMPTY_LINE;
            String strxmapmy = EMPTY_LINE;
            for (int j = 0; j < quadSize; j++) {
                //   strxmapvs = strxmapvs.concat(arrfillmap[(int) (Math.random() * 2)].trim());
                strxmapvs = strxmapvs.concat(arrfillmap[Random.randomize(0, 1)].trim());
                //    strxmapmy = strxmapmy.concat(arrfillmap[(int) (Math.random() * 2)].trim());
                strxmapmy = strxmapmy.concat(arrfillmap[Random.randomize(0, 1)].trim());
            }
            warmapvs[i] = strxmapvs;
            warmapmyfire[i] = "0000000";
            warmapmy[i] = strxmapmy;
        }
    }

    //  вывод карты выстелов и попаданий компютера
    void printallmap() {
        System.out.println("поле компа| моё поле боя");
        for (int i = 0; i < quadSize; i++) {
            System.out.println(arryindex[i] + SPACE + warmapmyfire[i] + STRINGDELIMITER + warmapmy[i]);
        }
        System.out.println("  " + arrxindex.substring(0, quadSize) + STRINGDELIMITER + arrxindex.substring(0, quadSize));
    }

    void fireonmapmy(String buf) {
        //определяем координаты из строки выстрела типа "A2"
        int y = checkarrindex(0, buf, arryindex);
        int x = arrxindex.indexOf(buf.substring(1, 2));
        //определяем попал ли я в корабль или промазал и делаем пометку выстрелов на картах боя
        if ((x < quadSize) && (y < quadSize)) {
            String si = warmapvs[y].substring(x, x + 1);
            if (si.equals(PUSTO)) { //моя карта выстрелов
                StringBuilder changeCh1 = new StringBuilder(warmapmyfire[y]);
                changeCh1.replace(x, x + 1, MIMO);
                warmapmyfire[y] = changeCh1.toString();
                System.out.println("Мимо");
            }
            if (si.equals(SHIP)) { //моя карта выстрелов и невидимая карта противника
                StringBuilder changeCh2 = new StringBuilder(warmapmyfire[y]);
                changeCh2.replace(x, x + 1, POPAL);
                warmapmyfire[y] = changeCh2.toString();
                StringBuilder changeCh3 = new StringBuilder(warmapvs[y]);
                changeCh3.replace(x, x + 1, POPAL);
                warmapvs[y] = changeCh3.toString();
                System.out.println("Попал");
            }

        } else {
            System.out.println("Вы выстрелили за поле боя");
        }
    }

    void fireonmapvs() {
        //генерируем случайный выстрел без проверки стрелял ли компьютер туда уже
        String buf = EMPTY_LINE;
        buf = buf.concat(arryindex[Random.randomize(0, quadSize)]);
        int rand = Random.randomize(0, quadSize);
        buf = buf.concat(arrxindex.substring(rand, rand + 1));

        System.out.println("Противник стреляет " + buf);
        //узнаем координаты выстрела коппьютера

        int x = checkarrindex(0, buf, arryindex); //quadsize;
        int y = arrxindex.indexOf(buf.substring(1, 2)); //quadsize;
        //определяем попал компьютер или нет
        if ((x < quadSize) && (y < quadSize)) {
            String si = warmapmy[x].substring(y, y + 1);

            if (PUSTO.equals(si)) {
                warmapmy[x] = warmapmy[x].substring(0, y) + MIMO + warmapmy[x].substring(y + 1);
                System.out.println("противник промазал " + buf);
            }
            if (SHIP.equals(si)) {
                warmapmy[x] = warmapmy[x].substring(0, y) + POPAL + warmapmyfire[x].substring(y + 1);
                System.out.println("противник попал " + buf);
            }
        } else {
            System.out.println("Компьютер выстрелил за поле боя" + buf);
        }
    }
}


