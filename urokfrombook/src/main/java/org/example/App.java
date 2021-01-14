package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


class NameClass {

    private static final String[][] nameclass={{"Гриб","Рыжик", "Белый", "Маслюк", "Груздь", "Мухомор"},
            {"Растение","Картошка", "Капуста", "Лук", "Чеснок", "Пшеница", "Рис", "Щавель", "Томат", "Огурец", "Тыква", "Кабачок", "Петрушка", "Кинза", "Буряк", "Горох", "Фасоль"},
            {"Трава","Зверобой", "Лаванда", "Мята", "Шалфей", "Материнка"},
            {"Сорняк","Одуванчик", "Пырей", "Лебеда", "Горчица", "Ромашка", "Василёк"},
            {"Кустарник","Смородина", "Крыжовник", "Рябина", "Малина", "Ежевика"},
            {"Дерево","Вишня", "Орех", "Яблоня", "Персик", "Груша", "Абрикос", "Черешня", "Слива", "Алыча", "Шелковица", "Айва"},
            {"Животное","Обезьяна", "Собака", "Кот", "Мышь", "Корова", "Овца", "Свинья", "Петух", "Курица", "Рыба"},
            {"Рептилия","Ящерица", "Черепаха", "Варан", "Крокодил", "Змея", "Уж", "Геккон"},
            {"Человек","Европеец", "Русотуристо", "ДревнийУкр", "Америкос", "Кореец", "Китаец", "Индиец", "Африканец"}};

    public int lengthnameclass= nameclass.length;

    public String getname(int iclass,int ipodclass){
        String sname="Класс не определён";
        if ((iclass>=0)&&(iclass<=lengthnameclass)) {
            if ((ipodclass>=0)&&(ipodclass<=nameclass[iclass].length)) {
                sname = iclass+" "+ipodclass+" "+nameclass[iclass][ipodclass];
            }

        }
        return sname;
    }
    public int getlenclass() {
        return nameclass.length;
    }
    public int getlenpodclass(int iclass) {
        return nameclass[iclass].length;
    }
}

class Pet {
    int production=2;
    int toeat=3;
    int tosearch=4;
    int todrink=5;
    public Pet() {System.out.println("Вход в Pet 1"); }
    void eat(){ System.out.println("eat pet "+toeat);}
    void drink(){ System.out.println("search "+tosearch);}
    void production(){ System.out.println("drink "+todrink);}
}

class Animal extends Pet{
    public Animal() {System.out.println("Вход в Анимал 1"); }
    void eat(){ System.out.println("eat animal "+toeat);}
    void drink(){ System.out.println("search "+tosearch);}
    void production(){ System.out.println("drink "+todrink);}
}


class Dog extends Animal{
    int buf=9;
    public Dog() {System.out.println("Вход в Dog 1"); }
    void eat(){ System.out.println("eat dog "+buf);}
}


class Temptest {

}

public class App 
{

    public static void main( String[] args )
    {

        Animal MyDog=new Dog();
        Animal Animals = new Animal();
        Pet MyPet = new Pet();
        MyPet.eat();
        MyDog.eat();
        Animals.eat();
        MyPet.eat();

        ArrayList<String> cars = new ArrayList<String>();
        cars.add(0,"BMW");
        cars.add(1,"Ford");
        cars.add(2,"Mazda");
        cars.add(3,"Volvo");
        System.out.println(cars);
        if (cars.contains("Ford")) {System.out.println("Ford est");cars.remove("Ford");}
        System.out.println(cars);
        for (String elements:cars) {System.out.println(elements);}

        String sdate;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date(System.currentTimeMillis());
        sdate=formatter.format(date).toString();      //01234567890123456789012345
        System.out.println(sdate+" "+date.toString());//2020-12-12 18:54:04.990
        System.out.println(sdate.substring(0,4)+sdate.substring(5,7)+sdate.substring(8,10)+sdate.substring(11,13)+sdate.substring(14,16)+sdate.substring(17,19)+sdate.substring(20,23));
        String s = "01234567890";
        int yyyy=Integer.parseInt(sdate.substring(0,4));
        System.out.println(yyyy);
        //+sdate.substring(17,18))+sdate.substring(20,22));
//        System.out.println(LocalDateTime.now().toString());
//        System.out.println(ZonedDateTime.now().toString());
//        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
//        NameClass nc=new NameClass();
//       for (int ic=0;ic<nc.lengthnameclass;ic++){
//           for (int jc=0;jc<nc.getlenpodclass(ic);jc++) {
//               System.out.println(nc.getname(ic, jc));
//           }
//       }
        ArrayList<Pet> p = new ArrayList<Pet>();
        p.add(MyPet);
        System.out.println(p.toString());
//        Scanner is=new Scanner(System.in);
//        String inp=null;
//        inp=is.nextLine().toUpperCase();
        int loc=0;
        int incr=5;
        loc+=incr;
        System.out.println(loc);
        String tmp;
        String alphabet="abcdefghjk";
        tmp=String.valueOf(alphabet.charAt(loc));

    }
}
