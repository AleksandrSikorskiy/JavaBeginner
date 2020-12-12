package org.example;

import java.lang.String;

 public class Gseawar {
        int quadsize=7;
        boolean pobeda = true;
        String[] warmapmyfire = new String[quadsize];
        String[] warmapvs = new String[quadsize];
        String[] warmapmy = new String[quadsize];
        String[] arrfillmap = {"0", "1"}; //0-пусто 1-корабль
        String arrxindex = "0123456789";
        String[] arryindex = {"A", "B", "C", "D", "E", "F", "G","H","I","J"};

        int checkarrindex(int numchar,String searchstr,String[] arrindex){
            int res=99;
            String poiskstr=searchstr.substring(numchar,numchar + 1);

            int lenarrindex=arrindex.length;
            for (int i=0;i<lenarrindex;i++){
                if (arryindex[i].equals(poiskstr)) {
                    res=i;
                }
            }
            return res;
        }

        void checkpobeda() { //если на поле боя остался хоть 1-н корабль ни кто не победил
            boolean mypobeda=true;
            boolean vspobeda=true;
            for (int i = 0; i < quadsize; i++) {
                if (warmapvs[i].contains("1")) {
                    mypobeda=false;
                }
                if (warmapmy[i].contains("1")) {
                    vspobeda=false;
                }
            }
            if (mypobeda) {pobeda=true;System.out.println("Вы победили"); }
            if (vspobeda) {pobeda=true;System.out.println("Компьютер победил");}
        }

        void newgame() { //создаем пустое поле выстрелов и поля боя моё и противника
            for (int i = 0; i < quadsize; i++) {
                String strxmapvs = "";
                String strxmapmy = "";
                for (int j = 0; j < quadsize; j++) {
                                                                                                        //   strxmapvs = strxmapvs.concat(arrfillmap[(int) (Math.random() * 2)].trim());
                    strxmapvs = strxmapvs.concat(arrfillmap[getRandomInRange.generation(0,1)].trim());
                                                                                                        //    strxmapmy = strxmapmy.concat(arrfillmap[(int) (Math.random() * 2)].trim());
                    strxmapmy = strxmapmy.concat(arrfillmap[getRandomInRange.generation(0,1)].trim());
                }
                warmapvs[i] = strxmapvs;
                warmapmyfire[i] = "0000000";
                warmapmy[i] = strxmapmy;
            }
        }

        void printallmap() {
            System.out.println("поле компа| моё поле боя");
            for (int i = 0; i < quadsize; i++) {
                int a = i + 65;
                char b = (char) a;
                System.out.println(b + " " + warmapmyfire[i] + " | " + warmapmy[i]);

            }
            System.out.println("  0123456 | 0123456");
        }

        void fireonmapmy(String buf) {
            //определяем координаты из строки выстрела типа "A2"
            int y = checkarrindex(0,buf,arryindex);
            int x = arrxindex.indexOf(buf.substring(1,2));
            //определяем попал ли я в корабль или промазал и делаем пометку выстрелов на картах боя
            if ((x < quadsize) && (y < quadsize)) {
                String si = warmapvs[y].substring(x, x + 1);
                if (si.equals("0")) { //моя карта выстрелов
                    StringBuilder changeCh1 = new StringBuilder(warmapmyfire[y]);
                    changeCh1.setCharAt(x, '.');
                    warmapmyfire[y]= changeCh1.toString();
                    System.out.println("Мимо");
                }
                if (si.equals("1")) { //моя карта выстрелов и невидимая карта противника
                    StringBuilder changeCh2 = new StringBuilder(warmapmyfire[y]);
                    changeCh2.setCharAt(x, 'X');
                    warmapmyfire[y]= changeCh2.toString();
                    StringBuilder changeCh3 = new StringBuilder(warmapvs[y]);
                    changeCh3.setCharAt(x, 'X');
                    warmapvs[y]= changeCh3.toString();
                    System.out.println("Попал");
                }

            } else {
                System.out.println("Вы выстрелили за поле боя");
            }
        }

        void fireonmapvs() {
            //генерируем случайный выстрел без проверки стрелял ли компьютер туда уже
            String buf="";
            buf=buf.concat(arryindex[getRandomInRange.generation(0,quadsize)]);
            int rand=getRandomInRange.generation(0,quadsize);
            buf=buf.concat(arrxindex.substring(rand,rand+1));

            System.out.println("Противник стреляет " + buf);
            //узнаем координаты выстрела коппьютера

            int x = checkarrindex(0,buf,arryindex); //quadsize;
            int y = arrxindex.indexOf(buf.substring(1,2)); //quadsize;
            //определяем попал компьютер или нет
            if ((x < quadsize) && (y < quadsize)) {
                String si = warmapmy[x].substring(y, y + 1);
                if (si.equals("0")) {
                    warmapmy[x] = warmapmy[x].substring(0, y) + "." + warmapmy[x].substring(y + 1);
                    System.out.println("противник промазал " + buf);
                }
                if (si.equals("1")) {
                    warmapmy[x] = warmapmy[x].substring(0, y) + "X" + warmapmyfire[x].substring(y + 1);
                    System.out.println("противник попал " + buf);
                }

            } else {
                System.out.println("Компьютер выстрелил за поле боя" + buf);
            }
        }
 }


